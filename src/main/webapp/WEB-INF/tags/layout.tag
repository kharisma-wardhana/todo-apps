<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="content" fragment="true" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Todo Apps </title>
        <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/app.css" rel="stylesheet">
    </head>

    <body>
        <div class="container-fluid vh-100">
            <jsp:invoke fragment="content"/>
        </div>
        <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
        <script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    </body>

</html>