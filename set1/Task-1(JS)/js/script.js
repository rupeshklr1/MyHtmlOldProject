document.getElementById("button1").addEventListener("click", fun1);
document.getElementById("button2").addEventListener("click", fun2);
let data = document.getElementById("moredata");
let ref = document.getElementById("helptext");
let data1 = document.querySelector("#data1");
let data2 = document.querySelector("#data2");
let value1 = 0,
	value2 = 0;
data1.addEventListener("input", function () {
	value1 = data1.valueAsNumber;
});
data2.addEventListener("input", function () {
	value2 = data2.valueAsNumber;
    console.log(value2);
    if(isNaN(value2)){
        console.log("111111111");
    }else{
        console.log("333333333333");
    }
});
function fun1() {
	if (data.style.display === "block") {
		ref.innerHTML = "To know more about us!.";
		data.style.display = "none";
	} else {
		ref.innerHTML = "Click here to hide this data.";
		data.style.display = "block";
	}
}
function fun2() {
	var sum = value1 + value2;
	console.log("clicked! And sum is " + sum);
}
