package keepsoft.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlDown {
	  /** 
     * 下载页面的具体函数实现 
     *  
     * @param str 
     *            输入的地址 
     */  
    public static void downloadPage(String str) {  
        BufferedReader br = null;  
        FileOutputStream fos = null;  
        OutputStreamWriter osw = null;  
        String inputLine;  
        try {  
            URL url = null;  
            url = new URL(str);  
  
            // 通过url.openStream(),来获得输入流  
            br = new BufferedReader(new InputStreamReader(url.openStream(),  
                    "UTF-8"));  
  
            File file = new File("D:/download.html");  
            fos = new FileOutputStream(file);  
            osw = new OutputStreamWriter(fos, "utf-8");  
  
            // 将输入流读入到临时变量中，再写入到文件  
            while ((inputLine = br.readLine()) != null) {  
                osw.write(inputLine);  
                // System.out.println(inputLine);  
            }  
              
            br.close();  
            osw.close();  
            System.err.println("下载完毕!");  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (br != null && osw != null) {  
                    br.close();  
                    osw.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        // 此处做测试  
    	HtmlDown.downloadPage("http://xxfb.hydroinfo.gov.cn/ssIndex.html");  
    }  
  
}
