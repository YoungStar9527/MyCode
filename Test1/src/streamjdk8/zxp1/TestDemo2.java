package streamjdk8.zxp1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;

import streamjdk8.zxp1.interfacefun.BufferedReaderProcessor;

public class TestDemo2 {
	public static void main(String[] args) {
		/**lambda简化io操作*/
		/*try {
			String text=processFile((BufferedReader buf) -> buf.readLine()+buf.readLine());
			System.out.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		//List<? extends String> list2 = new ArrayList<>();
		/*Function<BufferedReader, String> f = (BufferedReader b) -> {
			 try {
			 return b.readLine();
			 }
			 catch(IOException e) {
			 throw new RuntimeException(e);
			 }
			};*/
		/**lambda抽象化循环内操作*/
		//forEarch(Arrays.asList("1","2","3"),(String i)-> System.out.println(i));
		//List<Integer> result =map(Arrays.asList("list","map","set"),(String s)-> s.length());
		/*List<Integer> result =map(Arrays.asList("list","map","set"),String :: length);
		forEarch(result,(Integer i)-> System.out.println(i));*/
		/**其他lambda表达式操作*/
		/*List list=new ArrayList();
		Predicate<String> p = s -> list.add(s); 
		p.test("123");
		System.out.println("aa"+list.size());*/
		/*BiPredicate<Integer,Integer> bo= (a, b) -> true;*/
		/*final int portNumber = 1337;
		Runnable r = () -> System.out.println(portNumber);*/
		/**lambda表达式传递方法*/
		/*List<String> str = Arrays.asList("a","b","A","B");
		//str.sort((s1, s2) -> s1.compareToIgnoreCase(s2)); 
		str.sort(String::compareToIgnoreCase);
		for (String string : str) {
			System.out.println(string);
		}*/
		/**lambda表达式传递构造方法*/
/*//		BiPredicate<List<String>, String> contains =(list, element) -> list.contains(element);
//		Function<String, Integer> stringToInteger =(String s) -> Integer.parseInt(s);
//		Function<Integer, Apple> c2 = (weight) -> new Apple(weight);
//		Supplier<Apple> c1=()->new Apple();
		BiPredicate<List<String>, String> contains = List::contains; 
		Function<String, Integer> stringToInteger = Integer::parseInt;
		Supplier<Apple> c1 = Apple::new; 
		Apple a1 = c1.get();//引用构造方法
		Function<Integer, Apple> c2 = Apple::new;
		Apple a2 = c2.apply(110);//引用构造方法
		List<Integer> weights = Arrays.asList(7, 3, 4, 10);
		List<Apple> apples = map(weights, Apple::new); 
		for (Apple apple : apples) {
			System.out.println(apple.getWeight());
		}*/
		/**其他lambda表达式操作2*/
		/*List<Apple> inventory=new ArrayList<Apple>();
		Apple app1=new Apple();
		app1.setColor("green");
		app1.setWeight(18);
		Apple app2=new Apple();
		app2.setColor("red");
		app2.setWeight(8);
		inventory.add(app1);
		inventory.add(app2);
		//Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight()); 
		//inventory.sort(comparing((a) -> a.getWeight())); //利用Comparator.comparing方法返回int实现Comparator
		//inventory.sort(comparing(Apple :: getWeight).reversed());//reversed()逆序排序
		inventory.sort(comparing(Apple :: getWeight).reversed().thenComparing(Apple :: getColor));//thenComparing多重排序，上一层排序相同则调用*
		
		Predicate<Apple> redApple = a-> "red".equals(a.getColor());
		Predicate<Apple> notRedApple = redApple.negate();
		Predicate<Apple> redAndHeavyApple =redApple.and(a -> a.getWeight() > 150);
		*//**and和or方法是按照在表达式链中的位置,a.or(b).and(c)可以看作(a || b) && c*//*
		Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(a -> a.getWeight() > 150).or(a -> "green".equals(a.getColor()));
		List<Apple> inventoryNew=(List<Apple>)Apple.filter(inventory,redAndHeavyAppleOrGreen);
		for (Apple apple : inventoryNew) {
			System.out.println(apple.getColor()+":"+apple.getWeight());
		}*/
		/**其他lambda表达式复合操作*/
		/*Function<Integer, Integer> f = x -> x + 2;
		Function<Integer, Integer> g = x -> x * 2;
		//Function<Integer, Integer> h = f.andThen(g);//数学上会写作g(f(x))或(g o f)(x)
		Function<Integer, Integer> h = f.compose(g);//f(g(x))或(f o g)(x)
		int result = h.apply(1);
		System.out.println(result);*/
		/**lambda表达式实际引用例子*/
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline
		 = addHeader.andThen(Letter::checkSpelling)
		 .andThen(Letter::addFooter); 
		String twly=transformationPipeline.apply("是兄弟就一起来玩贪玩蓝月");
		System.out.println(twly);
		Double fx=integrate( x-> x+10,3,7);
		System.out.println(fx);
	}
	//1/2 × ((3 + 10) + (7 + 10)) × (7 – 3) = 60 
	public static double integrate(DoubleFunction<Double> f, double a, double b) {
		 return (f.apply(a) + f.apply(b)) * (b-a) / 2.0;
	} 
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(
			BufferedReader br =new BufferedReader(new FileReader("E:/123.txt"))
		){
			return p.proess(br);
		}
	}
	public static<T> void forEarch(List<T> list,Consumer<T> csr){
		for (T t : list) {
			csr.accept(t);
		}
	}
	public static <T, R> List<R> map(List<T> list,Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for(T s: list){
			result.add(f.apply(s));
		}
		return result;
	}
}
