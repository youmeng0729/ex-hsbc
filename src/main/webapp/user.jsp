<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<html>
<head>
  <title>User Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2><%=session.getAttribute("user")%> - Granted Roles</h2><br/>
  <h5><%=request.getAttribute("infoMsg")%></h5>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>
            <form method="post" action="/ex-hsbc/checkRole">
                <input name="roleVal" type="text" placeholder="input role">
                <input name="submit" type="submit" value="check role">
            </form>

        </th>
        <th>
            <form method="post" action="/ex-hsbc/addRole">
                <input name="roleVal" type="text" placeholder="input role">
                <input name="submit" type="submit" value="add role">
            </form>
        </th>
      </tr>
    </thead>
    <tbody>
        <%
            Set<String> roles = (Set<String>)request.getAttribute("roles");
            for(String role : roles) {
        %>
              <tr>
                <td><%=role%></td>
                <td><button type="button" class="btn btn-default">
                    <a  href="/ex-hsbc/deleteRole?roleVal=<%=role%>">
                    Delete
                    </a>
                    </button>
                </td>
              </tr>
            <% } %>
            <tr><td colspan=2>  <p><a class="btn btn-primary btn-small" role="button"  href="login.jsp">
                      			Login</a>
                      		</p></td></tr>
    </tbody>
  </table>
</div>

</body>
</html>
