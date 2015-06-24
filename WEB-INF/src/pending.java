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

public class pending extends HttpServlet {

     

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 ArrayList<Integer> num=new ArrayList<Integer>();
	// ArrayList<String> tp=new ArrayList<String>();
	String bmi="";
	//int num=fileWriteRead().fileNum();
	for(int j=0;j<fileWriteRead.fileNum.size();j++){
	
	ArrayList<String> data=new ArrayList<String>();
	
	num.add(fileWriteRead.fileNum.get(j));
	
	JsonObject newObj = fileWriteRead.getobject(fileWriteRead.fileNum.get(j));
	JsonArray tem=(JsonArray)newObj.get("pending");
	if(tem!=null){
	for(int k=0;k<tem.size();k++){
		bmi=tem.get(k).asString();
		data.add(bmi);
		
		}
		String res=""+fileWriteRead.fileNum.get(j);
		 request.setAttribute(res,data);
       } 
	}
	request.setAttribute("num",num);
        
		 request.getRequestDispatcher("/editepost.jsp").forward(request,response);
	}
	
}