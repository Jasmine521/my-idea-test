package Stack;
import java.util.*;

public class Main1 {
    public static void main(String[] args){
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
        System.out.println(hex);
        hex = toHex(125700);
        System.out.println(hex);
    }

    /**
     * 十进制转16进制
     * @param n
     * @return
     */
    static String toHex(int n) {
        Deque<Character> stack = new LinkedList<>();
        int r=0,x=n;
        do{
            r=x%16;
            x=x/16;
            char ch;
            if(r<10){
                ch = (char)(r+'0');
            }
            else {
                ch = (char)('A'+(r-10));
            }
            stack.push(ch);

        }while (x!=0);
        StringBuilder ans = new StringBuilder();
        while(stack.peek()!=null){
                char ch = stack.pop();
              ans.append(Character.toString(ch));
        }
        return ans.toString();
    }
}
