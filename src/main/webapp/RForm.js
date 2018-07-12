//JSON file for the reimbursement form information
function accountJSON()
{
    fm = document.querySelector("form");
    let d = fm.getElementsByTagName('input');
    let text_area = fm.getElementsByTagName('textarea');
    return{
        "eventType" : d[0].value,
        "eventLocation" : d[1].value,
        "cost" : d[2].value,
        "gradingFormat" : d[3].value,
        "startTime" : d[4].value,
        "endTime" : d[5].value,
        "startDate" : d[6].value,
        "endDate" : d[7].value,
        "missedDays" : d[8].value,
        "description" : text_area[0].value,
        "justification" : text_area[1].value,
        "estimatedCost" : 0.0,
        "hAppr" : "false",
        "sAppr" : "false",
        "bAppr" : "false"
    }
}


//Read in attachments for event related 
//var erFileList = [];
//var erfileIn = document.getElementById('event-related-files');
//    
//erfileIn.addEventListener('change', function(evnt)
//{
//erFileList = [];
//for(let i = 0; i < erfileIn.files.length; i++)
//{
//    console.log(i);
//    erFileList.push(erfileIn.files[i]);
//}
//});


//Read in attachments for event related 
//var apFileList = [];
//var apFileIn = document.getElementById('approval-files');
//    
//apFileIn.addEventListener('change', function(evnt)
//{
//apFileList = [];
//for(let i = 0; i < apFileIn.files.length; i++)
//{
//    console.log(i);
//    apFileList.push(apFileIn.files[i]);
//}
//});


var submitForm = document.getElementById('submit-form');
submitForm.addEventListener('click', sendForm);
    
//        evnt.preventDefault();
//        erFileList.forEach(function (file)
//        {
//            console.log(file)
//            //to do: send file
//        });
//        
//        apFileList.forEach(function (file)
//        {
//            console.log(file)
//            //to do: send file
//        });
    
//        submitForm.submit;

function sendForm()
{
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function()
        {
        	if(xhr.readyState == 4 && xhr.status == 200)
        	{
        		console.log('successful');
            } 
        	else
            {
               console.log('failed');
            }
        }
        
        xhr.open("POST","reimbursementForm",true);
        xhr.send(JSON.stringify(accountJSON()));
    }