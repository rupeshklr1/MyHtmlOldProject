$(document).ready(function(){
    var de=$("#fulldetails h1").text();
    $("#fulldetails h1").text(de+" edited");
    var out="";
    for(var i=0;i<10;i++){
        out+='<p id="para'+(i+1)+'">Name '+i+'</p>';
    }
    $("#fulldetails div").html(out);
    $(".styling").css({ "background-color": "gray","margin": "30px", "border": "25px solid #ff0000","width":"200px","padding":"10px"});
    $("#fulldetails").addClass('border border-2 border-danger p-3 col-6 text-center mb-4 m-2 ');
    $("#fulldetails div").removeClass("partcontain");
    $("#fulldetails div").addClass("text-start mt-2 ps-3 fw-bold");
    $("p").click(function(){$(this).css("background-color","#ff0000")});
    $("p").dblclick(function(){$(this).hide()});
    console.log($("p").html());
    $("#para4").css("color","yellow");
    


});