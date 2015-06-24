<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

    <title>Comment</title>
     <body bgcolor="#EDF571">
    
    
        
        <script language="javascript">//03073581827268,03077468964005
             var today = new Date();
             document.write(today);
         </script>
         <h1 align="Center">Pera Blog System</h1>
		 <form  align="Right" action="logout.jsp" method="POST">
	
	<input align="Right" type="submit" align="Right" value="logout">
	</form>
         <form action="home" method="POST">
    <input type="submit" value="HOME" >
    </form>
    <%
     ArrayList com= (ArrayList)request.getAttribute("com");
  	String dis= (String)request.getAttribute("dis");
    String topic= (String)request.getAttribute("topic");
    Integer index= (Integer)request.getAttribute("index");
    String hit= (String)request.getAttribute("hit");
    
    out.print("<p><br><b>Post Number :</b>"+(String.valueOf(index))+"</p>");
    out.print("<p><b>Hits for that topic : "+hit+"</b></p>");
    %> <h1 ><% out.print(topic);%> </h1><%
    out.print("<p><b>POST Description : </b>"+dis+"</p>");
    
    if(com!=null){
    
    out.print("<p><b> COMMENTS : </b></p>");
for(int i=0;i<com.size();i++){
        out.print("<p><b>"+(String.valueOf(i+1))+" : </b>"+(String)com.get(i)+"</p>");

    }
    if(com.size()==0)
    out.print("<p> No recommend comments</p>");
    }
     %>
        
         <br>
         <form action="edit.jsp" method="POST">
        
        
        <div>
            <input  style="color:red ; " type="submit" value="Edit post">
        </div>
               <input type="hidden" value="<%=index%>" name="index">
               <input type="hidden" value="<%=topic%>" name="topic">
               <input type="hidden" value="<%=dis%>" name="dis">
               
               
                
    </form>
         <br>
         <form action="pos" method="POST">
                

               
               <div  align="Left">
                Enter Comment<br><br>
                <textarea cols="50" rows="5" name="comment"></textarea>
            </div>
            <input type="hidden" value="<%=index%>" name="index">
            <input  style="color:red ;" type="submit" value="Submit">
         </form>
        <br><br>
        
        
    </body>
</html>
