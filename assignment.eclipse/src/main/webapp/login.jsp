<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MakanJourney</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div class="col-sm-6">
				<a href="<%=request.getContextPath()%>/LoginServlet/home"
					class="navbar-brand"> Makan Journey - Where Food Origins </a>
			</div>
		</nav>
	</header>
	<br>
	<!-- form action="LoginServlet/login" method="post">
		Username:<input type="text" name="userName" /><br /> 
		Password:<input type="password" name="userPass" /><br /> 
		<input type="submit" value="Submit" /><br />
	</form>
	<a href="<%=request.getContextPath()%>/LoginServlet/forgot"
					class="nav-link">Forgot Password</a -->

	<!-- Code from https://mdbootstrap.com/docs/standard/extended/login/ -->
	<div class="row">
		<!--  div class="container-fluid"-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6 text-black">
					<div
						class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

						<form style="width: 23rem;"
							action="<%=request.getContextPath()%>/LoginServlet/login"
							method="post">

							<!-- h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Log
								in</h3 -->
							<h3 class="fw-normal mt-5 mb-4">Login</h3>

							<div class="form-outline mb-4">
								<input type="text" id="form2Example18" name="username"
									class="form-control form-control-lg" /> <label
									class="form-label" for="form2Example18">Username</label>
							</div>

							<div class="form-outline mb-4">
								<input type="text" id="form2Example28" name="password"
									class="form-control form-control-lg" /> <label
									class="form-label" for="form2Example28">Password</label>
							</div>

							<div class="pt-1 mb-4">
								<button class="btn btn-info btn-lg btn-block" type="submit">Login</button>
							</div>
							<p>
								Don't have an account? <a href="#!" class="link-info">Register
									here</a>
							</p>

						</form>

					</div>

				</div>
				<div class="col-sm-6 px-0 d-none d-sm-block">
					<img
						src="https://images.unsplash.com/photo-1489641024260-20e5cb3ee4aa?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1033&q=80"
						alt="Login image" class="w-100 h-100"
						style="object-fit: cover; object-position: 50% 50%;">
				</div>
			</div>
		</div>
	</div>
</body>
</html>