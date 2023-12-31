package HomeworkDSDB.Day07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListSquare {
    /*
    * 给定一个数字列表, 如何返回一个由每个数的平方构成的列表?
        // [1,2,3,4,5] -> [1,4,9,16,25]
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        * */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //List<>声明列表元素的类型
        List<Integer> collect = list.stream().map(integer -> integer * integer).collect(Collectors.toList());
        System.out.println(collect);
    }
}
