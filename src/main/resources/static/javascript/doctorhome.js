//Cookie
const cookieArr = document.cookie.split("=")
const doctorId = cookieArr[1];

const requestContainer = document.getElementById("request-container") // By ID

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/appointments/"


async function getAppointments(doctorId) {
    console.log("started get appointments")
    await fetch(`${baseUrl}doctor/${doctorId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createAppointmentCards(data))
        .catch(err => console.error(err))
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
                                <img src="img/user1." alt="User Img">
                            </div>
                            <div class="user-info__basic">
                                <h5 class="mb-0">${obj.patient.firstName} ${obj.patient.lastName} , MD </h5>
                                <p class="text-muted mb-0">34 yrs, Male</p>
                            </div>
                        </div>
                    </td>
                    <td>
                        <span class="btn btn-success">${obj.appcategory}</span>
                    </td>
                    <td>
                        <h6 class="mb-0">${obj.rTime}</h6>
                        <small>${obj.rDate}</small>
                    </td>
                    <td>
                        <h6 class="mb-0">${obj.patient.phone}</h6>
                        <a href="#!"><small>Contact</small></a>
                    </td>
                    <td>
                        <h6 class="mb-0">${obj.patient.birthDate}</h6>
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

//const createAppointmentCards = (array) => {
//    console.log("Started create request cards")
//    requestContainer.innerHTML = ''
//    array.forEach(obj => {
//        if(obj.status=="upcoming") {
//            let requestCard = document.createElement("div")
//            requestCard.classList.add("col")
//            requestCard.innerHTML = `
//                <div class="card d-flex" style="width: flex; height: 5rem;">
//                    <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
//                        <p class="card-text"><b></b> ${obj.department}</p>
//                        <p class="card-text"><b></b> ${obj.appcategory}</p>
//                        <p class="card-text"><b>Doctor:</b> ${obj.doctor.firstName} ${obj.doctor.lastName}</p>
//                        <p class="card-text"><b>Time:</b> ${obj.rTime}</p>
//                        <p class="card-text"><b>Date:</b> ${obj.rDate}</p>
//                        <img class="card-img-bottom" src="${obj.description}">
//                        <div class="d-flex justify-content-end">
//                          <button class="btn btn-delete right" onclick="handleDelete(${obj.id})">Delete</button>
//                        </div>
//                    </div>
//                </div>
//            `
//            requestContainer.append(requestCard)
//        }
//    })
//}

getAppointments(doctorId)