package keepsoft.spider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitNew {
	//HtmlUnit 获取网页数据
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		WebClient webClient = new WebClient(BrowserVersion.CHROME);  
	    webClient.getOptions().setJavaScriptEnabled(true);//允许加载js
	    webClient.getOptions().setCssEnabled(false);//不允许加载css
	    webClient.getOptions().setRedirectEnabled(true);
	    webClient.getOptions().setThrowExceptionOnScriptError(false);
	    webClient.getOptions().setTimeout(0);//不限制相应时间
	    final HtmlPage rootPage = webClient.getPage("http://xxfb.hydroinfo.gov.cn/ssIndex.html");  
	    webClient.waitForBackgroundJavaScript(12000);//等待js加载12秒后获取页面
	    String[] b=rootPage.asText().split("\n");//将获取的页面数据转化为数组
	    FileWriter fw=null;
		try{
			File water=new File("D:/water1.txt");
			if(!water.exists()){
				water.createNewFile();
			}
			fw=new FileWriter("D:/water1.txt");
			//fw.write(rootPage.asXml());
			String[] strs=null;
			StringBuilder sbr=new StringBuilder("");
			for(int i=0;i<b.length;i++){
				strs=b[i].split("\t");
				for(int j=0;j<strs.length;j++){
					if(j==0){
						sbr.append(i+"\t");
					}
					sbr.append("/"+strs[j]+"\t");
				}
				
			}
			fw.write(sbr.toString());
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			fw.close();
			System.out.println("success");
		}
		
	    //System.out.println(rootPage.asText());
	    //FileUtils.createFile(DIRECTORY+"cc.html", rootPage.asXml());
	    webClient.closeAllWindows();
    }
}
