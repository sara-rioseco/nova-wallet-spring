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
    <title>NovaWallet</title>
    <script type="module" crossorigin="" src="${pageContext.request.contextPath}/app.js"></script>
    <link rel="stylesheet" crossorigin="" href="${pageContext.request.contextPath}/style.css" type="text/css">
</head>

<body>
<div id="root" class="root">
    <div class="signup-wrapper">
        <form class="signup-content-wrapper" method="post" action="signup"><h1>Nova<span>Wallet</span></h1>
            <div class="input-wrapper visually-hidden" hidden="">
                <input class="input input-text" type="text" id="signup-username" autocomplete="new-password"
                       placeholder=" " name="mail">
                <label class="label input-label" for="signup-username">Enter your username</label>
            </div>
            <div class="input-wrapper">
                <input class="input input-text" type="text" id="firstName"
                       autocomplete="new-password" placeholder=" " name="firstName" required="">
                <label class="label input-label" for="firstName">Enter your Name</label>
            </div>
            <div class="input-wrapper">
                <input class="input input-text" type="text" id="lastName"
                       autocomplete="new-password" placeholder=" " name="lastName" required="">
                <label class="label input-label" for="lastName">Enter your Lastname</label></div>
            <div class="input-wrapper">
                <input class="input input-text" type="search" id="username"
                       autocomplete="new-password" placeholder=" " name="username" required="">
                <label class="label input-label" for="username">Enter your Email</label>
            </div>
            <div class="input-wrapper">
                <input class="input input-text" type="password" id="password"
                       autocomplete="new-password" placeholder=" " name="password" required="">
                <label class="label input-label" for="password">Enter your Password</label>
            </div>
            <button id="button-signup">Sign up</button>
            <p class="signup-text">Already have an account?
                <span><a href="login">Login here.</a></span></p>
            <dialog class="modal msg-modal">
                <div class="wrapper dialog-wrapper"><h3 class="title">User created</h3>
                    <p>successfully</p>
                    <button class="button close-button">Ok</button>
                </div>
            </dialog>
            <dialog class="modal msg-modal">
                <div class="wrapper dialog-wrapper"><h3 class="title">Error</h3>
                    <p>Unable to create user</p>
                    <button class="button close-button">Ok</button>
                </div>
            </dialog>
        </form>
    </div>
</div>
</body>
</html>