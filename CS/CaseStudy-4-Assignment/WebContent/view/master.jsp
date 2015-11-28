<header>
		<span class="brand"><a href="/CaseStudy-4-Assignment/Home">myFirstVehicle</a>	</span>
		<form method="post" class="searchForm" action="/CaseStudy-4-Assignment/SearchResult">
			<input type="text" placeholder="Search For Car" name="model">
			<input src="http://www.clipartbest.com/cliparts/RcG/6j6/RcG6j67Xi.png" type="image">
		</form>
		<a href = "#" onClick="showLogin()">Login</a>
		<a href = "#" onClick="showSignup()">Sign Up</a>
	</header>
	<div class = "signupBackground" id="signupBackground" >
		<div id="form">
			<table>
				<form action="/CaseStudy-4-Assignment/Signup" method="post">
				<legend><h2>Signup</h3></legend><hr>
					<tr>
						<td>Enter Name:</td> <td><input type="text" name="name" placeholder="Enter Full Name" required></td>
					</tr>
					<tr>
						<td>Enter Password</td><td><input type="password" name="password" placeholder ="Enter Password" required></td>
					</tr>
					<tr>
						<td>Confirm Password</td><td><input type="password" name="cpassword" placeholder ="Confirm Password" required></td>
					</tr><tr>
						<td>Email</td><td><input type="email" name="email" placeholder ="Enter Email" required></td>
					</tr><tr>
						<td>Phone Number</td><td><input type="number" name="pNumber" placeholder ="Primary Phone Number" required></td>
					</tr>
					<tr>
						<td> <input type="submit" value="Signup"></td>
						<td> <input type="button" value="Close"onclick="hide()"></td>
					</tr>
				</form>
			</table>
		</div>
	</div>
	<div class = "loginBackground" id="loginBackground" >
		<div id="form">
			<table>
				<form action="/CaseStudy-4-Assignment/Login" method="post">
				<legend><h2>Login</h3></legend><hr>
					<tr>
						<td>Enter Email:</td> 
						<td><input type="text" name="name" placeholder="Enter Username" required></td>
					</tr>
					<tr>
						<td>Enter Password</td>
						<td><input type="password" name="password" placeholder ="Enter Password" required></td>
					</tr>
					<tr>
						<td> <input type="submit" value="Login"></td>
						<td> <input type="button" value="Close"onclick="hide()"></td>
					</tr>
				</form>
			</table>
		</div>
	</div>