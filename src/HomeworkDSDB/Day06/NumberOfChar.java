package HomeworkDSDB.Day06;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfChar {
    /*"aababcabcdabcde",获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)*/


    public static void main(String[] args) {
        String s = "aababcabcdabcde";
        Map<String,Integer> numberOfChar = new HashMap<>();
        String[] split = s.split("");
        for (String s1 : split) {
            numberOfChar.put(s1,numberOfChar.getOrDefault(s1,0)+1);
        }
        for (Map.Entry<String, Integer> characterIntegerEntry : numberOfChar.entrySet()) {
            System.out.print(characterIntegerEntry.getKey()+"("+characterIntegerEntry.getValue()+")");
        }
    }

}
