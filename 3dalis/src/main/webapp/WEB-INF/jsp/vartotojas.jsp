<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h2>Prideti nauja vartotoja:</h2>
<form:form method="post" modelAttribute="vartotojas">

    <form:input path="id" type="hidden" required="required" />
	<form:errors path="id" />

	<form:label path="vardas">Vardas:</form:label>
	<form:input path="vardas" type="text" required="required" />
	<form:errors path="vardas" /><br />
	<br />

	<form:label path="pavarde">Pavarde:</form:label>
    <form:input path="pavarde" type="text" required="required" />
   	<form:errors path="pavarde" /><br />
   	<br />

	<form:label path="telNr">Tel Nr:</form:label>
	<form:input path="telNr" type="text" required="required" />
	<form:errors path="telNr" /><br />
<br />
	<form:label path="email">Email:</form:label>
    <form:input path="email" type="text" required="required" />
   	<form:errors path="email" /><br />
<br />
   	<form:label path="adresas">Adresas:</form:label>
   	<form:input path="adresas" type="text" required="required" />
    <form:errors path="adresas" /><br />
<br />
    <form:label path="slaptazodis">Slaptazodis:</form:label>
    <form:input path="slaptazodis" type="text" required="required" />
    <form:errors path="slaptazodis" /><br />
<br />

	<button type="submit">OK</button><br />
	<br />
</form:form>
<div>
	<p>${error}</p>
</div>

<%@ include file="common/footer.jspf"%>
