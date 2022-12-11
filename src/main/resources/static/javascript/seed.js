async function handleSeed() {

    const headers = {
        'Content-Type':'application/json'
    }

//Doctor 1 Log in
    let bodyObj = {
        firstName: "Elizabeth",
        lastName: "Genovese",
        doctor_id: "MD-395",
        email: "egenovese@gmail.com",
        password: "11111111",
        dimage: "./img/user1.jpg",
        dage:"29 yrs, Female"
    }

    await fetch('http://localhost:8080/api/v1/doctors/register', {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message))

//Doctor 2 Log in
    bodyObj = {
        firstName: "Thomas",
        lastName: "Goldberg",
        doctor_id: "tgoldberg@gmail.com",
        email: "OM-165",
        password: "22222222",
        dimage: "./img/user1.jpg",
        dage:"42 yrs, Male"
    }

    await fetch('http://localhost:8080/api/v1/doctors/register', {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message))

//Doctor 3 Log in
     bodyObj = {
        firstName: "Julie",
        lastName: "Wimbley",
        doctor_id: "MC-632",
        email: "jwimbley@gmail.com",
        password: "33333333",
        dimage: "./img/user1.jpg",
        dage:"34 yrs, Female"
    }

    await fetch('http://localhost:8080/api/v1/doctors/register', {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message))

//Patient a Log in
    bodyObj = {
        firstName: "Kiran",
        lastName: "Freeman,",
        patientName: "a",
        password: "a"
    }

    await fetch('http://localhost:8080/api/v1/patients/register', {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message))

//Patient b Log in
    bodyObj = {
        firstName: "Vasilios",
        lastName: "Brown,",
        patientName: "b",
        password: "b"
    }

    await fetch('http://localhost:8080/api/v1/patients/register', {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message))


//Patient c Log in
    bodyObj = {
        firstName: "Catherine",
        lastName: "Lieman,",
        patientName: "c",
        password: "c"
    }

    await fetch('http://localhost:8080/api/v1/patients/register', {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message))

////User 1 Apartment 3===============================================================================
//    bodyObj = {
//        unit: '3', //
//        problem: 'Bathroom',
//        category: 'Plumbing',
//        description: 'Towel warmer is leaking',
//        imgUrl: 'https://res.cloudinary.com/dujmljv3d/image/upload/v1670201491/nlhegtfu7oo098jm3obx.jpg',
//        rDate: Date.now(),
//        rTime: Date.now(),
//        status: "open"
//    }
//    await fetch("http://localhost:8080/api/v1/requests/user/1", {
//        method: "POST",
//        body: JSON.stringify(bodyObj),
//        headers: headers
//    }).catch(err => console.error(err.message))
//
////User 2 Apartment 7===============================================================================
//    bodyObj = {
//        unit: '7', //
//        problem: 'Bathroom',
//        category: 'Finishes',
//        description: 'Walls need some paint',
//        imgUrl: 'https://res.cloudinary.com/dujmljv3d/image/upload/v1670201477/tzjviza51r07yzkalndw.jpg',
//        rDate: Date.now(),
//        rTime: Date.now(),
//        status: "open"
//    }
//    await fetch("http://localhost:8080/api/v1/requests/user/2", {
//        method: "POST",
//        body: JSON.stringify(bodyObj),
//        headers: headers
//    }).catch(err => console.error(err.message))
//
////User 3 Apartment 10===============================================================================
//    bodyObj = {
//        unit: '10',//
//        problem: 'Bedroom',
//        category: 'Finishes',
//        description: 'Water damage on the floor',
//        imgUrl: 'https://res.cloudinary.com/dujmljv3d/image/upload/v1669695008/fcuzuklln75rbjhh6snq.jpg',
//        rDate: Date.now(),
//        rTime: Date.now(),
//        status: "open"
//    }
//    await fetch("http://localhost:8080/api/v1/requests/user/3", {
//        method: "POST",
//        body: JSON.stringify(bodyObj),
//        headers: headers
//    }).catch(err => console.error(err.message))
//
//    bodyObj = {
//        unit: '10',//
//        problem: 'Bedroom',
//        category: 'Finishes',
//        description: 'Wall need some touch-ups',
//        imgUrl: 'https://res.cloudinary.com/dujmljv3d/image/upload/v1669695132/sf3x587jrubiuougqchf.jpg',
//        rDate: Date.now(),
//        rTime: Date.now(),
//        status: "open"
//    }
//    await fetch("http://localhost:8080/api/v1/requests/user/3", {
//        method: "POST",
//        body: JSON.stringify(bodyObj),
//        headers: headers
//    }).catch(err => console.error(err.message))
//
//    bodyObj = {
//        unit: '10',
//        problem: 'Kitchen',
//        category: 'Plumbing',
//        description: 'Dent on a kitchen cabinet',
//        imgUrl: 'https://res.cloudinary.com/dujmljv3d/image/upload/v1670201438/bxj3iwe6z3izhk9el9na.jpg',
//        rDate: Date.now(),
//        rTime: Date.now(),
//        status: "open"
//    }
//    await fetch("http://localhost:8080/api/v1/requests/user/3", {
//        method: "POST",
//        body: JSON.stringify(bodyObj),
//        headers: headers
//    }).catch(err => console.error(err.message))
//
////User 1 Apartment 3===============================================================================
//    bodyObj = {
//        unit: '3',
//        problem: 'Den',
//        category: 'Finishes',
//        description: 'Cabinet door is disengaged',
//        imgUrl: 'https://res.cloudinary.com/dujmljv3d/image/upload/v1670201400/xac6lkyd7us6oagc1z9h.jpg',
//        rDate: Date.now(),
//        rTime: Date.now(),
//        status: "open"
//    }
//    await fetch("http://localhost:8080/api/v1/requests/user/1", {
//        method: "POST",
//        body: JSON.stringify(bodyObj),
//        headers: headers
//    }).catch(err => console.error(err.message))
//
//     bodyObj = {
//            unit: '3',
//            problem: 'Kitchen',
//            category: 'Lighting',
//            description: 'Light Bulb needs to be switched',
//            imgUrl: '	https://res.cloudinary.com/dujmljv3d/image/upload/v1670201844/ei8vuxblwftv9cicwn7i.jpg',
//            rDate: Date.now(),
//            rTime: Date.now(),
//            status: "open"
//        }
//        await fetch("http://localhost:8080/api/v1/requests/user/1", {
//            method: "POST",
//            body: JSON.stringify(bodyObj),
//            headers: headers
//        }).catch(err => console.error(err.message))
//
//
////User 3 Apartment 10===============================================================================
//     bodyObj = {
//            unit: '10',
//            problem: 'Kitchen',
//            category: 'Lighting',
//            description: 'Lighting over the cooktop stopped working',
//            imgUrl: 'https://res.cloudinary.com/dujmljv3d/image/upload/v1670201685/ybmizursgs2ob1bhryjg.jpg',
//            rDate: Date.now(),
//            rTime: Date.now(),
//            status: "open"
//        }
//        await fetch("http://localhost:8080/api/v1/requests/user/3", {
//            method: "POST",
//            body: JSON.stringify(bodyObj),
//            headers: headers
//        }).catch(err => console.error(err.message))
//
//
}