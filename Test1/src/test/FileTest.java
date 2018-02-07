package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileTest {
	public static void main(String[] args) throws IOException {
		String path = "D:/hw.list";
		BufferedReader in = new BufferedReader(new FileReader(path));
		String line = null;
		// 定义一个空字符串来接受读到的字符串
		String str = "";
		int state=0;
		List<StringBuilder> sbrs=new ArrayList<StringBuilder>();
		StringBuilder sbr=null;
		// 循环把读取到的字符赋给str
		while ((line = in.readLine()) != null) {
			//str += line;
			if(line.contains("VOLUMETRIC BUDGET FOR ENTIRE MODEL AT END OF TIME STEP")){
				sbr=new StringBuilder() ;
				state = 1;
			}
			if(line.contains("TIME SUMMARY AT END OF TIME STEP")){
				sbrs.add(sbr);
				state = 0;
			}
			if(state == 1&&!line.equals("")){
				sbr.append(line+"\n");
			}
		}//Character.isDigit() 判断字符是否为一个数字
		Map<String,String> data=null;
		List<Map<String,String>> allData=new ArrayList<Map<String,String>>();
		for(short i=0;i<sbrs.size();i++){//用将字符串分割为行，利用行来做判断(换方式，用双重循环)
			System.out.println(sbrs.get(i).toString().replaceAll(" ",""));	
		}
	}
}
	

