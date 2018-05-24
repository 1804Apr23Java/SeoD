function deleteDiv() {
	var clear = document.getElementById("dynamicEmployeeBody");
	while (clear.firstChild) {
		clear.removeChild(clear.firstChild);
	}
}

function createUserPageHeader() {
	let div1 = document.createElement("div");
	div1.setAttribute("class", "row");
	let div2 = document.createElement("div");
	div2.setAttribute("class", "col-md-12");
	let h1 = document.createElement("h1");
	h1.setAttribute('class', 'page-head-line');
	h1.innerHTML = "User Page";
	let h2 = document.createElement("h1");
	h2.setAttribute('class', 'page-subhead-line');
	h2.innerHTML = "Your feedback is important to us! Please fill out an employee experience questionnaire!";
	document.getElementById("dynamicEmployeeBody").appendChild(div1);
	div1.appendChild(div2);
	div2.appendChild(h1);
	div2.appendChild(h2);
}

function createUserPageBody(res) {
	let div1 = document.createElement("div");
	div1.setAttribute("class", "row");
	let div2 = document.createElement("div");
	div2.setAttribute("class", "col-md-6 col-sm-6 col-xs-12");
	let div3 = document.createElement("div");
	div3.setAttribute("class", "panel panel-info");
	let div4 = document.createElement("div");
	div4.setAttribute("class", "panel-body");
	let form = document.createElement("form");
	form.setAttribute("role", "form");
	form.setAttribute("action", "employeeinfo");
	form.setAttribute("method", "post");
	
	let f1 = document.createElement("div");
	f1.setAttribute("class", "form-group");
	let l1 = document.createElement("label");
	l1.innerHTML = "User ID:"
	let i1 = document.createElement("input");
	i1.setAttribute("class", "form-control");
	i1.setAttribute("type", "text");
	i1.setAttribute("value", res.user_id);
	
	f1.appendChild(l1);
	f1.appendChild(i1);
	form.appendChild(f1);
	
	let f2 = document.createElement("div");
	f2.setAttribute("class", "form-group");
	let l2 = document.createElement("label");
	l2.innerHTML = "Username:"
	let i2 = document.createElement("input");
	i2.setAttribute("name", "username");
	i2.setAttribute("class", "form-control");
	i2.setAttribute("type", "text");
	i2.setAttribute("value", res.userName);
	
	f2.appendChild(l2);
	f2.appendChild(i2);
	form.appendChild(f2);
	
	let f3 = document.createElement("div");
	f3.setAttribute("class", "form-group");
	let l3 = document.createElement("label");
	l3.innerHTML = "First Name:"
	let i3 = document.createElement("input");
	i3.setAttribute("name", "first_name");
	i3.setAttribute("class", "form-control");
	i3.setAttribute("type", "text");
	i3.setAttribute("value", res.firstName);
	
	f3.appendChild(l3);
	f3.appendChild(i3);
	form.appendChild(f3);
	
	let f4 = document.createElement("div");
	f4.setAttribute("class", "form-group");
	let l4 = document.createElement("label");
	l4.innerHTML = "Last Name:"
	let i4 = document.createElement("input");
	i4.setAttribute("name", "last_name");
	i4.setAttribute("class", "form-control");
	i4.setAttribute("type", "text");
	i4.setAttribute("value", res.lastName);
	
	f4.appendChild(l4);
	f4.appendChild(i4);
	form.appendChild(f4);
	
	let f5 = document.createElement("div");
	f5.setAttribute("class", "form-group");
	let l5 = document.createElement("label");
	l5.innerHTML = "Email:"
	let i5 = document.createElement("input");
	i5.setAttribute("name", "new_email");
	i5.setAttribute("class", "form-control");
	i5.setAttribute("type", "email");
	i5.setAttribute("value", res.email);
	
	f5.appendChild(l5);
	f5.appendChild(i5);
	form.appendChild(f5);
	
	let button = document.createElement("button");
	button.setAttribute("type", "submit");
	button.setAttribute("class", "btn btn-info");
	button.innerHTML = "Update";
	
	form.appendChild(button);
	
	div4.appendChild(form);
	div3.appendChild(div4);
	div2.appendChild(div3);
	div1.appendChild(div2);
	document.getElementById("dynamicEmployeeBody").appendChild(div1);
	
}

