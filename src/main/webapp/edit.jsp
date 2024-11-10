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
	<div class="container">
		<form action="/BanBe/sua" method="post" onsubmit="return validateForm()" accept-charset="UTF-8">
			<div class="mb-3">
			  <label class="form-label">Họ và Tên</label>
			  <input type="text" name="hoVaTen" class="form-control" value="${item.hoVaTen}">
			</div>
			<div class="mb-3">
			  <label class="form-label">Số điện thoại</label>
			  <input type="text" name="sdt" class="form-control" value="${item.sdt}">
			</div>
			<div class="mb-3">
			  <label class="form-label">Email</label>
			  <input type="text" name="email" class="form-control" value="${item.email}">
			</div>
			<div class="mb-3">
			  <label  class="form-label">Link social</label>
			  <input type="text" name="linkSocial" class="form-control" value="${item.linkSocial}">
			</div>
			<div class="mb-3">
			  <label class="form-label">Địa chỉ</label>
			  <textarea name="diaChi" class="form-control">${item.diaChi}</textarea>
			</div>
			<input type="hidden" name="id" value="${item.id}">
			<input type="submit" class="btn btn-primary" value="Save">
		</form>
		<a href="/BanBe/ds">
			<button type="button" class="btn btn-warning mt-5">
			  Cancel
			</button>
		</a>
		
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
	</script>
</body>
</html>