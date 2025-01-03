package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Jdbc.Linker;
import dao.userdao;
import entites.dataObject;

/**
 * Servlet implementation class selectUserById
 */
@WebServlet("/selectUserById")
//selectUserById id:
public class selectUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter(); 
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		dataObject resObj=null;
		HttpSession session = request.getSession();
		userdao dao = new userdao(Linker.getConn());
		System.out.println("-->>");
		try {
			if(request.getParameter("operation")!=null && request.getParameter("operation").equalsIgnoreCase("requests"))
				resObj=dao.updaterequest(Integer.parseInt( request.getParameter("id"))) ;
		} catch (Exception e) {	e.printStackTrace(); System.out.println("catch at servlet");
		}finally {			
			response.setContentType("application/json");
			System.out.println(resObj);
			out.append(		gson.toJson(resObj)	   );
			out.flush();
			out.close();
		}
	}
}
