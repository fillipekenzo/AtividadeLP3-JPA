<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	 
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Pessoas</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Codigo</td>
			<td>Nome</td>
			<td>CPF</td>	
			<td>Telefone</td>
			<td>Data nascimento</td>	
			<td>Sexo</td>	
			<td>Status</td>					
		</tr>
		<c:forEach items="${pessoas}" var="pessoa">
		<tr> 
		<td>${pessoa.codigo}</td>
		<td>${pessoa.nome}</td>	
		<td>${pessoa.cpf}</td>
		<td>${pessoa.telefone}</td>
		<td>${pessoa.dataNascimento}</td>
		<td>${pessoa.sexo}</td>
		<td>${pessoa.status}</td>
		<td>	
		<a href="/AtividadeLP3-JPA/atualizaPessoa?codigo=${pessoa.codigo}">
		Editar
		</a>
		</td>		
		
		<td>
		<a href="/AtividadeLP3-JPA/removePessoa?codigo=${pessoa.codigo}">
		Remover
		</a>
		</td>		
		</tr>		
		</c:forEach>
		
	</table>

</body>
</html>