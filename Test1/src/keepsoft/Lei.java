package keepsoft;

import java.util.List;

public class Lei {
	private static List<Double> listX;
	private static List<Double> listY;
	public static List<Double> getListX() {
		return listX;
	}
	public static List<Double> getListY() {
		return listY;
	}
	public static void setValue(List<Double> x,List<Double> y){
		listX = x;
		listY = y;
	}
	
	
	
}
