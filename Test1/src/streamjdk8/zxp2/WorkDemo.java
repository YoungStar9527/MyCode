package streamjdk8.zxp2;

import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;


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
		 new Transaction(brian,Currency.getInstance(Locale.CHINA), 2011, 300),
		 new Transaction(raoul,Currency.getInstance(Locale.JAPAN), 2012, 1000),
		 new Transaction(raoul,Currency.getInstance(Locale.JAPAN), 2011, 400),
		 new Transaction(mario,Currency.getInstance(Locale.JAPAN), 2012, 710),
		 new Transaction(mario,Currency.getInstance(Locale.US), 2012, 700),
		 new Transaction(alan,Currency.getInstance(Locale.US), 2012, 950)
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
		
		//Optional<Transaction> min=transactions.stream().reduce((a,b)-> a.getValue()<b.getValue()?a:b);//8-1利用reduce返回最小交易
		Optional<Transaction> min=transactions.stream().min(comparing(Transaction::getValue));//8-2利用流min方法返回最小交易
		System.out.println(min.get().getValue());//8
		//workDemo();
	}
	public static void  workDemo(){
		/**斐波纳契数列是著名的经典编程练习。下面这个数列就是斐波纳契数列的一部分：0, 1, 1,
			2, 3, 5, 8, 13, 21, 34, 55…数列中开始的两个数字是0和1，后续的每个数字都是前两个数字之和。
			斐波纳契元组序列与此类似，是数列中数字和其后续数字组成的元组构成的序列：(0, 1),
			(1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21) …
			你的任务是用iterate方法生成斐波纳契元组序列中的前20个元素。*/
		/*Stream.iterate(new int[]{0,1},n->new int[]{n[1],n[0]+n[1]}).limit(20)
		.forEach(a->{System.out.println("("+a[0]+","+a[1]+")");});//斐波纳契元组序列
		//.forEach(a->{System.out.println(a[0]);});//斐波纳契数列*/		
		IntSupplier fib = new IntSupplier(){
			private int previous = 0;//第n位
			private int current = 1;//第n+1位
			public int getAsInt(){
				int oldprevious=this.previous;//现将第n位存入变量
				int newcurrent=this.previous+this.current;//生成下个个序列第n+2位
				this.previous=this.current;//n位=n+1位,向前进一位
				this.current=newcurrent;//n+1位=n+2位,向前进一位
				return oldprevious;//返回第n位
			}
		};
		IntStream.generate(fib).limit(10).forEach(System.out::println); 
	}
}
