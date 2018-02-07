package keepsoft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Du {
	public static List<CSV> getCsv() {
		File csv = new File("D:\\123.csv"); // CSV文件路径
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(csv));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		try {
			List<CSV> list = new ArrayList<CSV>();
			int i = 1;
			while ((line = br.readLine()) != null) // 读取到的内容给line变量
			{
				if(i>1){
					String[] split = line.split(",");
					Double data = Double.valueOf(split[0].trim());
					Double X = Double.valueOf(split[1].trim());
					Double Y = Double.valueOf(split[2].trim());
					CSV model = new CSV();
					model.setData(data);
					model.setX(X);
					model.setY(Y);
					list.add(model);
				}
				i++;
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
