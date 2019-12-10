<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Comodidade</title>
</head>
<body>
<form action="alteraComodidades" method="get">
		Codigo: <input type="hidden" name="codigo" value="${comodidade.codigo}"> <br/> 
		Descrição: <input type="text" name="descricao" value="${comodidade.descricao}"> <br/> 
		
		<input type="submit" value="Enviar">
	</form>

</body>
</html>