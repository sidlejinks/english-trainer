<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html lang="en">
<head>
    <c:url value="/static/css/main.css" var="mainCss"/>
    <c:url value="/static/js/main.js" var="mainJs"/>
    <c:url value="/static/js/vendor/jquery-2.1.4.js" var="jQuery"/>
    <c:url value="/dictionary" var="manageDictionaryUrl"/>
    <c:url value="/settings" var="settingsUrl"/>
    <c:url value="/admin" var="adminUrl"/>
    <c:url value="/logout" var="logoutUrl"/>

    <meta charset="utf-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>The English Trainer</title>
    <link rel="stylesheet" href="${mainCss}"/>
</head>

<body>
<div>
    <sec:authorize access="isFullyAuthenticated()" var="isFullyAuthenticated">
        Hello, <sec:authentication property="principal.fullName"/>!
    </sec:authorize>

    <sec:authorize access="${isFullyAuthenticated} and hasAuthority('admin')">
        <a href="${adminUrl}">Administration</a>
    </sec:authorize>
    <a href="${manageDictionaryUrl}">Manage Dictionary</a>
    <a href="${settingsUrl}">Settings</a>
    <sec:authorize access="${isFullyAuthenticated}">
        <form method="post" action="${logoutUrl}">
            <a href="#" onclick="document.forms[0].submit();return false;">Log out</a>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </sec:authorize>
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