<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>

    <title>Pending comment</title>
            <script language="javascript">
             var today = new Date();
             document.write(today);
         </script>
		 <h1 align="Center">Pera Blog System</h1>
		 <form  align="Right" action="logout.jsp" method="POST">
	
	<input align="Right" type="submit" align="Right" value="logout">
	</form>
    <body bgcolor="#EDF571"> 
	<form action="home" method="POST">
	<input type="submit" value="HOME" >
	</form>
	<%
	int check=1;
	ArrayList num= (ArrayList)request.getAttribute("num");
	if(num!=null){
    for(int i = 0; i < num.size(); i++){
	ArrayList pend= (ArrayList)request.getAttribute((""+((Integer)num.get(i))));
	
	
	if(pend.size()!=0){
		out.println("<p>Post num"+(String)(num.get(i)+"")+"</p>");
		for(int j=0;j<pend.size();j++){
		   out.println("<p>"+"Pending comment :"+((String)(j+1+"")));
		   out.println((String)(pend.get(j)+"")+"</p>");
		   String numb=((String)(num.get(i)+":"))+String.valueOf(j);
		   check=0;
		   
		   %>
		<table> <tr><td>
		  <form action="ok" method="POST">
		<input type="hidden" value="<%=numb%>" name="numb">
		
		
			<input type="submit" value="Approve" >
		
	</form>
	</td><td>
	<form action="delete" method="POST">
		<input type="hidden" value="<%=numb%>" name="numb">
		
	
			<input type="submit" value="delete" >
		
			
	</form>
		</tr></td>	</table> 
		   <%
		}
		}
	}
	}if(check==1){
		%>
		NO PENDING COMMENT 
		
		<%
		
		}
	%>
  
 
	</body>
	
	</html>