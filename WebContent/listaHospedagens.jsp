<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	 
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Hospedagens</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Codigo</td>
			<td>Data de Entrada</td>
			<td>Data de Saída</td>	
			<td>Valor Diaria</td>
			<td>Pessoa</td>	
			<td>Quarto</td>	
			<td>Status</td>					
		</tr>
		<c:forEach items="${hospedagens}" var="hospedagem">
		<tr> 
		<td>${hospedagem.codigo}</td>
		<td>${hospedagem.dataEntrada}</td>	
		<td>${hospedagem.dataSaida}</td>
		<td>R$ ${hospedagem.valorDiaria}</td>
		<td>${hospedagem.pessoa.nome}</td>
		<td>${hospedagem.quarto.numero}</td>
		<td>${hospedagem.status}</td>
		<td>	
		<a href="/lp3-FillipeKenzo/atualizaHospedagem?codigo=${hospedagem.codigo}">
		Editar
		</a>
		</td>		
		
		<td>
		<a href="/lp3-FillipeKenzo/removeHospedagem?codigo=${hospedagem.codigo}">
		Remover
		</a>
		</td>		
		</tr>		
		</c:forEach>
		
	</table>

</body>
</html>