<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <c:url value="/static/css/main.css" var="mainCss"/>
    <c:url value="/static/js/main.js" var="mainJs"/>
    <c:url value="/static/js/vendor/jquery-2.1.4.js" var="jQuery"/>

    <meta charset="utf-8">
    <title>The English Trainer</title>
    <link rel="stylesheet" href="${mainCss}"/>
</head>

<body>
<div>
    <a href="/">Home</a>
    <a href="/dictionary">Manage Dictionary</a>
</div>
<table>
    <tr>
        <th>Language Item</th>
        <th>Translation</th>
    </tr>

    <c:forEach items="${languageItems}" var="item">
        <tr>
            <td>${item.original}</td>
            <td>${item.translation}</td>
        </tr>
    </c:forEach>
</table>

<script src="${mainJs}"></script>
<script src="${jQuery}"></script>
</body>
</html>