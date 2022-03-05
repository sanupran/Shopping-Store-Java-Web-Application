<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E Shop</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/WebContent/css/design.css" type="text/css" />
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    #footer
    {
    position:absolute;
    bottom:0;
    width:100%;
    height:100px;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home</a></li>
        <li><a href="customer.jsp"><span class="glyphicon glyphicon-log-in"></span>Customer Login</a></li>
              </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="admin.jsp"><span class="glyphicon glyphicon-log-in"></span>Admin Login</a></li>
      </ul>
    </div>
  </div>
</nav>
<h1 align="left">Customer Registration</h1>
<img src="images\eshop.jpg" align="right" width="600" height="400">
<div class="col-sm-3 text-left">
<form action="registration" method="post">
<input type="text" placeholder="Name" name="name" size="45"><br>
<input type="email" placeholder="Email" name="email"size="45"><br>
<input type="date" placeholder="DOB(dd/mm/yyyy)" name="dob"size="45"><br>
<input type="text" placeholder="Mobile" name="mob"size="45"><br>
<textarea rows="5" cols="45" placeholder="Residential Address" name="raddr"size="45"></textarea><br>
<textarea rows="5" cols="45" placeholder="Communication Address" name="caddr"size="45"></textarea><br>
<input type="text" placeholder="Username" name="username"size="45"><br>
<input type="password" placeholder="Password" name="pwd"size="45"><br>
<input type="submit" value="Create Account">
</form>
</div>
<div id="footer">
<footer class="container-fluid text-center">
  <p>E Shop</p>
</footer>
</div>
</body>
</html>