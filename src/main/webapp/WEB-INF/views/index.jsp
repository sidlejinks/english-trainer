<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <c:url value="/static/css/main.css" var="mainCss"/>
    <c:url value="/static/js/main.js" var="mainJs"/>
    <c:url value="/static/js/vendor/jquery-2.1.4.js" var="jQuery"/>
    <c:url value="/login" var="springSecurityUrl"/>

    <meta charset="utf-8">
    <title>The English Trainer</title>
    <link rel="stylesheet" href="${mainCss}"/>
</head>

<body>
    <div>
        <form method="post" action="${springSecurityUrl}">
            <input type="text" name="username" placeholder="Please, enter your username..."/>
            <input type="password" name="password" placeholder="...and then password"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Submit"/>
        </form>
    </div>
    <c:if test="${param.fail ne null}">
        <div class="login-fail">
            Provided credentials were wrong.<br/>
            Would you like to <a href="/">sign up</a>?
        </div>
    </c:if>
</body>
</html>