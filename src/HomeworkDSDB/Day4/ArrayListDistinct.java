package HomeworkDSDB.Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDistinct {
        /*假设有一个字符串"abcqweracb" 在不改变前后顺序的前提下```去除重复的字符```得到"abcqwer"(结合使用ArrayList)*/
        public static void main(String[] args) {
            //先把字符串变成ArrayList:字符串变成数组 数组再变成ArrayList
            String str = "abcqweracb";
            char[] chars = str.toCharArray();
            System.out.println(Arrays.toString(chars));
            String[] split = str.split("");
            System.out.println(Arrays.toString(split));
            Arrays.sort(split);
            List<String> list = Arrays.asList(split);
            for (String s : list) {
                System.out.print(s+" ");
            }
            System.out.println();
            int fast = 0;
            int slow = 0;
            while(fast<list.size()){
                if(!list.get(fast).equals(list.get(slow))){
                    list.set(slow+1,list.get(fast)) ;
                    slow++;
                }
                fast++;
            }
            for (int i =0;i<=slow;i++){
                System.out.print(list.get(i)+" ");
            }
        }

}
