//Cookie
const cookieArr = document.cookie.split("=")
const patientId = cookieArr[1];

function checkLogin(){
    if(!patientId){
        window.location.replace("http://localhost:8080/loginpatient.html");
    }
}


//DOM Elements
const submitForm = document.getElementById("request-form")
const requestContainer = document.getElementById("request-container") // By ID
const timesMenu = document.getElementById("rTime") // By ID



const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/appointments/"

const handleSubmit = async (e) => {
    e.preventDefault()

    console.log("handleSubmit");
    let bodyObj = {
        department: document.getElementById("department").value,
        appcategory: document.getElementById("appcategory").value,
        rdate: document.getElementById("rDate").value,
        rtime: document.getElementById("rTime").value,
        status: "upcoming"
    }

    console.log(bodyObj);
    await addAppointment(bodyObj);

}

async function addAppointment(obj) {
    const doctorId =  document.getElementById("doctor").value;
    const response = await fetch(`${baseUrl}patient/${patientId}/${doctorId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
//        await sendMessageToDoctor();
        window.location.replace("http://localhost:8080/patientappointments.html");
        updateTime();
    }
}

async function updateTime() {
    console.log("updateTime");
    const doctorId = document.getElementById("doctor").value;
    const date = document.getElementById("rDate").value;
    await fetch(`${baseUrl}times/${doctorId}/${date}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => populateTimes(data))
        .catch(err => console.error(err))
}

const populateTimes = (array) => {
    console.log("Started populating times");
    console.log(array);
    let busy = [];
    array.forEach(obj => {
        busy.push(obj.rtime);
    })
    console.log(busy);
    timesMenu.innerHTML = '';
    const times = ["09:00AM", "10:00AM", "11:00AM", "12:00PM", "01:00PM", "02:00PM", "03:00PM", "04:00PM", "05:00PM"];
    times.forEach(obj => {
        console.log(obj);
        if(!busy.includes(obj)) {
            console.log("y");
            timesMenu.insertAdjacentHTML("beforeend", `<option value=${obj}>${obj}</option>`);
//            let time = `<option value=${obj}>${obj}</option>`;
//            timesMenu.append(time);
        }
    })
}







//async function sendMessageToDoctor() {
////    console.log('send message')
//    const turl = "";
//    department = document.getElementById("department").value;
//    appcategory = document.getElementById("appcategory").value;
//    doctor = document.getElementById("doctor").value,
//
//    const response = await axios.post;
//}

async function getAppointments(patientId) {
    console.log("started get appointments");
    await fetch(`${baseUrl}patient/${patientId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createAppointmentCards(data))
        .catch(err => console.error(err))
}

async function handleDelete(appointmentId){
    await fetch(baseUrl + appointmentId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getAppointments(patientId);
}



const createAppointmentCards = (array) => {
    console.log("Started create request cards")
    requestContainer.innerHTML = ''
    array.forEach(obj => {
        if(obj.status=="upcoming") {
            let requestCard = document.createElement("tr")
            requestCard.innerHTML = `
                <tr>
                    <td>
                        <div class="user-info">
                            <div class="user-info__img">
                                <img class="card-img-bottom" src="${obj.doctor.dimage}">
                            </div>
                            <div class="user-info__basic">
                                <h5 class="mb-0">${obj.doctor.firstName} ${obj.doctor.lastName} , MD </h5>
                                <p class="text-muted mb-0">${obj.doctor.dage}</p>
                            </div>
                        </div>
                    </td>
                    <td>
                        <span class="btn btn-success">${obj.appcategory}</span>
                    </td>
                    <td>
                        <h6 class="mb-0">${obj.rtime}</h6>
                        <small>${obj.rdate}</small>
                    </td>
                    <td>
                        <h6 class="mb-0">${obj.doctor.email}</h6>
                        <a href="#!"><small>Contact</small></a>
                    </td>
                    <td>
                        <h6 class="mb-0">${obj.department}</h6>
                    </td>
                    <td>
                        <div class="dropdown open">
                            <a href="#!" class="px-2" id="triggerId1" data-toggle="dropdown" aria-haspopup="true"
                               aria-expanded="false">
                                <i class="fa fa-ellipsis-v"></i>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="triggerId1">
                                <a class="dropdown-item" href="#"><i class="fa fa-pencil mr-1"></i> Edit</a>
                                <a class="dropdown-item text-danger" href="#"><i class="fa fa-trash mr-1"></i> Delete</a>
                            </div>
                        </div>
                    </td>
                </tr>
            `
            requestContainer.append(requestCard)
        }
    })
}

/* Copy
const createAppointmentCards = (array) => {
    console.log("Started create request cards")
    requestContainer.innerHTML = ''
    array.forEach(obj => {
        if(obj.status=="upcoming") {
            let requestCard = document.createElement("div")
            requestCard.classList.add("col")
            requestCard.innerHTML = `
                <div class="card d-flex" style="width: flex; height: 5rem;">
                    <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                        <p class="card-text"><b></b> ${obj.department}</p>
                        <p class="card-text"><b></b> ${obj.appcategory}</p>
                        <p class="card-text"><b>Doctor:</b> ${obj.doctor.firstName} ${obj.doctor.lastName}</p>
                        <p class="card-text"><b>Patient:</b> ${obj.patient.firstName} ${obj.patient.lastName}</p>
                        <p class="card-text"><b>Time:</b> ${obj.rTime}</p>
                        <p class="card-text"><b>Date:</b> ${obj.rDate}</p>
                        <img class="card-img-bottom" src="${obj.description}">
                        <div class="d-flex justify-content-end">
                          <button class="btn btn-delete right" onclick="handleDelete(${obj.id})">Delete</button>
                        </div>
                    </div>
                </div>
            `
            requestContainer.append(requestCard)
        }
    })
}
*/

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}


checkLogin();
document.getElementById('rDate').valueAsDate = new Date();
updateTime()

document.getElementById('rDate').addEventListener("click", updateTime);
document.getElementById('rTime').addEventListener("click", updateTime);
document.getElementById('doctor').addEventListener("click", updateTime);
submitForm.addEventListener("submit", handleSubmit);
getAppointments(patientId);