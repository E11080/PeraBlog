<!DOCTYPE html>
<html>
    <title>EditPost</title>
    


    
   <body bgcolor="#EDF571">
   <script language="javascript">
             var today = new Date();
             document.write(today);
         </script>
        <h1 align="Center">Pera Blog System</h1>
        <form  align="Right" action="logout.jsp" method="POST">
	
	<input align="Right" type="submit" align="Right" value="logout">
	</form>
        
         <br><br><br>
         <%
             String index = (String)request.getParameter("index");
             String dis= (String)request.getParameter("dis");
             String topic= (String)request.getParameter("topic");
            
         %>
         
         <form action="UpdatePost" method="POST">
               Topic:
                <input  type="text" size="112" name="topic" value=<%=topic%>><br><br><br>
               
               <div align="Left">
                Enter descriptions<br><br>
                <textarea cols="120" rows="20" name="descrip"><%=dis%></textarea>
            </div>
            
            <input type="hidden" value="<%=index%>" name="index">
           
            <input type="submit" value="Submit">
         </form>
        <br><br>
        
        
    </body>
</html>
