package keepsoft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class Test {

	public static void main(String[] args) {
		try {
			File file = new File("D:\\bastin.json");
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String str = "", line = "";
			StringBuilder sb = new StringBuilder();
			while ((line = buffer.readLine()) != null) {
				sb.append(line);
			}
			str = sb.toString();
			String[] sp = str.split(",");
			List<Double> listX = new ArrayList<>();
			List<Double> listY = new ArrayList<>();
			Arrays.stream(sp).forEach(s -> {
				if (s.trim().startsWith("1")) {
					listX.add(Double.valueOf(s.trim()));
				}
				if (s.trim().startsWith("3")) {
					listY.add(Double.valueOf(s.trim()));
				}
			});
			List<Point> pointList = new ArrayList<Point>();

	
			ForkJoinPool forkjoinPool = new ForkJoinPool(10);

			Fenzhi task = new Fenzhi(0, listX.size()-1);
			Lei.setValue(listX, listY);
			// 执行一个任务
			ForkJoinTask<List<Point>> submit = forkjoinPool.submit(task);

			try {

				System.out.println(submit.get().size());
			} catch (Exception e) {
				System.out.println(e);
			}
			forkjoinPool.shutdown();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
