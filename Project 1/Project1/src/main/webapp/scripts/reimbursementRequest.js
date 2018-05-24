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
	sendAjaxPost("http://localhost:8085/Project1/master",
			getEmployeeReimbursements, param);
}

function getReimbursementsSingleEmployee(setup, param) {
	employeeReimburses = setup;
	console.log(employeeReimburses + ' finalized');
	console.log(document.getElementById("mySearch").value);
	sendAjaxPostUsername("http://localhost:8085/Project1/master",
			getEmployeeReimbursements, param, document
					.getElementById("mySearch").value);
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

//New version
function showReimbursements(res, x) {
	var table = document.getElementById("dynamicEmployeeBody");
	
	while (table.firstChild) {
		table.removeChild(table.firstChild);
	}
	createReimburseHeader();
	createReimburseTable();
	console.log(res);
	for ( var i in res) {
		if (res[i].pendingState === x || x == 3) {
			var trm = document.createElement("tr");
			trm.setAttribute('onclick', "getSingleReimbursement(this.firstChild.innerHTML)");
			var td1 = document.createElement("td");
			var td2 = document.createElement("td");
			var td3 = document.createElement("td");
			var td4 = document.createElement("td");
			var td5 = document.createElement("td");
			var td6 = document.createElement("td");
			var txt1 = document.createTextNode(res[i].reId);

			var txt2 = document.createTextNode("$" + res[i].expenses);
			var txt3 = document.createTextNode(pendingStateShow(res[i].pendingState));
			var txt4 = document.createTextNode(res[i].managerView);
			var txt5 = document.createTextNode("Needs Date");
			var txt6 = document.createTextNode("Needs Date");

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
			section.appendChild(trm);
		}
	}
}


function getSingleReimbursement(x) {
	var employeeReimburses = 3;
	console.log("testing1");
	sendAjaxPostReil("http://localhost:8085/Project1/master", getReimbursementPage, "singleReimbursementById", x);
	console.log("testingFinal");
}

function sendAjaxPostReil(url, func, param, reId) {
	console.log("testing22");
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	}
	console.log("testing3");
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("stringParameter=" + param + "&requestingReimburse=" + reId);
	
}

function getReimbursementPage(xhr) {
	if (xhr.responseText) {
		console.log(xhr.responseText);
		let res = JSON.parse(xhr.responseText);
		console.log(res);
		deleteDiv();
		createReimburseHeader();
		createReimburseTable();
		var trm = document.createElement("tr");
		var td1 = document.createElement("td");
		td1.setAttribute("id", "retrieve")
		var td2 = document.createElement("td");
		var td3 = document.createElement("td");
		var td4 = document.createElement("td");
		var td5 = document.createElement("td");
		var td6 = document.createElement("td");
		var txt1 = document.createTextNode(res.reId);

		var txt2 = document.createTextNode("$" + res.expenses);
		var txt3 = document.createTextNode(pendingStateShow(res.pendingState));
		var txt4 = document.createTextNode(res.managerView);
		var txt5 = document.createTextNode("Needs Date");
		var txt6 = document.createTextNode("Needs Date");

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
		section.appendChild(trm);
		
		let l1 = document.createElement("label");
		l1.setAttribute("class", "containerp");
		l1.innerHTML = "None";
		let i1 = document.createElement("input");
		i1.setAttribute("type", "radio");
		i1.setAttribute("checked", "checked");
		i1.setAttribute("name", "radio");
		let s1 = document.createElement("span");
		s1.setAttribute("class", "checkmarkp");
		
		let l2 = document.createElement("label");
		l2.setAttribute("class", "containerp");
		l2.innerHTML = "Reject";
		let i2 = document.createElement("input");
		i2.setAttribute("type", "radio");
		i2.setAttribute("name", "radio");
		i2.setAttribute("value", "Reject");
		let s2 = document.createElement("span");
		s2.setAttribute("class", "checkmarkp");
		
		let l3 = document.createElement("label");
		l3.setAttribute("class", "containerp");
		l3.innerHTML = "Resolve";
		let i3 = document.createElement("input");
		i3.setAttribute("type", "radio");
		i3.setAttribute("name", "radio");
		i3.setAttribute("value", "Resolve");
		let s3 = document.createElement("span");
		s3.setAttribute("class", "checkmarkp");
		
		let button = document.createElement("button");
		button.setAttribute("type", "submit");
		button.setAttribute("onclick", "checkResolution()");
		button.setAttribute("class", "btn btn-info");
		button.innerHTML = "Update";
		
		
		
		document.getElementById("dynamicEmployeeBody").appendChild(l1);
		l1.appendChild(i1);
		l1.appendChild(s1);
		document.getElementById("dynamicEmployeeBody").appendChild(l2);
		l2.appendChild(i2);
		l2.appendChild(s2);
		document.getElementById("dynamicEmployeeBody").appendChild(l3);
		l3.appendChild(i3);
		l3.appendChild(s3);
		document.getElementById("dynamicEmployeeBody").appendChild(button);
	}
}


function checkResolution() {
	var x = document.getElementsByName("radio");
	console.log(x);
	var radioReturn;
	console.log("test1");
	for (var i = 0; i < x.length; i++) {
		console.log("testing");
		console.log(x);
		if (x[i].checked) {
			console.log("test final");
			radioReturn = x[i].value;
		}
	}
	sendAjaxPostReil("http://localhost:8085/Project1/master", getReimbursementPage, radioReturn, document.getElementById("retrieve").innerHTML);
	
	
	
}