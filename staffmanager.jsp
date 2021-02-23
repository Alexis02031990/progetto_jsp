<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.StaffDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Staff Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="StaffServlet?mode=stafflist">Staff</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<StaffDTO> list = (List<StaffDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			    <th>IdStaff</th>
		        <th>Nome</th>
		        <th>Cognome</th>
                <th>Email</th>
                <th>Posizione</th>
                <th>Numero_telefono</th>
                <th>data_assunzione</th>
                <th>Sede</th>
                <th>OreSettimanali</th>
                <th>CodiceFiscale</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (StaffDTO u : list) {
		%>
		<tr>
			<td><a href=StaffServlet?mode=read&id=<%=u.getIdStaff()%>><%=u.getIdStaff()%>  </a></td>
			<td><%=u.getNome()%></td>
			<td><%=u.getCognome()%></td>
			<td><%=u.getEmail()%></td>
			<td><%=u.getPosizione()%></td>
			<td><%=u.getNumero_telefono()%></td>
			<td><%=u.getData_assunzione()%></td>
			<td><%=u.getSede()%></td>
			<td><%=u.getOre_settimanali()%></td>
			<td><%=u.getCodice_fiscale()%></td>
			
			<td><a href=StaffServlet?mode=read&update=true&id=<%=u.getIdStaff()%>>Edit</a>
			</td>
			<td><a href=StaffServlet?mode=delete&id=<%=u.getIdStaff()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="StaffServlet?mode=insert" method="post">
<div class="row">
    <div class="col-25">
      <label for="staff">idStaff</label>
    </div>
    <div class="col-75">
      <input type="text" id="staff" name="idstaff" placeholder="inserisci idstaff">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="name">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="nome" placeholder="inserisci nome">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="lastname">Cognome</label>
    </div>
    <div class="col-75">
      <input type="text" id="lastname" name="cognome" placeholder="inserisci cognome"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="mail">Email</label>
    </div>
    <div class="col-75">
      <input type="text" id="mail" name="email" placeholder="inserisci email"> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="pos">Posizione</label>
    </div>
    <div class="col-75">
      <input type="text" id="pos" name="posizione" placeholder="inserisci posizione"> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
     <label for="pos">Data</label>
    </div>
    <div class="col-75">
      <input type="text" id="pos" name="data_assunzione" placeholder="inserisci data_assunzione"> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="user">Username</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="username" placeholder="inserisci username">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Password</label>
    </div>
    <div class="col-75">
      <input type="text" id="pass" name="password" placeholder="inserisci password"> 
    </div>
  </div>
 
  <div class="row">
    <div class="col-25">
      <label for="type">Usertype</label>
    </div>
   		 <div class="col-75">
 			<select id="type" name="usertype">
  				<option value="ADMIN">ADMIN</option>
  				<option value="USER">USER</option>
                <option value="STAFF">STAFF</option>
			</select>
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>