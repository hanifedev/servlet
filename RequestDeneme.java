package Request;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="RequestDeneme", urlPatterns={"/RequestDeneme"})
public class RequestDeneme extends HttpServlet{
	@Override 	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter yaz=response.getWriter();
		yaz.write(request.getParameter("firstName")+"  ");
		yaz.write(request.getParameter("surName")+"   ");
		yaz.write(request.getParameter("mariel")+"   ");
		String[] parametreler=request.getParameterValues("program");
		for (int i=0; i<parametreler.length; i++)
		{
			yaz.write("  " + parametreler[i] + "");
		}
	}
}
