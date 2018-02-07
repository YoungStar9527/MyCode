package streamjdk8.zxp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Apple {
	private  String color;
	private  Integer weight;
	public Apple(){}
	public Apple(Integer i){
		this.weight=i;
	}
	public  String getColor() {
		return color;
	}
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static boolean isGreenApple(Apple apple){
		return "green".equals(apple.getColor());
	}
	public static boolean isHeavyApple(Apple apple){
		return 150<apple.getWeight();
	}
	static <T> Collection<T> filter(Collection<T> c, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		 for (T auto: c){
			 //System.out.println(apple.getColor());
			 if (p.test(auto)) {
				 result.add(auto);
			 }
		 }
		return result;
	} 
	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		 List<Apple> result = new ArrayList<>();
		 for (Apple apple: inventory){
			 //System.out.println(apple.getColor());
			 if (p.test(apple)) {
				 result.add(apple);
			 }
		 }
		 return result;
	}

}
