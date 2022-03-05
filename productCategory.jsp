<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Category Insertion</title>
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
        <!-- <li ><a href="productCategory.jsp">Product Category</a></li> -->
              <li ><a href="product.jsp">Product</a></li>
              <li ><a href="productInventory.jsp">Product Inventory</a></li>
              <li ><a href="dashboard.jsp">Dashboard</a></li>
              </ul>
            <ul class="nav navbar-nav navbar-right">
             <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
      </ul>
               </div>
  </div>
</nav>
<h1 align="left">Product Category</h1>
<div class="col-sm-8" text-left>
<form action="productCategory" method="post">

<input type="text" placeholder="Product Category ID" name="productCategoryID" size="45"><br><br>
<input type="text" placeholder="Product Category Name" name="productCategoryName" size="45"><br><br>
<textarea rows="3" cols="45" placeholder="Product Category Description" name="productCategoryDescription"></textarea><br><br>
<input type="submit" value="Click Product">
</form>
</div>
<div id="footer">
<footer class="container-fluid text-center">
  <p>E Shop</p>
</footer>
</div>

</body>
</html>