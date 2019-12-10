<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Hospedagem</title>
</head>
<body>
	<div align="center">
		<form method="get" action="cadastroHospedagem">
		Código: <input type="hidden" name="codigo" />
		<br />
		Data de entrada: <input type="date" name="dataEntrada" />
		<br />
		Data de saída: <input type="date" name="dataSaida" />
		<br />
		Valor Diária: <input type="text" name="valorDiaria" />
		<br />
		Status:
				<select name="status">
					<option value="">Selecione um status</option>
					<c:forEach var="status" items="${status}">
						<option value="${status}" >
							${status.descricao}</option>
					</c:forEach>
				</select> 
				<br/>	
		Quarto:
				<select name="quarto">
					<option value="">Selecione o quarto</option>
					<c:forEach var="quarto" items="${quartos}">
						<option value="${quarto.codigo}" >
							${quarto.numero}</option>
					</c:forEach>
				</select> 
				<br/>
		Pessoa:
				<select name="pessoa">
					<option value="">Selecione a Pessoa</option>
					<c:forEach var="pessoa" items="${pessoas}">
						<option value="${pessoa.codigo}" >
							${pessoa.nome}</option>
					</c:forEach>
				</select> 
				<br/>			
		
				
				
				 <input type="submit" value="Salvar"/> 
		</form>
	</div>
</body>
</html>