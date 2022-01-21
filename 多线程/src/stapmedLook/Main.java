package stapmedLook;

import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Point point = new Point();
        Thread a = new Thread() {
            public void run() {
                for (int o = 1; ; o++) {
                    SecureRandom sr = null;
                    try {
                        sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
                    } catch (NoSuchAlgorithmException e1) {
                        sr = new SecureRandom(new byte[]{(byte) 12, (byte) 3}); // 获取普通的安全随机数生成器
                    }
                    double x = sr.nextDouble() * (500.0);
                    double y = sr.nextDouble() * (500.0);
                    point.move(x, y);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        };
        Thread b = new Thread() {
            public void run() {
                for (int i = 1; ; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        return;
                    }
                    System.out.println(point.distanceFromOrigin());

                }
            }

        };
        a.start();
        b.start();
        Thread.sleep(1000);
        a.interrupt();
        b.interrupt();
        a.join();
        b.join();
        System.out.println("ENDING:" + point.distanceFromOrigin());
    }
}

class Point {
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock(); // 获取写锁
        try {
            x = deltaX;
            y = deltaY;
        } finally {
            stampedLock.unlockWrite(stamp); // 释放写锁
        }
    }

    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead(); // 获得一个乐观读锁
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
        double currentY = y;
        // 此处已读取到y，如果没有写入，读取是正确的(100,200)
        // 如果有写入，读取是错误的(100,400)
        if (!stampedLock.validate(stamp)) { // 检查乐观读锁后是否有其他写锁发生
            stamp = stampedLock.readLock(); // 获取一个悲观读锁
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp); // 释放悲观读锁
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
