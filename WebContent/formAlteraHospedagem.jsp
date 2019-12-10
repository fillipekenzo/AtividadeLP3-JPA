<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera a Hospedagem</title>
</head>
<body>
<form action="alteraHospedagem" method="get">
		Código: <input type="hidden" name="codigo" value="${hospedagem.codigo}" />
		<br />
		Data de entrada: <input type="date" name="dataEntrada"  value="${hospedagem.dataEntrada}" />
		<br />
		Data de saída: <input type="date" name="dataSaida"  value="${hospedagem.dataSaida}" />
		<br />
		Valor Diária: <input type="text" name="valorDiaria"  value="${hospedagem.valorDiaria}" />
		<br />
		Status:
				<select name="status">
					<option value="${hospedagem.status}">${hospedagem.status}</option>
					<c:forEach var="status" items="${status}">
						<option value="${status}" >
							${status.descricao}</option>
					</c:forEach>
				</select> 
				<br/>	
		Quarto:
				<select name="quarto">
					<option  value="${hospedagem.quarto.codigo}" >${hospedagem.quarto.numero}</option>
					<c:forEach var="quarto" items="${quartos}">
						<option value="${quarto.codigo}" >
							${quarto.numero}</option>
					</c:forEach>
				</select> 
				<br/>
		Pessoa:
				<select name="pessoa">
					<option  value="${hospedagem.pessoa.codigo}">${hospedagem.pessoa.nome}</option>
					<c:forEach var="pessoa" items="${pessoas}">
						<option value="${pessoa.codigo}" >
							${pessoa.nome}</option>
					</c:forEach>
				</select> 
				<br/>			
		
		<input type="submit" value="Alterar">
	</form>

</body>
</html>