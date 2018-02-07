package streamjdk8.zxp2;

import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.*;

public class WorkDemo {
	public static void main(String[] args) {
		/** (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
			(2) 交易员都在哪些不同的城市工作过？
			(3) 查找所有来自于剑桥的交易员，并按姓名排序。
			(4) 返回所有交易员的姓名字符串，按字母顺序排序。
			(5) 有没有交易员是在米兰工作的？
			(6) 打印生活在剑桥的交易员的所有交易额。
			(7) 所有交易中，最高的交易额是多少？
			(8) 找到交易额最小的交易。*/
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		List<Transaction> transactions = Arrays.asList(
		 new Transaction(brian, 2011, 300),
		 new Transaction(raoul, 2012, 1000),
		 new Transaction(raoul, 2011, 400),
		 new Transaction(mario, 2012, 710),
		 new Transaction(mario, 2012, 700),
		 new Transaction(alan, 2012, 950)
		);
		List<Trader> treaders=new ArrayList<>();
		treaders.add(raoul);
		treaders.add(mario);
		treaders.add(alan);
		treaders.add(brian);
//		transactions.stream().filter(a->a.getYear()==2011).sorted(comparing(Transaction::getValue)).forEach(System.out::println);//1
		
//		treaders.stream().map(a->a.getCity()).distinct().forEach(System.out::println);//2
		
//		treaders.stream().filter(a->a.getCity().equals("Cambridge")).sorted(comparing(Trader::getName)).forEach(System.out::println);//3
		
//		String traderStr =
//				 transactions.stream()
//				 .map(transaction -> transaction.getTrader().getName())
//				 .distinct()
//				 .sorted()
//				 .reduce("", (n1, n2) -> n1 + n2);//4第一种利用reduce累加字符串将姓名拼成一串
//		String traderStr =
//				 transactions.stream()
//				 .map(transaction -> transaction.getTrader().getName())
//				 .distinct()
//				 .sorted()
//				 .collect(joining());
//		System.out.println("\n"+traderStr);////4第二种利用joining方法拼接字符串
		
//		boolean flag=treaders.stream().anyMatch(a->a.getCity().equals("Milan"));
//		System.out.println(flag);//5
		
//		transactions.stream().filter(a->a.getTrader().getCity()=="Cambridge")
//		.map(a->a.getValue()).forEach(System.out::println);//6
	
//		Integer max=transactions.stream().map(a->a.getValue()).reduce(0,Integer::max);
//		System.out.println(max);//7
		
//		Optional<Transaction> min=transactions.stream().reduce((a,b)-> a.getValue()<b.getValue()?a:b);//8-1利用reduce返回最小交易
		Optional<Transaction> min=transactions.stream().min(comparing(Transaction::getValue));//8-2利用流min方法返回最小交易
		System.out.println(min.get().getValue());//8
	}
}
