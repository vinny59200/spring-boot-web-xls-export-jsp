<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*, javax.servlet.*, org.apache.poi.xssf.usermodel.*, java.util.*, java.util.stream.*" %>
<%@ page import="com.vv.domain.TdoVV" %>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
<h1>Welcome to Spring Boot JSP!</h1>

<%
    List<TdoVV> pageList = new ArrayList<>();
    pageList.add(new TdoVV("ABC123", "Model X", 10, "Units"));
    pageList.add(new TdoVV("DEF456", "Model Y", 20, "Pieces"));
    pageList.add(new TdoVV("GHI789", "Model Z", 30, "Kilograms"));

    session.setAttribute("pageList", pageList);
%>

<form action="${pageContext.request.contextPath}/export" method="POST">
    <button type="submit">Export to Excel</button>
</form>

</body>
</html>

