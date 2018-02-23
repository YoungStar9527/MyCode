package streamjdk8.zxp3;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Currency;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import streamjdk8.zxp2.Dish;
import streamjdk8.zxp2.Trader;
import streamjdk8.zxp2.Transaction;

public class TestDemo1 {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		List<Transaction> transactions = Arrays.asList(
		 new Transaction(brian,Currency.getInstance(Locale.CHINA), 2011, 300),
		 new Transaction(raoul,Currency.getInstance(Locale.CHINA), 2012, 1000),
		 new Transaction(raoul,Currency.getInstance(Locale.JAPAN), 2011, 400),
		 new Transaction(mario,Currency.getInstance(Locale.JAPAN), 2012, 710),
		 new Transaction(mario,Currency.getInstance(Locale.CHINA), 2012, 700),
		 new Transaction(alan,Currency.getInstance(Locale.US), 2012, 950)
		);
		List<Trader> treaders=new ArrayList<>();
		treaders.add(raoul);
		treaders.add(mario);
		treaders.add(alan);
		treaders.add(brian);
		List<Dish> menu = /*new ArrayList<>();*/Arrays.asList(
				 new Dish("pork", false, 800, Dish.Type.MEAT),
				 new Dish("beef", false, 200, Dish.Type.MEAT),
				 new Dish("chicken", false, 400, Dish.Type.MEAT),
				 new Dish("french fries", true, 530, Dish.Type.OTHER),
				 new Dish("rice", true, 350, Dish.Type.OTHER),
				 new Dish("season fruit", true, 120, Dish.Type.OTHER),
				 new Dish("pizza", true, 550, Dish.Type.OTHER),
				 new Dish("prawns", false, 300, Dish.Type.FISH),
				 new Dish("salmon", false, 450, Dish.Type.FISH) ); 
//		Map<Currency, List<Transaction>> transactionsByCurrencies =new HashMap<>();
//		for (Transaction transaction : transactions) {
//			Currency currency = transaction.getCurrency();
//			List<Transaction> transactionsForCurrency =
//			transactionsByCurrencies.get(currency);
//			if (transactionsForCurrency == null){
//				transactionsForCurrency = new ArrayList<>();
//				transactionsByCurrencies.put(currency, transactionsForCurrency);
//			}
//			transactionsForCurrency.add(transaction);
//		}//用指令式风格对交易按照货币分组
		
//		Map<Currency, List<Transaction>> transactionsByCurrencies =
//				 transactions.stream().collect(groupingBy(Transaction::getCurrency));//groupingBy对交易按照货币分组
//		Set<Currency> curSet=transactionsByCurrencies.keySet();
//		for (Currency currency : curSet) {
//			System.out.println(transactionsByCurrencies.get(currency).size());
//		}
		
//		Comparator<Dish> dishCaloriesComparator =
//				 Comparator.comparingInt(Dish::getCalories); 
//		Optional<Dish> mostCalorieDish =
//				 menu.stream()
//				 .collect(maxBy(dishCaloriesComparator));//利用Collectors收集器maxBy静态方法计算最大热量的菜
//		System.out.println(mostCalorieDish.get().getName());
		
		/*int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));//利用Collectors收集器summingInt静态方法汇总菜的热量和
		double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));//利用Collectors收集器averagingInt静态方法汇总菜的平均数
		IntSummaryStatistics menuStatistics =
				 menu.stream().collect(summarizingInt(Dish::getCalories));//利用Collectors收集器summarizingInt静态方法汇总菜单的和,平均数等属性
		System.out.println(totalCalories);
		System.out.println(avgCalories);
		System.out.println(menuStatistics.toString());//以上方法都提供了long,double等类型的汇总*/
		
//		String shortMenu = menu.stream().map(Dish::getName).collect(joining(","));//利用Collectors收集器join静态方法,拼接字符串
//		System.out.println(shortMenu);
		
		/*int totalCalories = menu.stream().collect(reducing(
				 0, Dish::getCalories, (i, j) -> i + j));//reducing汇总热量和,参数(起始值,map转化类型方法,BinaryOperator函数求和)
		Optional<Dish> mostCalorieDish =
				 menu.stream().collect(reducing(
				 (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));//reducing汇总最大值,没有起始值,返回Optional类型(可能为空)
		System.out.println(totalCalories);
		System.out.println(mostCalorieDish.get().getCalories());*/
		
		Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
		stream.reduce(new ArrayList<Integer>(), (List<Integer> l, Integer e) -> { l.add(e);return l; },
		(List<Integer> l1, List<Integer> l2) -> {
			l1.addAll(l2);
			return l1;
		})//??(不懂)
		.forEach(System.out::println);
		
		
		
	}
}
