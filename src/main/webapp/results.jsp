<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    });
</script>
<html>
<body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>First Name</th>
        <th>Last Name</th>
        <th>ID</th>
        <th>Age</th>
        </thead>
        <thbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.userid}</td>
                    <td>${user.calculateAge()}</td>
                </tr>

            </c:forEach>
        </thbody>
    </table>
</div>

</body>
</html>
