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
    <title>NovaWallet | Transactions</title>
    <script type="module" crossorigin="" src="${pageContext.request.contextPath}/app.js"></script>
    <link rel="stylesheet" crossorigin="" href="${pageContext.request.contextPath}/style.css" type="text/css">
</head>
<body>
<div id="root" class="root">
    <div class="transactions-wrapper">
        <header>
            <div class="header-container">
                <h1 class="logo"><a href="${pageContext.request.contextPath}/home">Nova<span>Wallet</span></a></h1>
                <nav class="site-nav">
                    <button class="menu-toggle" id="menu-toggle" aria-controls="primary-navigation" aria-expanded="false"><span
                            class="visually-hidden"></span>
                        <div class="hamburger" id="hamburger" aria-hidden="true"></div>
                    </button>
                    <ul class="primary-navigation" id="primary-navigation" data-state="closed">
                        <a href="${pageContext.request.contextPath}/home"><li>Home</li></a>
                        <a href="${pageContext.request.contextPath}/deposit"><li>Deposit</li></a>
                        <a href="${pageContext.request.contextPath}/withdraw"><li>Withdraw</li></a>
                        <a href="${pageContext.request.contextPath}/transfer"><li>Send Money</li></a>
                        <a href="${pageContext.request.contextPath}/transactions"><li>Transactions</li></a>
                        <a href="${pageContext.request.contextPath}/logout"><li>Logout</li></a>
                    </ul>
                </nav>
            </div>
        </header>
        <main class="transactions-content-wrapper"><h2 class="transactions-title">Transaction History</h2>
            <section class="transactions-history-wrapper">
                <c:if test="${transactions.size() > 0}">
                    <c:forEach items="${transactions}" var="item">
                        <div class="history-item-wrapper">
                            <div class="history-item-title">
                                <h3>${item.type}</h3>
                                <h3>${item.symbol}${item.amount}</h3>
                            </div>
                            <p class="history-item-subtitle">${item.date}</p>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${transactions.size() <= 0 || transactions == null}">
                <div class="history-item-wrapper">
                    <div class="history-item-title">
                        <br>
                        <h3>You don't have any transactions yet.</h3>
                </c:if>
            </section>
            <h3 class="transactions-balance">Your total balance is: <span>${currency} ${balance}</span></h3></main>
        <footer>
            <div class="footer-container"><p>Designed and developed by ©Sara Rioseco 2024</p></div>
        </footer>
    </div>
</div>
</body>
</html>
