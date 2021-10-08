<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> Delete Product</h1><br><br>

<c:if test="${messenger !=null}" >
    <p>${messenger}</p>
</c:if>

<form action="/products?id=${p.id}" method="post">
    <label for="name">ProductName:</label>
    <input id="name" type="text" name="name" value="${p.name}"><br>

    <label for="price">Price:</label>
    <input id="price" type="text" name="price" value="${p.price}"><br>

    <label for="quantity">Quantity:</label>
    <input id="quantity" type="text" name="quantity" value="${p.quantity}"><br>

    <label for="color">Color:</label>
    <input id="color" type="text" name="color" value="${p.color}"><br>

    <label for="description">Description:</label>
    <input id="description" type="text" name="description" value="${p.description}"><br>

    <label for="category">Category:</label>
    <input id="category" type="text" name="description" value="${p.category.name}"><br>

    <button name="action" value="delete">Delete</button>
</form>
</body>
</html>