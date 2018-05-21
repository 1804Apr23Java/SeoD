function getUser(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		let res = JSON.parse(xhr.responseText);
		console.log(res);
		var clear = document.getElementById("dynamicEmployeeBody");
		while(clear.firstChild){
		    clear.removeChild(clear.firstChild);
		}
		
			var para = document.createElement("P");
			var t = document.createTextNode("User ID: " + res.user_id + "   Username: " + res.userName + "    First Name: " + res.firstName +
					"    Last Name: " + res.lastName + "    Email: " + res.email);
			para.appendChild(t);
			console.log(para);
			document.getElementById("dynamicEmployeeBody").appendChild(para); 
			}
}
	
function getAllUsers(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		let res = JSON.parse(xhr.responseText);
		console.log(res);
		var clear = document.getElementById("dynamicEmployeeBody");
		while(clear.firstChild){
		    clear.removeChild(clear.firstChild);
		}
		for (var i in res) {
			var para = document.createElement("P");
			var t = document.createTextNode("User ID: " + res[i].user_id + "   Username: " + res[i].userName + "    First Name: " + res[i].firstName +
					"    Last Name: " + res[i].lastName + "    Email: " + res[i].email);
			para.appendChild(t);
			console.log(para);
			document.getElementById("dynamicEmployeeBody").appendChild(para); 
		}
	}
}

function getUserInfo(param) {
	sendAjaxPost("http://localhost:8085/Project1/master", getUser, param);
}

function getUsersInfo(param) {
	sendAjaxPost("http://localhost:8085/Project1/master", getAllUsers, param);
}
/*
function updateUserInfo(param) {
	sendAjaxPost("http://localhost:8085/Project1/employeeinfo", updateUser, param);
}
*/