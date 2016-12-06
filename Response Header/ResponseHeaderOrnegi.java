package Response;

import java.util.Collection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/ResponseHeader"})
public class ResponseHeaderOrnegi extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		response.setHeader("ad", "ali turk");
		response.setHeader("ad", "hanife kurnaz");
		boolean adVarMi=response.containsHeader("ad");
		System.out.println("Ad headeri var mi? : " + adVarMi);
		String ad=response.getHeader("ad");
		response.addHeader("ad", "ayse kaya");
		response.addHeader("ad", "fatma demir");
		Collection<String>adHeader=response.getHeaders("ad");
		for(String s : adHeader)
			System.out.println(s);
		response.setIntHeader("yas", 21);
		response.setIntHeader("yil", 2016);
		response.setDateHeader("today", System.currentTimeMillis());
		response.addDateHeader("today", 10000000L);
		Collection<String>Headerlar=response.getHeaderNames();
		for (String s : Headerlar)
			System.out.println(s);	
	}
}
