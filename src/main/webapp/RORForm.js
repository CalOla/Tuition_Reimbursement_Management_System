//var req =new XMLHttpRequest();
//req.open('GET','https://learnwebcode.github.io/json-example/animals-1.json');
//req.onload = function(){
//  var data = JSON.parse(req.responseText);
//    console.log(data)
//};
//req.send();
function getEmployee()
{
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
			
			if(xhr.readyState == 4 && xhr.status == 200){
				
				let emp = JSON.parse(xhr.responseText);
				
				console.log(emp);
				
				
				document.getElementById("event-type").value = emp.firstname;
				
			}
		}
		xhr.open("GET", "readOnlyForm" + name, true);
		xhr.send(); 
}

