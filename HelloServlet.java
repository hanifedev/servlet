package HelloServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter printWriter=response.getWriter();
		printWriter.write("<html><body>");
		String mesaj="<h1>Ilk deneme</h1>";
		printWriter.write(mesaj);
		printWriter.write("</html></body>");
	}
}
