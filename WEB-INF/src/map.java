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

public class map extends HttpServlet {

     

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
    
     ArrayList<Integer> index=new ArrayList<Integer>();
      ArrayList<String> post=new ArrayList<String>();
   
   String  come=request.getParameter("comment");
     int  ind=Integer.valueOf(request.getParameter("index"));
    fileWriteRead d= new fileWriteRead();
    d.update(come,ind);
    int num=d.numb;
    
    
     ArrayList<String> des=new ArrayList<String>();
        //bmi = topic + " " + descrip + "" ;
        
        num=fileWriteRead.numb;
        for(int i = 0 ; i < fileWriteRead.numb && i < 10; i++){
            index.add(num);
            JsonObject j = fileWriteRead.getobject(num);
            post.add(j.get("topic").asString());
            des.add(j.get("dis").asString());
            //out.println(j.get("dis").asString());
            num--;
        }
        
        
        //bmi = "all are done";
       
        
       
/* now set an attribute and dispatch the request to result.jsp */
        request.setAttribute("post",post);
        request.setAttribute("index",index);
        request.setAttribute("des",des);
        
        
         request.getRequestDispatcher("/index.jsp").forward(request,response);
       
    }
    }
