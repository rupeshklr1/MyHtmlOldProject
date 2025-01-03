package servlets.hotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Jdbc.Linker;
import dao.hoteldao;
import dao.userdao;
import entites.dataObject;
import entites.hotel;

/**
 * Servlet implementation class selectHotelByOwner
 */
@WebServlet("/selectHotelByOwner")
public class selectHotelByOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter(); 
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		dataObject resObj=null;
		HttpSession session = request.getSession();
		hoteldao dao = new hoteldao(Linker.getConn());
		System.out.println("-->>");
		Object hList=new Object();
		hList=dao.displayHotel(0,Integer.parseInt( request.getParameter("id")) );
		try {
			if(hList!=null) {
				resObj=new dataObject(1,"userdata","NTH","log");
				resObj.setDatapack(hList);
			}else {
				resObj=new dataObject(0,"NTH","ERROR","log");
				resObj.setDatapack(hList);				
			}
		} catch (Exception e) {	e.printStackTrace(); System.out.println("catch at servlet");
		}finally {			
			Linker.colseConn();
			response.setContentType("application/json");
			out.append(		gson.toJson(resObj)	   );
			out.flush();
			out.close();
		}
	}
}
