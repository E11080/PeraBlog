
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



public class comment extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ArrayList<String> data=new ArrayList<String>();
    int  index=Integer.valueOf(request.getParameter("comment"));
    JsonObject j = fileWriteRead.getobject(index);
    
    String tem=j.get("dis").asString();
        request.setAttribute("dis",tem);
    tem =j.get("topic").asString();
        request.setAttribute("topic",tem);
        String hit=j.get("hit").asString();
        JsonArray arr=(JsonArray)j.get("com");
        
        String  commen="";
        for(int i=0;i<arr.size();i++){
        commen=arr.get(i).asString();
        data.add(commen);
        
        }
        fileWriteRead.hits(index);
    request.setAttribute("com",data);
request.setAttribute("hit",hit);
    request.setAttribute("index",index);
    request.getRequestDispatcher("/comment.jsp").forward(request,response);

}
}
