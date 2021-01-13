
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>Welcome User</h1>
    </div>
    <div >
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <h1>All </h1>
        <table>
            <thead>
            <tr>
                <th> name</th>
                <th>creator</th>
                <th>currentVersion</th>
                <th>action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${languages}" var="language">
                <tr>
                    <td>
                        <a href="/languages/${language.id}"> <c:out value="${language.name}"/></a>
                    </td>
                    <td>

                        <a href="/languages/${language.id}"> <c:out value="${language.creator}"/></a>

                    </td>
                    <td>

                        <a href="/languages/${language.id}"> <c:out value="${language.currentVersion}"/></a>
                    </td>


                    <td><a href="/languages/${language.id}/edit">Edit </a>

                        <form action="/languages/${language.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete">
                    </form>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div >

            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <h1>New Book</h1>
            <form:form action="/languages" method="post" modelAttribute="language">

                <p>
                    <form:label path="name">name</form:label>
                    <form:errors path="name"/>
                    <form:input path="name"/>
                </p>

                <p>
                    <form:label path="creator">creator</form:label>
                    <form:errors path="creator"/>
                    <form:input path="creator"/>
                </p>
                <p>
                    <form:label path="currentVersion">currentVersion</form:label>
                    <form:errors path="currentVersion"/>
                    <form:input type="number" path="currentVersion"/>
                </p>
                <input type="submit" value="Submit"/>
            </form:form>


        </div>

    </div>
</div>
</body>
</html>
