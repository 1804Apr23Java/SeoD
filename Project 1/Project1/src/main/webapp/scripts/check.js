function sessionUser(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		if (res.username) {
			document.getElementById("user").innerHTML = "You are logged in as: "
					+ res.username;
		} else {
			window.location = "http://localhost:8085/Project1/login";
		}
	} else {
		window.location = "http://localhost:8085/Project1/login";
	}
}


window.onload = function() {
	console.log("executed window.onload");
	sendAjaxGet("http://localhost:8085/Project1/session", sessionUser);
}