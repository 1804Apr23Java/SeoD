/*
1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
*/
function getUSA()
{
    var x = document.querySelectorAll('span[data-customAttr="USA"]');
    for (var i = 0; i < x.length; i++) {
    console.log(x[i].innerHTML);
    }

}

//getUSA();

/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
*/

function getPeopleInSales() 
{
    var x = document.getElementsByClassName('empName');

    for (var i = 0; i < x.length; i++)
    {
        if (x[i].nextElementSibling.innerHTML === 'Sales')
        {
            console.log(x[i].innerHTML);
        }
    }
}

//getPeopleInSales();

/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
*/

function getAnchorChildren() {
    var x = document.getElementsByTagName('a');
    //console.log(x);
    for(var i = 0; i < x.length; i++) {
        var y = x[i].firstElementChild;
        for (var j = 0; j < x[i].childElementCount; j++) {
            if (y.tagName === 'SPAN') {
                console.log(y.innerHTML);
            }
        }
    }
}

//getAnchorChildren();

/*
4. Hobbies
Define function 	
Find all checked options in the 'skills' select element.

Print the value and the contents.
*/

function getHobbies() {
    var x = document.getElementsByName('skills');
    var y = x[0].firstElementChild;
    for (var i = 0; i < x[0].childElementCount; i++) {
        console.log(y.getAttribute('value') + '  ' + y.innerHTML);
        y = y.nextElementSibling;
    }
}

//getHobbies();

/*
5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.

*/


function getCustomerAttribute() {
    var x = document.querySelectorAll('[data-customAttr]');
    for (var i = 0; i < x.length; i++) {
        console.log(x[i].getAttribute('data-customAttr') + '  ' + x[i].tagName);
    }

}

//getCustomerAttribute();


/*
6. Sum Event

NOTE: Write unobtrusive Javascript

Regarding these elements:
	
<input id="num1" class="nums" type="text"/>
	
<input id="num2" class="nums" type="text"/>
	
<h3>Sum: span id="sum"></span></h3>


Define onchange event handler.

Add <input> element values.

Put the sum in the <span> element.

If values cannot be added, put "Cannot add" in the <span> element
*/
var num1 = document.getElementById('num1');
var num2 = document.getElementById('num2');

function reAdd() {
    var x = Number(num1.value);
    var y = Number(num2.value);
    sum = x + y;
    if (!isNaN(sum)) {
        document.getElementById('sum').innerHTML = sum;
    }
    else {
        document.getElementById('sum').innerHTML = 'Cannot Add';
    }

}

num1.addEventListener('change', reAdd);
num2.addEventListener('change', reAdd);

/*
7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/

var x = document.getElementsByName('skills');
y = x[0];
y.addEventListener('change', function() {
    alert('Are you sure ' + y.options[y.selectedIndex].text + ' is one of your skills?');
});


/*
8. Favorite Color Event

NOTE: Write unobtrusive Javascript

NOTE: This is regarding the favoriteColor radio buttons.

When a user selects a color, create an alert with a message similar to:
	
"So you like green more than blue now?"

In this example, green is the new value and blue is the old value.

Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor

*/
var x = document.getElementsByName('favoriteColor');
var newColor = '';
var oldColor = 'the default color';
for (var i = 0; i < x.length; i++) {
    x[i].addEventListener('change', function() {
        alert('So you like ' + this.value + ' more than ' + oldColor +' now?');
        //x.style.color = this.value; somehoe need to fix
        oldColor = this.value;
    });
}
/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.

*/

var x = document.getElementsByClassName('empName');
for (var i = 0; i < x.length; i++) {
    x[i].addEventListener('mouseover', function() {
        if (this.style.opacity == 0) {
            this.style.opacity = 1;
        }
        else {
            this.style.opacity = 0;
        }
    });
}    
/*
10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/

setInterval(function() {
    x = new Date();
    document.getElementById('currentTime').innerHTML = x.toLocaleTimeString();
}, 1000 )

/*
11. Delay
Regarding this element:
	s
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/


document.getElementById('helloWorld').addEventListener('click', function() {
    setTimeout(function() {
        document.getElementById('helloWorld').style.color = '#'+(Math.trunc(Math.random() * 10000000)).toString(16);
    }, 3000);
});

/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/

function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while(node) {
        walkTheDOM(node,func);
        node = node.nextSibling;
    }

}

function func(node) {
    if (node.tagName != null) {
    console.log(node.tagName);
    }
}
/*
var start = document.getElementsByTagName('html');
walkTheDOM(start[0], func);
*/