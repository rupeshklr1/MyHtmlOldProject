var jsonLocal=[],siz=0,editcliked=false,editindex=null;
function dataprint() {
    try{
    jsonLocal=JSON.parse(localStorage.getItem("userData")),siz=0;
    // console.log(jsonLocal);
    if(jsonLocal===null || jsonLocal=="" || jsonLocal==[]){
        console.log("Nodata");
        $("table tbody").html("<tr class='text-center'><th colspan='9'>No Records Found</th></tr>");
        return []; 
    }else{
        var markup="";
            for(i of jsonLocal){
                markup+=`<tr scope="row"><td>`+ (siz+1) +"</td>"
                for(j in i){
                    markup+="<td>"+i[j]+"</td>";
                }// <button type="button" id="`+ --siz +`" class="editbtn"  onclick="editbtn(`+ --siz +`)"><i class="fa-sharp fa-solid fa-pen"></i></button>         
                markup+=`    <td>
                               <!-- --> 
                               <button type="button" id="`+ siz +`" class="editbtn"  ><i class="fa-sharp fa-solid fa-pen"></i></button>
                                <button type="button" id="`+ siz++ +`" class="removeBtnClass"><i class="fa-solid fa-trash"></i></button>
                            </td>
                        </tr>`;
            }
        $("table tbody").html(markup);
        return jsonLocal;
    }
} catch (error_info) {
    console.log(error_info);
}
}
$(document).ready(function () {
    var jsonLocal=dataprint();
	var fullform =`       
    <div class="row">
        <form class="border border-2 border-black p-3 mt-5 mx-auto col-auto" style="width: 400px;" id="myForm">
            <fieldset>
            <h4 class="text-center text-secondary ">USER FORM</h4>
                <label for="name">Name<span class="warn" id="errname"><b>&nbsp;*</b> </span></label>
                <input class="form-control" type="text" name="name" id="name" placeholder="enter name"><br>
                <label for="email">E-mail<span class="warn" id="erremail"><b>&nbsp;*</b> </span></label>
                <input class="form-control" type="email" name="email" id="email" placeholder="enter email id"><br>
                <label for="password">Password<span class="warn" id="errpass"><b>&nbsp;*</b> </span></label>
                <input class="form-control" type="password" name="password" id="password"
                    placeholder="password"><br>
                <label for="confirmpassword">Confirm<span class="warn" id="err_CP"><b>&nbsp;*</b></span></label>
                <input class="form-control" type="password" name="confirmpassword" id="confirmpassword"
                    placeholder="confirmpassword"><br>
                <label for="age">Age<span class="warn" id="errage"><b>&nbsp;*</b> </span></label>
                <input class="form-control" type="number" name="age" id="age" min="10" max="100"><br>
                <div class="row m-1">
                    <label for="address" class="col-10 align-self-center">Address<span class="warn"
                            id="erradd"><b>&nbsp;*</b> </span></label>
                    <textarea class="form-control" name="address" id="address" cols="15" rows="2"
                        placeholder="Address"></textarea>
                </div>
                <div class="">
                    <label class="label-name">Qualificatuion :<span class="warn" id="erredu"><b>&nbsp;*</b> </span></label><br />
                    <select id="edu" data-placeholder="Choose a role..."
                        class="chosen-select role form-control point-filed" tabindex="2">
                        <option class="point-filed" id="setEdu" value="" selected>Choose your degree..
                        </option>
                        <option class="point-filed" value="BTech">B Tech</option>
                        <option class="point-filed" value="BSc">B Sc</option>
                        <option class="point-filed" value="MTech">M Tech</option>
                        <option class="point-filed" value="MSc">M Sc</option>
                    </select>
                </div>
                <div class="radioclass py-3">
                    <p class="m-0">Select anyone language you like more.</p>
                    <input class="radiobtn point-filed" type="checkbox" id="Python" name="fav_language" value="Pyton">
                    <label for="Python">Python</label><br>
                    <input class="radiobtn point-filed" type="checkbox" id="Java" name="fav_language" value="Java">
                    <label for="Java">Java</label><br>
                    <input class="radiobtn point-filed" type="checkbox" id="javascript" name="fav_language"
                        value="JavaScript">
                    <label for="javascript">JavaScript</label>
                </div>
                
                <input type="checkbox" name="agreed" id="agreed"><label for="agreed"><span class="warn"
                        id="erragreed"><b>&nbsp;*</b></span> I agree for term & conditions.</label><br>
                <div class="row justify-content-around">
                    <input class="btn btn-danger py-0 my-2 rounded-0" type="button" value="submit" id="submitbtn">
                    <input class="btn btn-danger py-0 my-2" type="reset" id="resetbtn" value="Reset">
                </div>
            </fieldset>
        </form>
    </div>
    `;

	$("#form_tab").html(fullform);
	$(".removeBtnClass").click(function () {
        try{
        var val=$(this).attr('id'); 
        console.log(val);
        if(confirm("Do you want to delete this record\n with user name : "+jsonLocal[val].name)==true){
            jsonLocal.splice(val, 1);
            localStorage.setItem("userData",JSON.stringify(jsonLocal));
            dataprint();
        }else
            console.log("Okay the record is not deleted!");
        } catch (error_info) {
            console.log(error_info);
        }
        
    });
	$(".editbtn").click(function () {
        try{
        var val=$(this).attr('id'); 
        editcliked=true;
        editindex=val;
        console.log("clicked edit.."+val);
        $("#submitbtn").val("Update");
        // $("#resetbtn").val("Continue");
        $("#myForm").trigger('reset');
        $(".warn").html("<b>&nbsp;*</b>");
        if(!Array.isArray(jsonLocal[val].fav_lan)){
            var templi=[];
            if(jsonLocal[val].fav_lan=="None" || jsonLocal[val].fav_lan==[] || jsonLocal[val].fav_lan==null || jsonLocal[val].fav_lan=="")
                templi=["","",""];
            else
                templi=jsonLocal[val].fav_lan.split(" , ");
            while(templi.length<3){
                templi.push('')
            }
            jsonLocal[val].fav_lan=templi;
        }
        function filldata(ele){
            try{
            $("#name").val(ele.name);
            $("#email").val(ele.email);
            $("#password").val(ele.pass);
            $("#confirmpassword").val(ele.pass);
            $("#age").val(ele.age);
            $("#address").val(ele.address);
            $("#edu").val(ele.edu);
            fav_Li=ele.fav_lan;
            for(i of $("input[name='fav_language']")){
                if(i.value===fav_Li[0] || i.value===fav_Li[1] ||i.value===fav_Li[2])
                {
                    $(i).prop("checked", true);
                }
            }
            $("#agreed").prop("checked", true);
        } catch (error_info) {
            console.log(error_info+'Error from filldata function');
        }
        }
        filldata(jsonLocal[val]);
    } catch (error_info) {
        console.log(error_info);
    }

    });
	$("#resetbtn").click(function () {
        try{
        $(".warn").html("<b>&nbsp;*</b>");
        $("#myForm").trigger('reset');
        editcliked=false,editindex=null;
    } catch (error_info) {
        console.log(error_info);
    }
     });  
	$("#submitbtn").click(function () {   
        // temp object to store data
        try{
        var tempData = {
            name: "",
            email: "",
            pass: "",
            age: 0,
            address: "",
            edu:"",
            fav_lan: ""},flage =true,favLi=[];
		if($("#name").val().trim()===""){
			flage =false;
            $("#errname").html("<b>&nbsp;*</b><a>Name is requied<a>");
            $("#name").blur(function(){
                if($("#name").val().trim() === ""){
                    $("#errname").html("<b>&nbsp;*</b><a>Name is requied<a>");
                }else if($("#name").val().trim().length<5){
                    $("#errname").html("<b>&nbsp;*</b><a>Name length must be 5.<a>");
                }else{
                    $("#errname").html("");
                }
            });
        }else if($("#name").val().trim().length<5){
            $("#errname").html("<b>&nbsp;*</b><a>Name length must be 5.<a>");
            flage =false;
        }else{
            // console.log($("#name").val());
			(tempData.name = $("#name").val());
        }
		if($("#email").val() === ""){
            $("#erremail").html("<b>&nbsp;*</b>Email is requied");
			flage =false;
            $("#email").blur(function(){
                if($("#email").val() === ""){
                    $("#erremail").html("<b>&nbsp;*</b>Email is requied");
                }else{
                    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                    if($("#email").val().match(mailformat)){
                        $("#erremail").html("");
                    }else{
                    $("#erremail").html("<b>&nbsp;*</b>Invalid email id is requied")
                    }
                }
            });
        }else{
            var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            if($("#email").val().match(mailformat)){
                tempData.email = $("#email").val();
                $("#erremail").html("");
            }else{
                flage =false;
                $("#erremail").html("<b>&nbsp;*</b>Invalid email id is requied");
                $("#email").blur(function(){
                    if($("#email").val() === ""){
                        $("#erremail").html("<b>&nbsp;*</b>Email is requied");
                    }else{
                        var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                        if($("#email").val().match(mailformat)){
                            $("#erremail").html("");
                        }else{
                        $("#erremail").html("<b>&nbsp;*</b>Invalid email id is requied");
                        }
                    }
                });
            }
        }
		if($("#password").val().trim() === "" ){
			flage =false;
            $("#errpass").html("<b>&nbsp;*</b>Password feild is requied");
            $("#password").blur(function(){
                if($("#password").val().trim() === ""){
                    $("#errpass").html("<b>&nbsp;*</b>Password feild is requied");
                }else if( $("#password").val().trim().length<8){
                    $("#errpass").html("<b>&nbsp;*</b>Password length must be 8 letters.");
                }else{
                    $("#errpass").html("");
                }
            });
        }else if( $("#password").val().trim().length<8){
            flage=false;
            $("#errpass").html("<b>&nbsp;*</b>Password length must be 8 letters.");
        }else {
			(tempData.pass = $("#password").val());
        }
		if($("#confirmpassword").val().trim() === "" ){
			flage =false;
            $("#err_CP").html("<b>&nbsp;*</b>confirm Password is requried to check");
            $("#confirmpassword").blur(function(){
                if($("#confirmpassword").val().trim() ===""){
                    $("#err_CP").html("<b>&nbsp;*</b>confirm Password is requried to check");
                }else if( $("#password").val().trim() !== $("#password").val().trim()){
                    $("#err_CP").html("<b>&nbsp;*</b>confirm password not matched.");
                }else{
                    $("#err_CP").html("<b>&nbsp;*</b>");
                }
            });
        }else if( $("#confirmpassword").val().trim()!== $("#password").val().trim()){
            flage=false;
            $("#confirmpassword").blur(function(){
                if($("#confirmpassword").val().trim() ===""){
                    $("#err_CP").html("<b>&nbsp;*</b>confirm Password is requried to check");
                }else if( $("#password").val().trim() !== $("#password").val().trim()){
                    $("#err_CP").html("<b>&nbsp;*</b>confirm password not matched.");
                }else{
                    $("#err_CP").html("<b>&nbsp;*</b>");
                }
            });
            $("#err_CP").html("<b>&nbsp;*</b>confirm password not matched.");
        }else{
            $("#err_CP").html("<b>&nbsp;*</b>");
        }
		if($("#age").val() === "" ){
			flage =false;
            $("#errage").html("<b>&nbsp;*</b>Age must be number & requied");
            $("#age").blur(function(){
                if($("#age").val() === ""){
                    $("#errage").html("<b>&nbsp;*</b>Age must be number & requied");
                    flage =false;
                }else if(parseInt($("#age").val())<10 || parseInt($("#age").val())>100){
                    $("#errage").html("<b>&nbsp;*</b>Age must in b/n 10 to 100");
                } else{
                    $("#errage").html("");
                }
            });
        }else if(parseInt($("#age").val())<10 || parseInt($("#age").val())>100){
            $("#errage").html("<b>&nbsp;*</b>Age must in b/n 10 to 100");
            flage=false;
        } else{
			tempData.age = parseInt($("#age").val()); 
        }
		if($("#address").val().trim() === ""){
			flage =false;
            $("#erradd").html("<b>&nbsp;*</b>Address is requied");
            $("#address").blur(function(){
                if($("#address").val().trim() === "" && $("#address").val().trim().length>10){
                    $("#erradd").html("<b>&nbsp;*</b>Address is requied");
                }else if($("#address").val().trim().length<10){
                    $("#erradd").html("<b>&nbsp;*</b>Address must be 10 letters.");
                }else{
                    $("#erradd").html("");
                }
            });
        }else if($("#address").val().trim().length<10){
			flage =false;
            $("#erradd").html("<b>&nbsp;*</b>Address must be 10 letters.");
        }else{
            tempData.address = $("#address").val();
        }
        if($("#edu").val() === ""){
        	flage =false;
            $("#erredu").html("<b>&nbsp;*</b><a>Please select your qualification <a>");
            $("#edu").blur(function(){
                if($("#edu").val() === ""){
                    $("#erredu").html("<b>&nbsp;*</b><a>Please select your qualification <a>");
                }else{
                    $("#erredu").html("");
                }
            });
        }else{
            tempData.edu=$("#edu").val();
        }
        for(i of $("input[name='fav_language']")){
            if(i.checked){favLi.push(i.value);}
        }
        if(favLi.length===0){
            tempData.fav_lan="None"
        }else{
            tempData.fav_lan=favLi.join(" , ");
        }
		if(!$("#agreed").is(":checked")){
			flage =false;
            $("#erragreed").html("<b>&nbsp;*</b>Requied");
            $("#agreed").blur(function(){
                if(!$("#agreed").is(":checked")){
                    $("#erragreed").html("<b>&nbsp;*</b>Requied");
                }else{
                    $("#erragreed").html("");
                }
            });
        }
        if(flage){
            console.log("valied data & storing!.");
            if(editcliked){
                jsonLocal.splice(editindex,1,tempData);
            }else{
                jsonLocal.push(tempData);
            }
            localStorage.setItem("userData",JSON.stringify(jsonLocal));
            dataprint();
            $(".warn").html("<b>&nbsp;*</b>");
            $("#myForm").trigger('reset');
            $("#submitbtn").val("submit");
            editcliked=false,editindex=null;
            location.reload();
        }
    } catch (error_info) {
        console.log(error_info+'Error from submitbtn function');
    }
	});
});