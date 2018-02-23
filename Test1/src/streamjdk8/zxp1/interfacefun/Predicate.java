package streamjdk8.zxp1.interfacefun;

@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
	public static Predicate<String>  TestInterface(){
		return new Predicate(){
			@Override
			public boolean test(Object t) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
}
