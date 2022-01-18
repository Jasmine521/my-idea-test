package list;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 洗牌算法shuffle可以随机交换List中的元素位置:
        Collections.shuffle(list);

        while(true){
            Collections.shuffle(list);
            int k=start;
            int flag=0;
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i)==k++){

                }
                else {
                    flag=1;
                    break;
                }
            }
            if(flag==0) break;
        }
        System.out.println(list.toString());
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }
    static int findMissingNumber(int start, int end, List<Integer> list) {
        Integer i = Integer.valueOf(start);
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(new Integer[list.size()])) ;
        List<Integer> list1 = new ArrayList<>(list);
        //Collections.copy(list1,list);
        boolean f = true;
        for(;i<Integer.valueOf(end);i++){
           f = list1.remove(i);
           if(!f) break;
        }

        return i.intValue();
    }

}