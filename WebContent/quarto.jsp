<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Quartos</title>
</head>
<body>
	<div align="center">
		<form method="get" action="cadastroQuarto">
		Código: <input type="hidden" name="codigo" />
		<br />
		Número: <input type="text" name="numero" />
		<br />
		Capacidade: <input type="text" name="capacidade" />
		<br />
		Disponibilidade:
				<select name="disponibilidade">
					<option value="">Selecione uma disponibilidade</option>
					<c:forEach var="disponibilidade" items="${disponibilidades}">
						<option value="${disponibilidade}" >
							${disponibilidade.descricao}</option>
					</c:forEach>
				</select> 
				<br/>
		Tipo de quarto:
				<select name="tipoQuarto">
					<option value="">Selecione um tipo de quarto</option>
					<c:forEach var="tipoQuarto" items="${tipoQuartos}">
						<option value="${tipoQuarto}" >
							${tipoQuarto.descricao}</option>
					</c:forEach>
				</select> 
				<br/>				
		Comodidades:
				<c:forEach var="comodidade" items="${comodidades}">
				${comodidade.descricao}<input type="checkbox" name="com" value="${comodidade.codigo}">
				</c:forEach>
				
				<br/>
				
				
				 <input type="submit" value="Salvar"/> 
		</form>
	</div>
</body>
</html>