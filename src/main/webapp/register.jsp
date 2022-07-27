<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<title>HSBC Login</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<table class="table">
    <tr>
        <td>
            <form class="form-horizontal" role="form" method="post" action="/ex-hsbc/register">
                <div class="form-group">
                    <label for="userName" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-1">
                        <input type="text" class="form-control" id="userName" name="userName"
                               placeholder="input your name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-1">
                        <input type="text" class="form-control" id="password" name="password"
                               placeholder="input your password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-3">
                        <button type="submit" class="btn btn-default">Login</button>
                    </div>
                </div>
            </form>
         </td>
      </tr>
    <tr>
        <td><a class="btn btn-primary btn-small" role="button"  href="login.jsp">
                                            Login</a>
        </td>
    </tr>

 </table>
</body>
</html>
