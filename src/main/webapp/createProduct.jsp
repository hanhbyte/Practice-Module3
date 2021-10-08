<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <style>
      input{
        margin-left: 200px;
      }
    </style>
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

<h1> Create new Product</h1><br><br>

<form action="/products" method="post">
    <label for="name">ProductName:</label>
    <input id="name" type="text" name="name"><br>

    <label for="price">Price:</label>
    <input id="price" type="text" name="price"><br>

    <label for="quantity">Quantity:</label>
    <input id="quantity" type="text" name="quantity"><br>

    <label for="color">Color:</label>
    <input id="color" type="text" name="color"><br>

    <label for="description">Description:</label>
    <input id="description" type="text" name="description"><br>

    <label for="category">Category:</label>
    <select name="category_id" id="category">
        <c:forEach items="${ca}" var="c">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="Submit">
</form>

</table>
</body>
</html>