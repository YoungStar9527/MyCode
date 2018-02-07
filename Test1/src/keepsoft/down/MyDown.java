package keepsoft.down;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyDown {

	 public static final String HTTp_URL="http:下载链接";
    public static void main(String[] args) {
            Dol();
    }
        public static void Dol(){
            BufferedInputStream bis=null;
            BufferedOutputStream bos=null;
    try {
        URL url = new URL(HTTp_URL);
        HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        InputStream is = connection.getInputStream();
        
        bis = new BufferedInputStream(is);
        
        File file = new File("D:/test/"+HTTp_URL.substring((HTTp_URL.lastIndexOf("/"))));//名字截取 可以省略
        FileOutputStream fos = new FileOutputStream(file);
        bos = new BufferedOutputStream(fos);
        int b = 0;
        byte[] byArr = new byte[1024*4];
        while((b=bis.read(byArr))!=-1){
            bos.write(byArr, 0, b);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        try {
            if(bis!=null){
                bis.close();
            }
            if(bos!=null){
                bos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
