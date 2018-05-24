function getUserPosition(x) {
	if (x == 1)
		{
		return "Manager";
		}
	else
		{
		return "Employee";
		}
}

function getUser(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		console.log(res.user_id);
		deleteDiv();
		createUserPageHeader();
		createUserPageBody(res);

		/*
		 * var para = document.createElement("P"); var t =
		 * document.createTextNode("User ID: " + res.user_id + " Username: " +
		 * res.userName + " First Name: " + res.firstName + " Last Name: " +
		 * res.lastName + " Email: " + res.email); para.appendChild(t);
		 * console.log(para);
		 * document.getElementById("dynamicEmployeeBody").appendChild(para);
		 */
	}
}

// Get information on their own user info
function getUserInfo(param) {
	sendAjaxPost("http://localhost:8085/Project1/master", getUser, param);
}

function getUsersInfo(param) {
	sendAjaxPost("http://localhost:8085/Project1/master", getAllUsers, param);
}
/*
 * function updateUserInfo(param) {
 * sendAjaxPost("http://localhost:8085/Project1/employeeinfo", updateUser,
 * param); }
 */



function getAllUsers(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		let res = JSON.parse(xhr.responseText);
		console.log(res);
		deleteDiv();
		createUsersInfoHeader();
		createUsersInfoTable();

		for ( var i in res) {
			var trm = document.createElement("tr");

			var td1 = document.createElement("td");
			var td2 = document.createElement("td");
			var td3 = document.createElement("td");
			var td4 = document.createElement("td");
			var td5 = document.createElement("td");
			var td6 = document.createElement("td");
			var txt1 = document.createTextNode(res[i].user_id);
			var txt2 = document.createTextNode(res[i].userName);
			var txt3 = document.createTextNode(res[i].firstName);
			var txt4 = document.createTextNode(res[i].lastName);
			var txt5 = document.createTextNode(res[i].email);
			var txt6 = document.createTextNode(getUserPosition(res[i].superUser));

			td1.appendChild(txt1);
			td2.appendChild(txt2);
			td3.appendChild(txt3);
			td4.appendChild(txt4);
			td5.appendChild(txt5);
			td6.appendChild(txt6);
			trm.appendChild(td1);
			trm.appendChild(td2);
			trm.appendChild(td3);
			trm.appendChild(td4);
			trm.appendChild(td5);
			trm.appendChild(td6);
			var section = document.getElementById("targettable");
			 document.getElementById("targettable").appendChild(trm);

		}
	}
	
}

