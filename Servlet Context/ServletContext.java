package ServletContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextClass extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter yaz=response.getWriter();
		ServletContext con=getServletContext();
		String mail=con.getInitParameter("EmailAdress");
		Enumeration<String> parametreAdi=con.getInitParameterNames();
		while(parametreAdi.hasMoreElements())
		{
			yaz.write(parametreAdi.nextElement());
			response.getWriter().write("</br>");
		}
		yaz.write(mail);
		yaz.close();
	}
}
