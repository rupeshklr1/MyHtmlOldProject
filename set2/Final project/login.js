var userName = findValue(userDetails,'empName')
var userPass = findValue(userDetails,'empPass')
function login(){
    try {        
        var empName = document.getElementById("empName").value ;
        var empPass = document.getElementById("empPass").value ;
        console.log(empName,empPass);
        console.log(userName);
        console.log(userName.includes(empName));
        console.log(userPass.includes(empPass));
        if(userName.includes(empName) && userPass.includes(empPass)){
            clearBTn()
            sessionStorage.setItem(loginItem.keyItem,loginItem.valueItem);
            sessionStorage.setItem(loginItem.userNameKey, empName );
            location.href = pageName.entrypage;
        }else{
            alert("Invalide user details.\nPlesae enter correct details.")
        }
    } catch (error) {
        console.log("error occured in function.The error is"+error.message || error);
    }
}
function clearBTn(){   
    try {
        document.getElementById("empPass").value = '';
        document.getElementById("empName").value = '';
    } catch (error) {
        console.log("error occured in function.The error is"+error.message || error);
    } 
}
function init(){
    if(sessionStorage.getItem(loginItem.userNameKey)){
        location.href = pageName.entrypage;
    }
}