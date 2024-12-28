$(document).ready(function(){
    $("#button1").click(function(){
        $("#moredata").toggle();
        $("#helptext").toggle();
        $("#ref").toggle();
    });
    $("#button2").click(function(){
        var flag=true;
        var t=$("#symbol").val();
            var v1=$("#data1").val();
            var v2=$("#data2").val();
        
        if(v1=="" || v2==""){
            flag=false;
        }else{
            var a=parseInt($("#data1").val());
            var b=parseInt($("#data2"). val());
            var sum=0;
            console.log(t);
            switch (t) {
                case "+":
                    sum=a+b;
                    break;            
                case "-":
                    sum=a-b;
                    break;
                case "*":
                    sum=a*b;
                    break;
                case "/":
                    if(b>0)
                        sum=a/b;
                    else
                        flag=false;
                    break;
                default:
                    flag=false;
                    break;
            }
        }
        if(flag)
            $("#result").text("Result is "+sum);
        else
            $("#result").text("This opration are incorrect!");
    });

    var arr = ["1","2","3","4"];
    arr.slice( 2, -1);
    console.log(arr);
});
                                                                       