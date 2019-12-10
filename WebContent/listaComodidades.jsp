<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	 
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de comodidades</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Codigo</td>
			<td>Descrição</td>			
		</tr>
		<c:forEach items="${comodidades}" var="comodidade">
		<tr> 
		<td>${comodidade.codigo}</td>
		<td>${comodidade.descricao}</td>	
		<td>	
		<a href="/lp3-FillipeKenzo/atualizaComodidades?codigo=${comodidade.codigo}">
		Editar
		</a>
		</td>		
		
		<td>
		<a href="/lp3-FillipeKenzo/removeComodidades?codigo=${comodidade.codigo}">
		Remover
		</a>
		</td>		
		</tr>		
		</c:forEach>
		
	</table>

</body>
</html>