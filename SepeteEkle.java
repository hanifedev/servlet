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

public class SepeteEkle extends HttpServlet{
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
					previousItems.add(newItem);
					response.sendRedirect("UrunDetay.html");			
					session.setMaxInactiveInterval(30*60);
				}
				session.setAttribute("previousItems", previousItems);
		}
	}
}
