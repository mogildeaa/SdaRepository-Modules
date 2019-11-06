var element = document.getElementById("div-2");
var elementClass = document.getElementsByClassName("class2");
console.log(element);
console.log(elementClass);

function myAlert(a) {
    alert(a);
}

var oldValue = document.getElementById("my-id").innerHTML;

function changeHtml() {
    //stocam intr-o variabila getElementById
    var element = document.getElementById("my-id");

    if (element.innerHTML === "altceva nou") {
        element.innerHTML = oldValue;
    } else {
        element.innerHTML = "altceva nou";
    }
}

// jQuery
console.log(jQuery);
var first = $("#doiId");
console.log(first);

var myButton = $("#changer");
var myDiv = $("#noul-myDiv");
//functie anonima
myButton.click(function () {
    var myObject = {
        color: "red", "background-color": "green"
    };
    myDiv.css(myObject);
    myDiv.text("new text");
});

//sau

// function clickerFunction() {
//     var myObject = {
//         color: "red", "background-color": "green"
//     };
//     myDiv.css(myObject);
//     myDiv.text("new text");
// }
//a se observa ca functiile nu necesita parantezele de la parametrii
// (daca functia nu are parametrii) 
//
//Ex: myButton2.click(clickerFunction);


//AJAX
//h1 nume, h2 inaltime, p an, gender
var myH1 = $("#person-name");
var myH2 = $("#person-height");
var myP = $("#details");

var myButton2 = $("#changer2");
myButton2.click(clickerFunction);

function clickerFunction() {
    $.ajax({
        url: "https://swapi.co/api/people/1/",
        method: "GET",
        success: function (response) {
            myH1.text(response.name);
            myH2.text(response.height);
            myP.text(response.birth_year + ", " + response.gender);
        }
    });
}

