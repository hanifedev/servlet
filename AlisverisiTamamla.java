package SepeteEkleOdevi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AlisverisiTamamla extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
			HttpSession session=request.getSession();
			synchronized (session) {
				@SuppressWarnings("unchecked")
				List<String> previousItems=(List<String>)session.getAttribute("previousItems");
				if(previousItems==null)
				{
					previousItems=new ArrayList<String>();
				}
				String newItem=request.getParameter("newItem");
				if((newItem!=null)&&(!newItem.trim().equals("")))
				{
					session.setMaxInactiveInterval(30*60);
					previousItems.add(newItem);
				}
				session.setAttribute("previousItems", previousItems);
				response.setContentType("text/html");
				PrintWriter yaz=response.getWriter();
				String title="Items Purchased";
				String docType=
						"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + 
				"Transitional//EN\">\n";
				yaz.write(docType + 
						"<html>\n"+
						"<head><title>" + title + "</title></head>\n" +
						"<body bgcolor=\"#FDF5E6\">\n"+
						"<h1>" + title + "</h1>");
				if (previousItems.size()==0)
				{
					yaz.write("<i>No Items</i>");
				}
				else
				{
					yaz.write("<ul>");
					for(String item : previousItems)
					{
						yaz.write("<li>" + item);
					}
					yaz.write("</ul>");
				}
				yaz.write("</body></html>");
		}
	}
}
