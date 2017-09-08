<%@include file="taglib.jsp" %>
<c:set var="title" value="User Search Home Page" />
<%@include file="head.jsp"%>
<html>
    <body>
        <h2>User Display Exercise - Week 1</h2>
        <form action="/searchUser" class="form-inline">
            <div class="form-group">
                <label for="searchTerm">Search</label>
                <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTerm" />
            </div>
            <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
            <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all users</button>
        </form>
        <a href = "/searchUser">Go to the User Search</a>
    </body>
</html>