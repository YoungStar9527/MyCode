package keepsoft.spider;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderMain {
	public static void main(String[] args) {
		//String url = "http://xxfb.hydroinfo.gov.cn/ssIndex.html";
        try {
        	URL url = new URL("http://xxfb.hydroinfo.gov.cn/svg/svgwait.jsp?gcxClass=2&gcxKind=1&DateL=2017-10-10&DateM=2017-10-17&gcxData=8&site=10501820");
        	HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        	//默认就是Get，可以采用post，大小写都行，因为源码里都toUpperCase了。
        	connection.setRequestMethod("POST");
        	//是否允许缓存，默认true。
        	connection.setUseCaches(Boolean.FALSE);
        	//是否开启输出输入，如果是post使用true。默认是false
        	connection.setDoOutput(Boolean.TRUE);
        	connection.setDoInput(Boolean.TRUE);
        	//设置请求头信息
        	connection.addRequestProperty("Connection", "close");
        	//设置连接主机超时（单位：毫秒）  
        	connection.setConnectTimeout(8000);  
        	 //设置从主机读取数据超时（单位：毫秒）  
        	connection.setReadTimeout(8000);    
        	//设置Cookie
        	connection.addRequestProperty("Cookie","你的Cookies" );
        	//开始请求
        	Document doc = Jsoup.parse(connection.getInputStream(), "GBK", "http://xxfb.hydroinfo.gov.cn/svg/svgwait.jsp?gcxClass=2&gcxKind=1&DateL=2017-10-10&DateM=2017-10-17&gcxData=8&site=10501820");
			//Elements links=doc.getElementsByClass("sstable");
			System.out.println(doc);
//			for (Element link : links) {
//				  String linkText =link.text();
//				  System.out.println(linkText);
//				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
