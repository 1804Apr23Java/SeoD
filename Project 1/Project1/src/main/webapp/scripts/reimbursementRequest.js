
function pendingStateShow(x) {
	switch (x) {
	case 0:
		return "Pending";
	case 1:
		return "Rejected";
	case 2:
		return "Resolved";
	}
}

function getReimbursementsEmployee(setup, param) {
	employeeReimburses = setup;
	console.log(employeeReimburses + ' finalize');
	sendAjaxPost("http://localhost:8085/Project1/master", getEmployeeReimbursements, param);
}

function showReimbursements(res, x) {
	var clear = document.getElementById("dynamicEmployeeBody");
	while (clear.firstChild) {
		clear.removeChild(clear.firstChild);
	}
	for ( var i in res) {
		if (res[i].pendingState === x || x == 3) {
			var para = document.createElement("P");
			var t = document
					.createTextNode("Your Reimbursements: Reimbursement ID: "
							+ res[i].reId + "     Expenses: " + res[i].expenses
							+ "     Pending State: "
							+ pendingStateShow(res[i].pendingState)
							+ "      Manager View: " + res[i].managerView);
			para.appendChild(t);
			console.log(para);
			document.getElementById("dynamicEmployeeBody").appendChild(para);
		}
	}
}

function getEmployeeReimbursements(xhr) {
	if (xhr.responseText) {
		let y = employeeReimburses;
		console.log(xhr.responseText);
		let res = JSON.parse(xhr.responseText);
		console.log(res);
		showReimbursements(res, y);
	}
}

