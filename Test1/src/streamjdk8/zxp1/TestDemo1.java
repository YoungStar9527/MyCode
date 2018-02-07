package streamjdk8.zxp1;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import static java.util.stream.Collectors.toList; 
public class TestDemo1 {
	public static void main(String[] args) {
		/**利用java8简化file类操作*/
		/*File[] hiddenFiles = new File("E:\\test").listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isHidden();
			}
		});
		for (File file : hiddenFiles) {
			System.out.println(file.getName());
		}*/
		
//		File[] hiddenFiles = new File("E:/test").listFiles(File::isHidden); 
//		for (File file : hiddenFiles) {
//			System.out.println(file.getName());
//		}
		/**利用java8简化bean的操作*/
		List<Apple> inventory=new ArrayList<Apple>();
		Apple app1=new Apple();
		app1.setColor("green");
		app1.setWeight(18);
		Apple app2=new Apple();
		app2.setColor("yello");
		app2.setWeight(160);
		inventory.add(app1);
		inventory.add(app2);
		List<Apple> appfs=Apple.filterApples(inventory, Apple::isHeavyApple);
		//List<Apple> appfs=Apple.filterApples(inventory, (Apple a) -> "green".equals(a.getColor())||a.getWeight()<150 );
		//List<Apple> appfs=(List<Apple>) Apple.filter(inventory, (Apple a) -> a.getWeight() > 150 );
		//List<Apple> appfs =inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());//流式处理
		//List<Apple> appfs =inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(toList());//并行处理
//		List<Apple> appfs = Apple.filterApples(inventory, new Predicate<Apple>() {
//			public boolean test(Apple t) {
//			  return "yello".equals(t.getColor());
//			}
//		});//匿名类实现接口
		for (Apple apple : appfs) {
			System.out.println(apple.getColor()+":"+apple.getWeight());
		}
		/*inventory.sort(new Comparator<Apple>(){
			public int compare(Apple a1,Apple a2){
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		inventory.sort((Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));//给集合排序	
		for (Apple apple : inventory) {
			System.out.println(apple.getWeight());
		}*/
		/**利用java8简化线程的操作*/
//		Thread thread=new Thread(new Runnable(){
//			public void run(){
//				System.out.println("hello lambda");
//			}
//		});
		Thread thread=new Thread(()-> System.out.println("hello lambda"));
		thread.start();
	}
}
