<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
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
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User
					Registration </a>
			</div>
		</nav>
	</header>
	<br>
	<!--  form action="RegisterServlet" method="post">
		Name:<input type="text" name="userName" /><br /> Password:<input
			type="password" name="password" /><br /> Email Id:<input
			type="text" name="email" /><br /> Language: <select name="language">
			<option>Hindi</option>
			<option>English</option>
			<option>French</option>
		</select> <br /> <input type="submit" value="Submit" />
	</form -->

	<div class="container-fluid h-custom">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign
										up</p>

									<form class="mx-1 mx-md-4" action="RegisterServlet"
										method="post">

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" name="userName" id="form3Example1c"
													class="form-control" /> <label class="form-label"
													for="form3Example1c">Your Name</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="email" name="email" id="form3Example3c"
													class="form-control" /> <label class="form-label"
													for="form3Example3c">Your Email</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fa fa-language fa-lg me-3 fa-fw" aria-hidden="true"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" name="language" id="form3Example3d"
													class="form-control" /> <label class="form-label"
													for="form3Example3d">Language</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" name="password" id="form3Example4c"
													class="form-control" /> <label class="form-label"
													for="form3Example4c">Password</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" name="repassword" id="form3Example4cd"
													class="form-control" /> <label class="form-label"
													for="form3Example4cd">Repeat your password</label>
											</div>
										</div>

										<div class="form-check d-flex justify-content-center mb-5">
											<input class="form-check-input me-2" type="checkbox" value=""
												id="form2Example3c" /> <label class="form-check-label"
												for="form2Example3"> I agree all statements in <a
												href="#!">Terms of service</a>
											</label>
										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg">Register</button>
										</div>

									</form>

								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img
										src="https://mdbootstrap.com/img/Photos/new-templates/bootstrap-registration/draw1.png"
										class="img-fluid" alt="Sample image">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>