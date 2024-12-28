$(document).ready(function(){
    var fullform=`
    
    
    <div class="row">
    <form class="border border-2 border-black p-3 mt-5 mx-auto col-auto">
        <label for="name">Name</label>
        <input type="text" name="name" id="name" placeholder="enter name"><br>
        <label for="email" class="py-3">E-mail</label>
        <input type="email" name="email" id="email"  placeholder="enter email id"><br>
        <label for="password" class="py-3">Password</label>
        <input type="password" name="password" id="password"  placeholder="password"><br>
        <label for="age" >Age</label>
        <input class="mb-3" type="number" name="age" id="age" min="10" max="100"><br>
        <div class="row">
            <label for="address" class="col-4 align-self-center">Address</label>
            <textarea class="col-8" name="address" id="address" cols="15" rows="2" placeholder="Address"></textarea>
        </div>
        <div class="radioclass py-3">
            <p class="m-0">Select which language you like .</p>
            <input class="radiobtn" type="radio" id="html" name="fav_language" value="HTML">
            <label for="html">HTML</label><br>
            <input class="radiobtn" type="radio" id="css" name="fav_language" value="CSS">
            <label for="css">CSS</label><br>
            <input class="radiobtn" type="radio" id="javascript" name="fav_language" value="JavaScript">
            <label for="javascript">JavaScript</label>
        </div>
        <input type="checkbox" name="agreed" id="agreed"><label for="agreed"> I agree for term & conditions.</label><br>
        <div class="row justify-content-around">
        <input class="btn btn-danger py-0 my-2" type="button" value="submit" id="submitbtn" >
        <input class="btn btn-danger py-0 my-2" type="button" id="resetbtn" value="Reset">
        </div>
    </form>
</div>

`;
    var checked="";
    $("#form_tab").html(fullform);
    $(".radiobtn").click(function(){
        checked=$(this)[0].value;
    })
    $("#submitbtn").click(function(){       
        var tempobj={
            "Name":"",
            "email":"",
            "pass":"",
            "age":0,
            "address":"",
            "fav_lan":"",
            "isagreed":false
        } 
        var warmaessage="", values="";
        var x1=$("input[name='fav_language']");
        ($("#name").val()==="")? warmaessage="Name not entered":tempobj.Name=$("#name").val();        
        ($("#email").val()==="")?warmaessage+="Email not entered":tempobj.email=$("#email").val();
        ($("#password").val()==="")?warmaessage+="password not entered":tempobj.pass=$("#password").val();
        ($("#age").val()==="")?warmaessage+="Age not entered":tempobj.age=$("#age").val();
        x1.is(':checked')?tempobj.fav_lan=checked:warmaessage="Favorite language is not selected";
        values+="<br>selected language "+checked;
        (!$("#agreed").is(':checked'))?warmaessage="your not agreed":tempobj.isagreed=true;
        console.log(tempobj);
        values+="Name "+$("#name").val();
        values+="<br>email "+$("#email").val();
        values+="<br>password "+$("#password").val();
        values+="<br>age "+$("#age").val();
        values+="<br>selected language "+checked;
        values+="<br>agreed "+$("#agreed").is(':checked');
        console.log(",<br>"+x1.is(':checked'));
        console.log(values);
    });
    // $("#name").
});
    // $('input[type="radio"][name="name"]:checked').val();