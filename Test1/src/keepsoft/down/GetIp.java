package keepsoft.down;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

public class GetIp {
	/**
     * 从Request对象中获得客户端IP，处理了HTTP代理服务器和Nginx的反向代理截取了ip
     * @param request
     * @return ip
     */
	public static void main(String[] args) {
		InetAddress addr;
		
		try {
			addr = InetAddress.getLocalHost();
			System.out.println(addr.getHostAddress());//获得本机IP
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
