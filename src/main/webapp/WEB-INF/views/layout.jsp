
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <tiles:insertAttribute name="head"/>
</head>
<body>

<div class="container">
    <header class="row">
        <h1 class="alert alert-success">Online Shopping</h1>
    </header>
    <nav class="row">

        <tiles:insertAttribute name="menu"/>
    </nav>
    <div class="row">
        <article class="col-sm-9">
            <tiles:insertAttribute name="body"/>
        </article>
        <aside class="col-sm-3">

            <tiles:insertAttribute name="aside"/>
        </aside>
    </div>
    <footer class="row">
        <p class="text-center">&copy;2019</p>
    </footer>
</div>

</body>
</html>
