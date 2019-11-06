var y = "ceva";
var x = 346;

console.log(x);

var myObject = {
    boch_8: ["Andrei", "Gabriel", "Cosmin"],
    buch_9: ["Lori", "Sandokan", "Piratul", "IncaUnu"]
}

console.log(myObject.boch_8.length);
console.log(myObject.buch_9);
console.log(myObject);

var lungimeBuch8 = myObject.boch_8.length;
var lungimeBuch9 = myObject.buch_9.length;
var foo = lungimeBuch8 + lungimeBuch9;
console.log(foo);

function add(a, b) {
    return a + b;
}
console.log(add(lungimeBuch9, lungimeBuch8));

