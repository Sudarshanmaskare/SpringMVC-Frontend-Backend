<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@include file="./base.jsp"%>
    <title>Fill Product Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Optional: Add custom styles here */
        /* Example: Adjust form width */
        .custom-form {
            max-width: 400px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="mt-4">Change Product Details</h2>
        <form class="mt-4 custom-form" action="${pageContext.request.contextPath}/update-product" method="post">
            <div class="form-group">
                <label for="productId">Enter Product Id:</label>
                <input type="text" class="form-control" placeholder="Enter Product Id" id="productName" name="pId" value="${product.getPId()}">
            </div>
            
            <div class="form-group">
                <label for="productName">Enter Product Name:</label>
                <input type="text" class="form-control" placeholder="Enter Product name" id="productName" name="name" value="${product.name}">
            </div>
            
            <div class="form-group">
                <label for="productDescription">Product Description:</label>
                <textarea class="form-control" id="productDescription" placeholder="Enter Product Description" name="description" rows="5">${product.description}</textarea>
            </div>
            
            <div class="form-group">
                <label for="productPrice">Product Price:</label>
                <input type="number" class="form-control"  placeholder="Enter Price of Product" id="productPrice" name="price" value="${product.price}">
            </div>
            
            <button type="submit" class="btn btn-warning">Update</button>
            <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
    </div>

    <!-- Bootstrap JS and jQuery (for Bootstrap functionalities) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>