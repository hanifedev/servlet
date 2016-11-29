package servletNotasyon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/MerhabaServlet","/HelloServlet"})
public class servletNotasyon extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter yaz = response.getWriter();
		yaz.write("Merhaba Servlet");	
	}
