package streamjdk8.zxp2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestDome2 {
	public static void main(String[] args) {
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
		/**数值流*/
		/*int calories = menu.stream()
				 .mapToInt(Dish::getCalories)
				 .sum();//mapToInt返回一个特化流IntStream(而不是一个Stream<Integer>),然后调用IntStream接口中的sum方法求和,支持max、min、average等方法
		System.out.println(calories);*/
		
//		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);//Stream转化为数值流
//		Stream<Integer> stream = intStream.boxed();//将数值流转化为流Stream
		
		/*OptionalInt maxCalories = menu.stream()
				 .mapToInt(Dish::getCalories)
				 .max();//调用max方法，它会返回一个OptionalInt
		int max = maxCalories.orElse(5);//如果没有最大值的话，显式提供一个默认最大值5
		System.out.println(maxCalories.getAsInt()+"\n"+max);*/
		
//		IntStream evenNumbers = IntStream.rangeClosed(1, 100);
//				 .filter(n -> n % 2 == 0);//rangeClosed第一个参数接受起始值，第二个参数接受结束值,生成范围内数值,包含两端
//		IntStream evenNumbers = IntStream.range(1, 100)
//				 .filter(n -> n % 2 == 0);//range第一个参数接受起始值，第二个参数接受结束值,生成范围内数值,不包含结束值
//		System.out.println(evenNumbers.count());
		
//		Stream<int[]> pythagoreanTriples =
//				 IntStream.rangeClosed(1, 100).boxed()
//				 .flatMap(a ->IntStream.rangeClosed(a, 100)//flatMap方法在做映射的同时，还会把所有生成的三元数流扁平化成一个流
//				 .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)//Math.sqrt求平方根
//				 .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)}));//mapToObj将数值流返回对应的Stream流
//				 //.forEach(a->{System.out.println(a[0]+","+a[1]+","+a[2]);});
//		pythagoreanTriples.forEach(a->{System.out.println(a[0]+","+a[1]+","+a[2]);});
//		Stream<double[]> pythagoreanTriples2 =
//				 IntStream.rangeClosed(1, 100).boxed()
//				 .flatMap(a ->
//				 IntStream.rangeClosed(a, 100)
//				 .mapToObj(
//				 b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
//				 .filter(t -> t[2] % 1 == 0)); 
//		pythagoreanTriples2.forEach(a->{System.out.println(a[0]+","+a[1]+","+a[2]);});
		
//		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");//创建字符串流
//		stream.map(String::toUpperCase).forEach(System.out::println); 
//		Stream<String> emptyStream = Stream.empty();//创建空流

		int[] numbers = {2, 3, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers).sum(); //接受数组参数创建流
		System.out.println(sum);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
