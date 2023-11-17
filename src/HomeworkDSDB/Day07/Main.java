package HomeworkDSDB.Day07;

import java.util.*;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = new TransactionRecord().transactions; // 假设已经初始化了交易记录列表

        // 找出2011年发生的交易记录, 按照从低到高交易额排序
        List<Transaction> transactionsIn2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
//                .sorted(Comparator.comparingInt(t -> t.getValue()))
                .sorted((t1, t2) -> t1.getValue() - t2.getValue())
                .collect(Collectors.toList());
        System.out.println(transactionsIn2011);

        // 找出交易员都在哪些不同的城市工作过的城市
        Set<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());
        //toSet()去重
        System.out.println(cities);

        // 查找来自北京的交易, 按交易员姓名排序
        List<Transaction> beijingTransactions = transactions.stream()
                .filter(transaction ->  false)
                .sorted((o1, o2) -> o1.getTrader().getName().compareTo(o2.getTrader().getName()))//❓ 比较器
                .collect(Collectors.toList());
        System.out.println(beijingTransactions);

        // 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
        String allTraders = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()//自然排序
                .collect(Collectors.joining(", "));
        System.out.println(allTraders);

        // 判断有没有交易员在北京工作
        boolean anyTraderInBeijing = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("beijing"));
        System.out.println(anyTraderInBeijing);


        // 打印所有发生在北京的交易记录金额
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("beijing"))
                .mapToInt(t -> t.getValue())
                .forEach(System.out::println);


        // 所有交易中最高的交易是多少
        OptionalInt maxAmount = transactions.stream()
                .mapToInt(t -> t.getValue())
                .max();
        System.out.println(maxAmount);

        // 所有交易中, 交易最低的交易信息
        Optional<Transaction> minTransaction = transactions.stream()
                .min(Comparator.comparingInt(t -> t.getValue()));
        System.out.println(minTransaction);
    }
}
