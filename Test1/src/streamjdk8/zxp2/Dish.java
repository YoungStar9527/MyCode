package streamjdk8.zxp2;

public class Dish {
	/**final 成员变量在创建对象时必须初始化(赋值),有且只能赋值一次,空构造会报错*/
	 private final String name;
	 private final boolean vegetarian;
	 private final int calories;
	 private final Type type;
	 public Dish(String name, boolean vegetarian, int calories, Type type) {
	 this.name = name;
	 this.vegetarian = vegetarian;
	 this.calories = calories;
	 this.type = type;
	 }
	 public String getName() {
	 return name;
	 }
	 public boolean isVegetarian() {
	 return vegetarian;
	 }
	 public int getCalories() {
	 return calories;
	 }
	 public Type getType() {
	 return type;
	 }
	 @Override
	 public String toString() {
	 return name;
	 }
	 public enum Type { MEAT, FISH, OTHER }
	} 