function createReimburseHeader(x) {
	let div1 = document.createElement("div");
	div1.setAttribute("class", "row");
	let div2 = document.createElement("div");
	div2.setAttribute("class", "col-md-12");
	let h1 = document.createElement("h1");
	h1.setAttribute('class', 'page-head-line');
	if (typeof x === 'string') {
		h1.innerHTML = x;
	}
	else {
		h1.innerHTML = "Your Reimbursements";
	}
	let h2 = document.createElement("h1");
	h2.setAttribute('class', 'page-subhead-line');
	h2.innerHTML = "Remember, reimbursements are not used to cover for medical expenses!";
	document.getElementById("dynamicEmployeeBody").appendChild(div1);
	div1.appendChild(div2);
	div2.appendChild(h1);
	div2.appendChild(h2);

}

function createReimburseTable() {
	let div1 = document.createElement("div");
	div1.setAttribute("class", "row");
	let div2 = document.createElement("div");
	div2.setAttribute('class', 'col-md-12');
	let div3 = document.createElement("div");
	div3.setAttribute('class', 'panel panel-default');
	let div4 = document.createElement("div");
	div4.setAttribute('class', 'panel-heading');
	let div5 = document.createElement("div");
	div5.setAttribute('class', 'panel-body');
	let div6 = document.createElement("div");
	div6.setAttribute('class', 'table-responsive');

	let table = document.createElement("table");
	table.setAttribute('class', 'table table-hover');
	let thead = document.createElement("thead");
	let tr = document.createElement("tr");
	let th1 = document.createElement("th");
	th1.innerHTML = "ID";
	let th2 = document.createElement("th");
	th2.innerHTML = "Expenses";
	let th3 = document.createElement("th");
	th3.innerHTML = "Pending State";
	let th4 = document.createElement("th");
	th4.innerHTML = "Resolved By";
	let th5 = document.createElement("th");
	th5.innerHTML = "Date Created"
	let th6 = document.createElement("th");
	th6.innerHTML = "Date Resolved"
	let tbody = document.createElement("tbody");
	tbody.setAttribute('id', 'targettable');

	/*
	 * var att2 = document.createAttribute("class"); att2.value = "row";
	 * h2.setAttributeNode(att2);
	 */

	document.getElementById("dynamicEmployeeBody").appendChild(div1);
	div1.appendChild(div2);
	div2.appendChild(div3);
	div3.appendChild(div4);
	div4.appendChild(div5);
	div5.appendChild(div6);
	div6.appendChild(table);
	table.appendChild(thead);
	thead.appendChild(tr);
	tr.appendChild(th1);
	tr.appendChild(th2);
	tr.appendChild(th3);
	tr.appendChild(th4);
	tr.appendChild(th5);
	tr.appendChild(th6);
	table.appendChild(tbody);
}

function createUsersInfoHeader() {
	let div1 = document.createElement("div");
	div1.setAttribute("class", "row");
	let div2 = document.createElement("div");
	div2.setAttribute("class", "col-md-12");
	let h1 = document.createElement("h1");
	h1.setAttribute('class', 'page-head-line');
	h1.innerHTML = "User Page";
	let h2 = document.createElement("h1");
	h2.setAttribute('class', 'page-subhead-line');
	h2.innerHTML = "Remember, reimbursements are not used to cover for medical expenses!";
	document.getElementById("dynamicEmployeeBody").appendChild(div1);
	div1.appendChild(div2);
	div2.appendChild(h1);
	div2.appendChild(h2);

}

function createUsersInfoHeader() {
	let div1 = document.createElement("div");
	div1.setAttribute("class", "row");
	let div2 = document.createElement("div");
	div2.setAttribute("class", "col-md-12");
	let h1 = document.createElement("h1");
	h1.setAttribute('class', 'page-head-line');
	h1.innerHTML = "Employee List";
	let h2 = document.createElement("h1");
	h2.setAttribute('class', 'page-subhead-line');
	h2.innerHTML = "List of all the bloodsuckers";
	document.getElementById("dynamicEmployeeBody").appendChild(div1);
	div1.appendChild(div2);
	div2.appendChild(h1);
	div2.appendChild(h2);

}

