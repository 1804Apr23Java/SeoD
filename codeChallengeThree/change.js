function book (title, author, genre, coverPath) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.coverPath = coverPath;
}

book1 = new book('Solomonica de Winter', 'Archter de Regenboog', 'Genre: Mystery', 'book1.jpg');
book2 = new book('Before She was Harriet', 'Lesa Cline-Ransome', 'Genre: History', 'book2.jpg');
book3 = new book('The Magic Bird', 'Some author', 'Genre: Horror', 'book3.jpg');

let submitForm = document.getElementById("submitForm");
submitForm.addEventListener("click", function(){
    let p = document.createElement('P');
    bookx = new book(document.getElementById("inputName").value, document.getElementById("inputauthor").value, document.getElementById("inputgenre").value);
    p.innerHTML = 'New Book Title: ' + document.getElementById("inputName").value+', Author: ' +document.getElementById("inputauthor").value+ ', Genre: ' +document.getElementById("inputgenre").value;

    document.body.appendChild(p);
});