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
    <div>
        <textarea class="item-original" cols="20" rows="2"></textarea>
        <textarea class="item-translation" cols="20" rows="2"></textarea>
        <button class="add-item-submit">Add</button>
    </div>
    <p class="result-area"></p>

<script src="${jQuery}"></script>
<script src="${mainJs}"></script>
</body>
</html>