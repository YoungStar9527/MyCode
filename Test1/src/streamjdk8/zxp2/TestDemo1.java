package streamjdk8.zxp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
/**
 * static import是Java 5增加的功能。
 * 就是将Import类中的静态方法，可以作为本类的静态方法来用
 * */
public class TestDemo1 {
	public static void main(String[] args) {
		/**java8 Stream(流的使用)*/
		List<Dish> menu = Arrays.asList(
				 new Dish("pork", false, 800, Dish.Type.MEAT),
				 new Dish("beef", false, 200, Dish.Type.MEAT),
				 new Dish("chicken", false, 400, Dish.Type.MEAT),
				 new Dish("french fries", true, 530, Dish.Type.OTHER),
				 new Dish("rice", true, 350, Dish.Type.OTHER),
				 new Dish("season fruit", true, 120, Dish.Type.OTHER),
				 new Dish("pizza", true, 550, Dish.Type.OTHER),
				 new Dish("prawns", false, 300, Dish.Type.FISH),
				 new Dish("salmon", false, 450, Dish.Type.FISH) ); 
//		List<Dish> lowCaloricDishes = new ArrayList<>();
//		for(Dish d: menu){
//			if(d.getCalories() < 400){
//				lowCaloricDishes.add(d);
//			}
//		}
//		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
//		 public int compare(Dish d1, Dish d2){
//		 return Integer.compare(d1.getCalories(), d2.getCalories());
//		 }
//		});
//		List<String> lowCaloricDishesName = new ArrayList<>();
//		for(Dish d: lowCaloricDishes){
//		 lowCaloricDishesName.add(d.getName());
//		} 
		/*List<String> lowCaloricDishesName =
		menu.stream().filter(d -> {
			//System.out.println(d.getName());
			return d.getCalories() < 400;
			}).sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
		for (String string : lowCaloricDishesName) {
			System.out.println(string);
		}*/
		/**流的使用2*/
		/*List<String> title = Arrays.asList("Java8", "In", "Action");
		Stream<String> s = title.stream();
		s.forEach(System.out::println);
		s.forEach(System.out::println);//流只能被消费一次(遍历流就是在消费)*/
		/*List<String> names =
				 menu.stream()
				 .filter(d -> {
				 System.out.println("filtering" + d.getName());
				 return d.getCalories() > 300;
				 })//.sorted(comparing(Dish::getCalories))
				 .map(d -> {
				 System.out.println("mapping" + d.getName());
				 return d.getName();
				 })//map接受一个对象，返回另一个属性
				 .limit(3)//limit 取前3个元素
				 .collect(toList());//filter,map等方法按照list数据顺序执行,取前3位复合条件的数据循环到第4位已找出3条数据结束就结束了数据流
		menu.stream().forEach(System.out::println); */
		/**流的使用3*/
		/*List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
		 .filter(i -> i % 2 == 0)
		 .distinct()//distinct 去重
		 .forEach(System.out::println); */
		/*List<Dish> dishes = menu.stream()
				 .filter(d -> d.getCalories() > 300)
				 .skip(2)
				 .collect(toList());//skip 跳过头两个元素
		dishes.stream().forEach(System.out::println);*/
		/*List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action"); 
		words.stream()
		.map(w -> w.split(""))
		.flatMap(Arrays::stream)//flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流
		.distinct()
		.collect(Collectors.toList()).forEach(System.out::println);//流和集合都支持forEach方法*/	
		/** 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？例如，给定[1, 2, 3, 4,5]，应该返回[1, 4, 9, 16, 25]*/
		/*List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().map(i -> i*i).forEach(System.out::println);*/
		/** 给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，
		 * 应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代表数对。 */
		/*List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(4,5);
		numbers1.stream().flatMap( i ->
			 numbers2.stream().filter(j -> (i + j) % 3 == 0) 
			 .map( j -> new Integer[]{i,j}))//flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流
		.forEach( list -> System.out.println("["+list[0]+","+list[1]+"]"));
		boolean any=menu.stream().anyMatch(Dish::isVegetarian);//只有一个元素匹配，返回boolean(短路操作)
		boolean all=menu.stream().allMatch(d -> d.getCalories() < 1000);//所有元素匹配，返回boolean(短路操作)
		boolean none=menu.stream().noneMatch(d -> d.getCalories() >= 1000);//没有元素匹配，返回boolean(短路操作)*/	
		/*Optional<Dish> dish =//Optional<T>类（java.util.Optional）是一个容器类，代表一个值存在或不存在
				 menu.stream()
				 .filter(Dish::isVegetarian)
				 .findAny();//findAny返回任意一个值
		System.out.println(dish.get().getName());*/
		/*List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree =
		someNumbers.stream()
		.map(x -> x * x)
		.filter(x -> x % 3 == 0)
		.findFirst(); //findFirst返回第一个值
		System.out.println(firstSquareDivisibleByThree.get());*/
		/**流的使用4*/
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int sum1 = numbers.stream().reduce(1, (a, b) ->  a * b);//reduce 接受两个参数 (初始值,BinaryOperator<T>来将两个元素结合起来产生一个新值) 
		//a第一次循环为初始值,之后则为上一次返回的值,b为集合迭代出的值
		int sum2 = numbers.stream().reduce(0, Integer::sum);
//		int max1 = numbers.stream().reduce(0, (a, b) ->  {
//		});
		int max2 = numbers.stream().reduce(0, Integer::max);
		Optional<Integer> sum = numbers.stream().reduce((a, b) -> (a + b)); //重载 不接收初始值,可能为空 所以返回Optional
		System.out.println(sum.get());
		System.out.println(sum1+","+sum2);
	}
}
