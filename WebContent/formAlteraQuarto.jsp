<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Quarto</title>
</head>
<body>
<form method="get" action="alteraQuarto">
		Código: <input type="hidden" name="codigo" value="${quarto.codigo}"/>
		<br />
		Número: <input type="text" name="numero" value="${quarto.numero}"/>
		<br />
		Capacidade: <input type="text" name="capacidade" value="${quarto.capacidade}"/>
		<br />
		Disponibilidade:
				<select name="disponibilidade">
					<option value="${quarto.disponibilidade}">${quarto.disponibilidade}</option>
					<c:forEach var="disponibilidade" items="${disponibilidades}">
						<option value="${disponibilidade}" >
							${disponibilidade.descricao}</option>
					</c:forEach>
				</select> 
				<br/>
		Tipo de quarto:
				<select name="tipoQuarto">
					<option value="${quarto.tipoQuarto}">${quarto.tipoQuarto}</option>
					<c:forEach var="tipoQuarto" items="${tipoQuartos}">
						<option value="${tipoQuarto}" >
							${tipoQuarto.descricao}</option>
					</c:forEach>
				</select> 
				<br/>				
		
				
				
				 <input type="submit" value="Salvar"/> 
		</form>
</body>
</html>