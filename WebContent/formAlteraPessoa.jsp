<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Pessoa</title>
</head>
<body>
<form action="alteraPessoa" method="get">
		Código: <input type="hidden" name="codigo"  value="${pessoa.codigo}"/>
		<br />
		Nome: <input type="text" name="nome" value="${pessoa.nome}"/>
		<br />
		CPF: <input type="text" name="cpf" value="${pessoa.cpf}"/>
		<br />
		Data de nascimento: <input type="date" name="dataNascimento" value="${pessoa.dataNascimento}" />
		<br />
		Telefone: <input type="text" name="telefone" value="${pessoa.telefone}" />
		<br />
		Sexo:
				<select name="sexo">
					<option value="${pessoa.sexo}">${pessoa.sexo}</option>
					<c:forEach var="sexo" items="${sexos}">
						<option value="${sexo}" >
							${sexo.descricao}</option>
					</c:forEach>
				</select> 
				<br/>
		Status:
				<select name="status">
					<option value="${pessoa.status}">${pessoa.status}</option>
					<c:forEach var="status" items="${status}">
						<option value="${status}" >
							${status.descricao}</option>
					</c:forEach>
				</select> 
				<br/>						
		
		<input type="submit" value="Alterar">
	</form>

</body>
</html>