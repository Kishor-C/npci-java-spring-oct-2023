// creating a function in JS
let counter = 0;
function increment() {
    counter++;
    //accessing an element having an id : first
    let ele = document.getElementById('first');
    ele.innerHTML = 'Counter: '+counter;
}
// callback functions
let array = [8, 9, 1, 5, 6];
// x is an item that is iterated, y is the index of the iterated item
array.forEach(function(x, y) { 
    console.log('x = '+x+', y = '+y);
})
console.log("______________________________")
// arrow functions - replacement to the callback function
array.forEach((x, y) => console.log('x = '+x+', y = '+y));
// map(): It is also similar to forEach but it returns a new array
let items = array.map((x, y) => x * y); // returns x * y;
// items will be [0, 9, 2, 15, 24]
console.log(items);
items = ['Mobile', 'Laptop', 'Camera', 'Tablet'];
// creating multiple HTML elements using map
let list = items.map((x, y) => '<li>'+x+'</li>');
let ele = document.getElementById('first');
ele.innerHTML = '<ol>'+list+'</ol>';