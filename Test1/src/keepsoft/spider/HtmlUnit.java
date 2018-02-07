package keepsoft.spider;

import java.io.IOException;
import java.net.MalformedURLException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnit {
	public static void main(String[] args) {
		final WebClient webClient=new WebClient();
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(true);
		HtmlPage page;
		try {
			page = webClient.getPage("http://xxfb.hydroinfo.gov.cn/svg/svgwait.jsp?gcxClass=2&gcxKind=1&DateL=2017-10-10&DateM=2017-10-17&gcxData=8&site=10501820");
			//InputStream   in_nocode   =   new   ByteArrayInputStream(page.asXml().getBytes("UTF-8"));   
			//Document doc = Jsoup.parse(in_nocode, "UTF-8", "http://xxfb.hydroinfo.gov.cn/ssIndex.html");
			//System.out.println(new String(page.asText().getBytes("ISO-8859-1"),"GBK"));
			System.out.println(page.asText());
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		webClient.closeAllWindows();
	}
}
