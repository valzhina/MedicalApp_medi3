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
            let requestCard = document.createElement("div")
            requestCard.classList.add("col")
            requestCard.innerHTML = `
                <div class="card d-flex" style="width: flex; height: 5rem;">
                    <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                        <p class="card-text"><b></b> ${obj.department}</p>
                        <p class="card-text"><b></b> ${obj.appcategory}</p>
                        <p class="card-text"><b>Doctor:</b> ${obj.doctor.firstName} ${obj.doctor.lastName}</p>
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

getAppointments(doctorId)