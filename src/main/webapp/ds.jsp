<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<h2 style="text-align: center;">Danh sách bạn bè</h2>
	<div class="container mt-5">
		<table class="table table-hover">
		  <thead>
		    <tr class="table-primary">
		      <th scope="col">id</th>
		      <th scope="col">Họ và Tên</th>
		      <th scope="col">Số điện thoại</th>
		      <th scope="col">Email</th>
		      <th scope="col">Mạng XH</th>
		      <th scope="col">Dịa chỉ</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="item" items="${list}">
		    	<tr>
			      <th scope="row">${item.id}</th>
			      <td>${item.hoVaTen}</td>
			      <td>${item.sdt}</td>
			      <td>${item.email}</td>
			      <td><a href="${item.linkSocial}">${item.linkSocial}</a></td>
			      <td>${item.diaChi}</td>
			      <td><a href="/BanBe/sua?id=${item.id}">Sửa</a>/<a href="/BanBe/xoa?id=${item.id}" onclick="return confirmDelete()">Xóa</a></td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal">
		  Thêm bạn
		</button>
	</div>
	
	
	
	<!-- Modal add-->
	<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="addModalLabel">Thêm bạn mới</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
			<form action="/BanBe/them" method="post" onsubmit="return validateForm()" accept-charset="UTF-8">
				<div class="mb-3">
				  <label class="form-label">Họ và Tên</label>
				  <input type="text" name="hoVaTen" class="form-control" >
				</div>
				<div class="mb-3">
				  <label class="form-label">Số điện thoại</label>
				  <input type="text" name="sdt" class="form-control" >
				</div>
				<div class="mb-3">
				  <label class="form-label">Email</label>
				  <input type="text" name="email" class="form-control" >
				</div>
				<div class="mb-3">
				  <label  class="form-label">Link social</label>
				  <input type="text" name="linkSocial" class="form-control" >
				</div>
				<div class="mb-3">
				  <label class="form-label">Địa chỉ</label>
				  <textarea name="diaChi" class="form-control" ></textarea>
				</div>
				<input type="submit" class="btn btn-primary" value="Save">
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	    function validateForm() {
	        const hoVaTen = document.forms[0]["hoVaTen"].value;
	        const sdt = document.forms[0]["sdt"].value;
	        const email = document.forms[0]["email"].value;
	        const linkSocial = document.forms[0]["linkSocial"].value;
	        const diaChi = document.forms[0]["diaChi"].value;
	
	        // Kiểm tra trường trống
	        if (!hoVaTen || !sdt || !email || !linkSocial || !diaChi) {
	            alert("Vui lòng điền vào tất cả các trường.");
	            return false;
	        }
	
	        // Kiểm tra định dạng số điện thoại
	        const phoneRegex = /^[0-9]{9,11}$/;
	        if (!phoneRegex.test(sdt)) {
	            alert("Số điện thoại không hợp lệ. Vui lòng nhập số điện thoại từ 9 đến 11 chữ số.");
	            return false;
	        }
	
	        return true; // Form hợp lệ
	    }
	    
	    function confirmDelete(){
	    	return confirm("Bạn có chắc xóa");
	    }
	</script>
</body>
</html>