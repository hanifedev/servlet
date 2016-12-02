package SendRedirect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter yazici=response.getWriter();
		String kullanici=request.getParameter("username");
		String parola=request.getParameter("password");
		if(kullanici.equals("hanife")&&parola.equals("kurnaz"))
		{
			response.sendRedirect("ValidUser");
		}
		else
		{
			yazici.write("Gecersiz kullanici.");
		}
	}
}
