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
		<form method="post" action="cadastroComodidades">
		Código: <input type="hidden" name="codigo" />
		<br />
		Descrição: <input type="text" name="descricao" />
		<br />

				 <input type="submit" value="Salvar"/> 
				 <input type="reset" value="Limpar">
		</form>
	</div>
</body>
</html>