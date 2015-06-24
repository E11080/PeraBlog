<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>

<html>
        <script language="javascript">
             var today = new Date();
             document.write(today);
         </script>
<title>Pera Blog System</title>
<form  align="Right" action="logout.jsp" method="POST">
    
    <input align="Right" type="submit" align="Right" value="logout">
    </form>
<body  bgcolor="#EDF571">

<%
  	
       ArrayList post= (ArrayList)request.getAttribute("post");
       ArrayList index= (ArrayList)request.getAttribute("index");
       ArrayList des= (ArrayList)request.getAttribute("des");
     
    
  %>


<h1 align="Center">Pera Blog System</h1>

<form align="Left" action="Main.html" method="POST">
 <input  type="submit" value=" New_Post">
</form>

 </form>
         
    
 
    <form align="Right" action="edite" method="POST">
        
        <div>
        
            <input  type="submit" value="Comment Approve">
        </div>
                
    </form>
 <%--
 show the result here by extracting the attribute you set
  --%>
  
  
  
   <%
    
    for(int i = 0; i < index.size(); i++)
    {
    Integer num=(Integer)index.get(i);
    
%>
<p>------------------------------------------------</p>
      <p><b> POST NUMBER : </b><%=num%> </p>
      <p> <b>POST TOPIC : </b><%=(String)post.get(i)%> </p>
      <% String postDes = (String)des.get(i); %>
      
      
      
      <p><b> POST DESCRIPTION : </b>
      <%
          if(postDes.length() > 25 ){
              out.println(postDes.substring(0,25)+".......");
          }
          else{
              out.println(postDes);
          }
      
      
      %>
      
<form action="comments" method="POST">
        <input type="hidden" value="<%=num%>" name="comment">
        
        <div>
            <input  style="color:red ; " size="10" maxlength="10" type="submit" value="view post">
        </div>
                
    </form>
       <%
    }
    
       %>
   
    <form action="allpost" method="POST">
    <input  style="color:red ; "  type="submit" value="view  all post post">
  </form>

   
        
</body>
</html>
