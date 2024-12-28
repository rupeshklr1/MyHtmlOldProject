
var userCart = []
var selectdProId = []
var userCartAmount = 0;
var userCartTxtAmount = 0;
var prodIdList = findValue(productDetail, 'productId')
function genHtmlCode(userCart, keySet, type) {
    try {        
        let htmlCode = '';
        userCartAmount = 0;
        userCartTxtAmount = 0;
        if (type === 0) {
            for (let i = 0; i < keySet.length; i++) {
                var te = keySet[i];
                if (Object.keys(te).includes('property')) {
                    htmlCode += `<div ${te.property}> ${te.titile}</div>`;
                } else {
                    htmlCode += `<div class='eleField'>${te.titile}</div>`;
                }
            }
        } else if (userCart.length > 0) {
            for (let i = 0; i < userCart.length; i++) {
                var ele = userCart[i];
                userCartAmount += ele.totalPrice;
                userCartTxtAmount += ele.txtCost;
                htmlCode += "<div class='topsec'>";
                for (let j = 0; j < keySet.length; j++) {
                    var te = keySet[j]
                    var siNo = j === 0 ? (i + 1) + ' .' : '';
                    if (Object.keys(te).includes('decimal')) {
                        htmlCode += `<div class='eleField'> ${siNo} ${parseFloat(ele[te.key]).toFixed(2)}</div>`;
                    } else if (Object.keys(te).includes('property')) {
                        htmlCode += `<div ${te.property}>${siNo} ${ele[te.key]}</div>`;
                    } else {
                        htmlCode += `<div class='eleField'>${siNo} ${ele[te.key]}</div>`;
                    }
                }
                htmlCode += "</div>"
            }
        }
        return htmlCode;
    } catch (error) {
        console.log("error occured in function.The error is"+error.message || error);
    }
}

function getSelectItem(prodId, count) {
    try {        
        if (!selectdProId.includes(prodId)) {
            for (let i = 0; i < productDetail.length; i++) {
                if (productDetail[i]['productId'] === prodId) {
                    selectdProId.push(prodId);
                    var item = productDetail[i];
                    item.quCount = parseInt(count);
                    item.txtCost = (item.unitCost / 100) * item.quCount * item.txt;
                    item.totalPrice = (item.unitCost * item.quCount) + item.txtCost;
                    return item
                }
            }
        } else {
            for (let i = 0; i < selectdProId.length; i++) {
                if (selectdProId[i] === prodId) {
                    userCart[i].quCount += parseInt(count);
                    userCart[i].txtCost = (userCart[i].unitCost / 100) * userCart[i].quCount * userCart[i].txt;
                    userCart[i].totalPrice = (userCart[i].unitCost * userCart[i].quCount) + userCart[i].txtCost;
                }
            }
        }
        return null
    } catch (error) {
        console.log("error occured in function.The error is"+error.message || error);
    }
}

function addCartItem() {
    try {        
        var prodId = (document.getElementById("prodId").value).toLowerCase();
        var quCount = document.getElementById("quCount").value;
        if(quCount === '' ||  parseInt(quCount) <=0 ){
            alert("Enter corect details.")
            return;
        }
        if (prodIdList.includes(prodId) && (selectdProId.length < maxItemCart || selectdProId.includes(prodId))) {
            var newItem = getSelectItem(prodId, quCount)
            if (newItem)
                userCart.push(newItem)
            var Htmcode = genHtmlCode(userCart, itemDisplay.tableFormat.body, 1);
            document.getElementById("toatalval1").style.display = 'block';
            document.getElementById("TAID").innerHTML = userCartAmount.toFixed(2);
            document.getElementById("txtAmtID").innerHTML = userCartTxtAmount.toFixed(2);
            document.getElementById("bodySec").innerHTML = Htmcode;
            document.getElementById("toatalval").innerHTML = `Total txt amount : ${userCartTxtAmount.toFixed(2)}        Total Amount :${userCartAmount.toFixed(2)}`;
        } else {
            if (selectdProId.length < maxItemCart - 1)
                alert("Entered product no is not available in our store.")
            else
                alert("Maximum item can allowed " + maxItemCart + ".")
        }
    } catch (error) {
        console.log("error occured in function.The error is"+error.message || error);
    }
}

function billCart() {
    try {        
        if (selectdProId.length > 0) {
            var dt = new Date();
            var id = window.open("", "", "top=100,left=350,height=auto,width=700")
            id.document.open();
            id.document.write("<html><head><title>Acme grocers</title>")
            id.document.write(billStyles);
            id.document.write("</head><body><center><h1><u>Acme grocers</u></h1></center><div class='flaotRight'><div >Date:" + dt.toLocaleDateString() + "</div><div>Bill No:-" + Math.floor(Math.random() * Math.pow(10, billSize)) + "</div></div>")
            id.document.write(`<div class="topsec und" id="topSec1">${genHtmlCode([], itemDisplay.billFormat.header, 0)}</div>`);
            id.document.write(genHtmlCode(userCart, itemDisplay.billFormat.body, 1))
            id.document.write("<h6>Total txt amount :" + Math.ceil(userCartTxtAmount) + "/-<br>Payable Amount :   " + Math.ceil(userCartAmount) + "/-<br>Payable Amount in word :(" + numToWord(Math.ceil(userCartAmount)).toUpperCase() + " only)</h6>")
            id.document.write("</body></html>")
        } else {
            alert("Add atleast one item to bill.")
        }
        // clearcart()
    } catch (error) {
        console.log("error occured in function.The error is"+error.message || error);
    }
}

function clearcart() {
    try {
        userCart = []
        selectdProId = []
        userCartAmount = 0;
        userCartTxtAmount = 0;
        document.getElementById("TAID").innerHTML = 0.0;
        document.getElementById("txtAmtID").innerHTML = 0.0;
        document.getElementById("bodySec").innerHTML = '<center>No Product Add till now.</center>';
        document.getElementById("toatalval").innerHTML = '';   
        document.getElementById("prodId").value ="";
        document.getElementById("quCount").value =""   
    } catch (error) {
        console.log("error occured in function.The error is"+error.message || error);
    }
}

function logoutFun() {
    try {        
        clearcart();
        sessionStorage.clear()
        location.href = pageName.homepage;
    } catch (error) {
        console.log("error occured in function.The error is"+error.message || error);
    }
}

function init() {
    try {
        if (sessionStorage.getItem(loginItem.keyItem) === loginItem.valueItem) {
            // var topsec = document.getElementById("topSec1");
            document.getElementById("userField").innerHTML = sessionStorage.getItem(loginItem.userNameKey).toLocaleUpperCase();
            var topsec = document.getElementById("welcomeNote");
            console.log(topsec);
            topsec.innerHTML = "Hi "+sessionStorage.getItem(loginItem.userNameKey) +"."+ topsec.innerHTML;
            document.getElementById("topSec1").innerHTML = genHtmlCode([], itemDisplay.tableFormat.header, 0)
        } else {
            alert("Session is expried.Please login again to scuess the services.")
            location.href = pageName.homepage;
        }        
    } catch (error) {
        console.log("error occured in function.The error is"+error.message || error);
    }
}
