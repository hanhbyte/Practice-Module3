<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
            integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
            integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
            crossorigin="anonymous"></script>

    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>Product List</h1><br><br>
<header>
    <div>
        <a href="/products?action=create">
            <button>Add new product</button>
        </a>
        <form action="/products?" method="get" style="padding-left: 1100px">
            <input type="text" name="searchByName" placeholder="Enter Product Name">
            <button name="action" value="search">Search</button>
        </form>

    </div>
</header>


<table class="table" border="1px">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Product Name</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Color</th>
        <th scope="col">Category</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pl}" var="p" varStatus="vs">
        <tr>
            <td>${vs.index}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td>${p.color}</td>
            <td>${p.category.name}</td>
            <td><a href="/products?action=edit&id=${p.id}"><button>Edit</button></a></td>
            <td><a href="/products?action=delete&id=${p.id}"><button>DELETE</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>