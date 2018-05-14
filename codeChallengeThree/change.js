let submitForm = document.getElementById("submitForm");
submitForm.addEventListener("click", function(){
    let p = document.createElement('P');
    
    p.innerHTML = 'New Book Title: ' +document.getElementById("inputName").value+', Author: ' +document.getElementById("inputauthor").value+ ', Genre: ' +document.getElementById("inputgenre").value;

    document.body.appendChild(p);
});