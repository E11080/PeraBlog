import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonArray;

import post.fileWriteRead;

public class commentOk extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String numb=request.getParameter("numb");
	//request.getRequestDispatcher("/index.html");
	String [] a=numb.split(":");
	int num=Integer.valueOf(a[0]);
	int comNum=Integer.valueOf(a[1]);
	fileWriteRead.ok(num,comNum);
	request.setAttribute("test",comNum);
	
	pending pend=new pending();
	pend.doPost(request,response);
	}
	}