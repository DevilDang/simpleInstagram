
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div class="container-fluid">
	<div class="center">
	
	<spring:url value="/resources/img/cover.jpg" var="coverImg" />
		<img width="100%" height="100px" src="${coverImg}">
	</div>
	<div class="panel panel-primary">
		<div class="panel-heading">Login and Registration</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<h2>Login</h2>
					<ul>
					<li>${error}</li>
					</ul>
					<form id="loginForm" method="post" class="form-login"
						onsubmit="return validateLoginForm();" action="login"
						data-toggle="validator" role="form">

						<div class="form-group">
							<label class="sr" for="username">Email</label> <input id="email"
								type="text" class="form-control" name="email" required />
						</div>

						<div class="form-group">
							<label class="sr" for="inputPassword">Password</label> <input
								id="password" type="password" class="form-control"
								name="password" required>
						</div>
						<button class="btn btn-lg btn-primary btn-block" type="submit"
							name="login">Login</button>


					</form>

				</div>

				<div class="col-sm-2"></div>

				<div class="col-sm-3">
					<h2>Registration</h2>
					<ul>
					<li>${mesageSignUp}</li>
					</ul>
					<form id="loginForm" method="post" class="form-login"
						action="signup" data-toggle="validator" role="form">

						<div class="form-group">
							<label class="sr" for="username">Full Name</label> <input
								id="username" type="text" class="form-control" name="username"
								required />
						</div>
						<div class="form-group">
							<label class="sr" for="inputPassword">Email</label> <input
								id="email" type="text" class="form-control" name="email"
								required>
						</div>
						<div class="form-group">
							<label class="sr" for="inputPassword">Password</label> <input
								id="password" type="password" class="form-control"
								name="password" required>
						</div>

						<button class="btn btn-lg btn-primary btn-block" type="submit"
							name="signup">Sig Up</button>

					</form>
				</div>

				<div class="col-sm-2"></div>
			</div>
		</div>
	</div>

</div>
