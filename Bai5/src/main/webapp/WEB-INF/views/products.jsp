<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Danh sách sản phẩm</h2>
    <table class="table table-bordered table-hover" id="productTable">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Mô tả</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<!-- Bootstrap JS bundle (bao gồm Popper) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
    $(document).ready(function () {
        $.ajax({
            url: "/api/products",
            method: "GET",
            success: function (data) {
                let tbody = "";
                $.each(data, function (i, product) {
                    tbody += "<tr>" +
                        "<td>" + product.id + "</td>" +
                        "<td>" + product.name + "</td>" +
                        "<td>" + product.price + "</td>" +
                        "<td>" + product.description + "</td>" +
                        "</tr>";
                });
                $("#productTable tbody").html(tbody);
            },
            error: function() {
                alert("Không tải được danh sách sản phẩm!");
            }
        });
    });
</script>
</body>
</html>
