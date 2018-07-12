//login button listener
var lgn = document.getElementById('lgn');
lgn.addEventListener("click",login)

var tstr = "";

function login(event)
{
	event.preventDefault();
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
    	if(xhr.readyState == 4 && xhr.status == 200)
    	{
    		console.log('successful');
    		tstr = xhr.responseText;
    		console.log("hey: " +xhr.response.responseText);
    		
    		if(tstr == "Invalid credentials")
    		{
    			alert(tstr);
    		}
    		else
    		{
    			let data = JSON.parse(tstr);
    			document.cookie = "employeeId=" + data.employeeId;
    			window.location.replace("http://localhost:11030/trms-webapp/Menu.html");
    		}
    		
        }
    	else
        {
           console.log('failed');
        }
    }
    
    xhr.open("POST","test",true);
    xhr.send(JSON.stringify(loginCredentials()));
    
    
}

//register link listener
var register = document.getElementById('reg');
register.addEventListener("click",registerForm)

function registerForm()
{
    let rform = document.getElementsByClassName("register-form");
    let lform = document.getElementsByClassName("login-form");
    
    if(rform[0].style.display !== "none")
    {
        lform[0].style.display = "none";
        rform[0].style.display = "block";
    }
    else if(rform[0].style.display == "none")
    {
        lform[0].style.display = "none";
        rform[0].style.display = "block";
    }
}


//login link listener
var loginLink = document.getElementById('lg');
loginLink.addEventListener("click",loginForm)

function loginForm()
{
    let rform = document.getElementsByClassName("register-form");
    let lform = document.getElementsByClassName("login-form");

    
    if(lform[0].style.display == "none")
    {
        lform[0].style.display = "block";
        rform[0].style.display = "none";
    }
}


//Create account button listener
var createBtn = document.getElementById('create-button');
createBtn.addEventListener("click",create)

function create()
{
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
    	if(xhr.readyState == 4 && xhr.status == 200)
    	{
    		console.log('successful');
        } else
        {
           console.log('failed');
        }
    }
    
    xhr.open("POST","createAccount",true);
    xhr.send(JSON.stringify(accountJSON()));
}

//JSON of the information on the create account form
function accountJSON()
{
    fm = document.querySelectorAll("form")[0];
    let d = fm.getElementsByTagName('input');
    let str = String(d[7].value);
    return{
    	"employeeId" : "",
        "firstname" : d[0].value,
        "lastname" : d[1].value,
        "email" : d[2].value,
        "password" : d[3].value,
        "phoneNumber" : d[4].value,
        "dob" : d[5].value,
        "address" : d[6].value,
        "position" : str,
        "supervisor" : d[8].value,
        "department" : d[9].value,
        "departmentHead" : d[10].value,
        "balance" : 1000
        
    }
}

function loginCredentials()
{	
	let cred = {};
	cred.email = document.getElementById("loginEmail").value;
	cred.password = document.getElementById("loginPwd").value;
	return cred;
	console.log(cred);
}