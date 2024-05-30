<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <meta name="viewport" content="width=device-width,initial-scale=1, minimum-scale=1">
    <meta name="description"
          content="An e-wallet that allows the user to manage, transfer and deposit money in a convenient and easy way.">
    <link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
    <title>NovaWallet | Home</title>
    <script type="module" crossorigin="" src="${pageContext.request.contextPath}/app.js"></script>
    <link rel="stylesheet" crossorigin="" href="${pageContext.request.contextPath}/style.css" type="text/css">
</head>

<body>
<div id="root" class="root">
    <div class="home-wrapper">
        <h1>ESTE ES EL HOME</h1>
    </div>
</div>
</body>
</html>