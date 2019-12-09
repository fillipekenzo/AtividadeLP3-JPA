<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pessoas</title>
</head>
<body>
	<div align="center">
		<form method="get" action="cadastroPessoa">
		Código: <input type="hidden" name="codigo" />
		<br />
		Nome: <input type="text" name="nome" />
		<br />
		CPF: <input type="text" name="cpf" />
		<br />
		Data de nascimento: <input type="date" name="dataNascimento" />
		<br />
		Telefone: <input type="text" name="telefone" />
		<br />
		Sexo:
				<select name="sexo">
					<option value="">Selecione um sexo</option>
					<c:forEach var="sexo" items="${sexos}">
						<option value="${sexo}" >
							${sexo.descricao}</option>
					</c:forEach>
				</select> 
				<br/>
		Status:
				<select name="status">
					<option value="">Selecione um status</option>
					<c:forEach var="status" items="${status}">
						<option value="${status}" >
							${status.descricao}</option>
					</c:forEach>
				</select> 
				<br/>				
		
				
				
				 <input type="submit" value="Salvar"/> 
		</form>
	</div>
</body>
</html>