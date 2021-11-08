<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<H1>Vartotojai:</H1>
</div>
<table border="1">
<thead>
<tr>
<th>id</th>
<th>vardas</th>
<th>pavarde</th>
<th>telNr</th>
<th>email</th>
<th>adresas</th>
<th>slaptazodis</th>
<th>Redaguoti</th>
<th>Istrinti</th>
</tr>
</thead>
<tbody>
<c:forEach items="${vartotojai}" var="var">
<tr>
<td>${var.id}</td>
<td>${var.vardas}</td>
<td>${var.pavarde}</td>
<td>${var.telNr}</td>
<td>${var.email}</td>
<td>${var.adresas}</td>
<td>${var.slaptazodis}</td>
<td><a type="button" href="/update-vartotojas/${var.id}">Redaguoti</a></td>
<td><a type="button" href="/delete-vartotojas/${var.id}">Istrinti</a></td>
</tr>
</c:forEach>

</tbody>
</table>



<%@ include file="common/footer.jspf"%>
