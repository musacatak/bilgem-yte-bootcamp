const arr = ["a","b","c"];

const h2 = document.querySelector("#header1");

const oldValue = h2.innerHTML;
console.log("Old Value : " + h2.innerHTML);

let str = ""
arr.forEach((element) => {
    str+=element;
});
h2.innerHTML = str;

console.log("New Value : " + h2.innerHTML);


// Change button text on click

const btn = document.getElementById('btn');
btn.addEventListener('click', function handleClick() {

    if(btn.textContent === str){
        btn.textContent = oldValue;
        h2.innerHTML = oldValue;
    }
    else {
        btn.textContent = str;
        h2.innerHTML = str;

    }
});
