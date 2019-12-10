<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	 
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Quartos</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Codigo</td>
			<td>Numero</td>
			<td>Capacidade</td>	
			<td>Disponibilidade</td>
			<td>Tipo Quarto</td>	
			<td>Comodidades</td>	
						
		</tr>
		<c:forEach items="${quartosComodidades}" var="quartosComodidade">
		<tr> 
		<td>${quartosComodidade.codigo}</td>
		<td>${quartosComodidade.numero}</td>	
		<td>${quartosComodidade.capacidade}</td>
		<td>${quartosComodidade.disponibilidade}</td>
		<td>${quartosComodidade.tipoQuarto}</td>
		<td>
		<c:forEach items="${quartosComodidade.comodidades}" var="comodidades">
		   ${comodidades.descricao}<br/>
		</c:forEach>
		</td>

		<td>	
		<a href="/lp3-FillipeKenzo/atualizaQuarto?codigo=${quartosComodidade.codigo}">
		Editar
		</a>
		</td>		
		
		<td>
		<a href="/lp3-FillipeKenzo/removeQuarto?codigo=${quartosComodidade.codigo}">
		Remover
		</a>
		</td>		
		</tr>		
		</c:forEach>
		
	</table>
</body>
</html>