function createUsersInfoTable() {
	let div1 = document.createElement("div");
	div1.setAttribute("class", "row");
	let div2 = document.createElement("div");
	div2.setAttribute('class', 'col-md-12');
	let div3 = document.createElement("div");
	div3.setAttribute('class', 'panel panel-default');
	let div4 = document.createElement("div");
	div4.setAttribute('class', 'panel-heading');
	let div5 = document.createElement("div");
	div5.setAttribute('class', 'panel-body');
	let div6 = document.createElement("div");
	div6.setAttribute('class', 'table-responsive');

	let table = document.createElement("table");
	table.setAttribute('class', 'table table-hover');
	let thead = document.createElement("thead");
	let tr = document.createElement("tr");
	let th1 = document.createElement("th");
	th1.innerHTML = "User ID";
	let th2 = document.createElement("th");
	th2.innerHTML = "Username";
	let th3 = document.createElement("th");
	th3.innerHTML = "First Name";
	let th4 = document.createElement("th");
	th4.innerHTML = "Last Name";
	let th5 = document.createElement("th");
	th5.innerHTML = "Email"
	let th6 = document.createElement("th");
	th6.innerHTML = "Position"
	let tbody = document.createElement("tbody");
	tbody.setAttribute('id', 'targettable');

	document.getElementById("dynamicEmployeeBody").appendChild(div1);
	div1.appendChild(div2);
	div2.appendChild(div3);
	div3.appendChild(div4);
	div4.appendChild(div5);
	div5.appendChild(div6);
	div6.appendChild(table);
	table.appendChild(thead);
	thead.appendChild(tr);
	tr.appendChild(th1);
	tr.appendChild(th2);
	tr.appendChild(th3);
	tr.appendChild(th4);
	tr.appendChild(th5);
	tr.appendChild(th6);
	table.appendChild(tbody);
}

function goToReimburseSearch() {
	deleteDiv();
	createReimburseHeader("Employee Reimbursements");
	let i1 = document.createElement("input");
	i1.setAttribute("type","search");
	i1.setAttribute("id", "mySearch");
	let button = document.createElement("button");
	button.setAttribute("onclick", "getReimbursementsSingleEmployee(3, 'managerViewReimbursementsViaUser')");
	button.innerHTML = "Search";
	document.getElementById("dynamicEmployeeBody").appendChild(i1);
	document.getElementById("dynamicEmployeeBody").appendChild(button);
}

function goToNewReimbursementSubmission() {
	deleteDiv();
	createReimburseHeader("New Reimbursement Submission")
	let form = document.createElement("form");
	form.setAttribute("class", "box");
	form.setAttribute("action", "upload");
	form.setAttribute("method", "post");
	let fieldset = document.createElement("fieldset");
	let legend = document.createElement("legend");
	legend.innerHTML = "New Expenses:";
	let i1 = document.createElement("input");
	i1.setAttribute("name", "expenses");
	let br = document.createElement("br");
	let i2 = document.createElement("input");
	i2.setAttribute("type", "submit");
	i2.setAttribute("onsubmit", "alert('New Reimbursement Sent');");
	i2.setAttribute("value", "New Reimbursement");
	
	let form1 = document.createElement("form");
	form1.setAttribute("action", "uploadfile");
	form1.setAttribute("method", "post");
	form1.setAttribute("enctype", "multipart/form-data");
	let i3 = document.createElement("input");
	i3.setAttribute("type", "file");
	i3.setAttribute("name", "photo");
	i3.setAttribute("size", "50");
	let i4 = document.createElement("input");
	i4.setAttribute("type", "submit");
	i3.setAttribute("submit", "Save");
	
	
	document.getElementById("dynamicEmployeeBody").appendChild(form);
	form.appendChild(fieldset);
	fieldset.appendChild(legend);
	fieldset.appendChild(i1);
	form.appendChild(br);
	form.appendChild(i2);
	
	document.getElementById("dynamicEmployeeBody").appendChild(form1);
	form1.appendChild(i3);
	form1.appendChild(i4);
}


