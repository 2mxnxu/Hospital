console.log("doctor.js open")

// [4] 삭제 함수
const onDelete = async(doctorid) => {
    if (confirm("정말 삭제하시겠습까?")) {
        const response = await axios.delete(`/hospital/doctor?doctorid=${doctorid} `);
        if (response.data == 1) {
            onFindAll();
            alert("삭제 성공!");
        }
    }
}
// [3] 개별 수정 함수
const onUpdate = async(doctorid) => {
    const name = prompt("수정할 이름 :");
    const specialty = prompt("수정할 전공 :");
    const phone = prompt("수정할 휴대폰번호 :");

    const obj = { doctorid, name, specialty, phone  };

    const response = await axios.put(`/hospital/doctor`, obj);
    if (response.data == 1) {
    onFindAll();
        alert("수정 성공!");

    }
}
// [2] 전체 조회 함수
const onFindAll = async () => {
    try {
        const response = await axios.get('/hospital/doctor');
        console.log(response.data);

        const tbody = document.querySelector('tbody');
        let html = ``;
        response.data.forEach(doctor => {
            // 의사명에 링크 추가
            html += `<tr>
                        <td><a href="#" onclick="onView(${doctor.doctorid})">${doctor.name}</a></td>
                        <td>${doctor.specialty}</td>
                        <td>${doctor.phone}</td>
                        <td>${doctor.createdat}</td>
                        <td><button onclick="onUpdate(${doctor.doctorid})">수정</button></td>
                        <td><button onclick="onDelete(${doctor.doctorid})">삭제</button></td>
                    </tr>`;
        });
        tbody.innerHTML = html;
    } catch (e) {
        console.log(e);
    }
}

onFindAll();

//
const onSave =  ( ) => {

    const name = document.querySelector('.name').value;
    const specialty = document.querySelector('.specialty').value;
    const phone = document.querySelector('.phone').value;

    const obj = { name , specialty , phone };
    console.log( obj );

    axios.post( '/hospital/doctor' , obj )
        .then( response => { console.log( response.data ); onFindAll(); })
        .catch( e => { console.log( e ); } )

}
onFindAll();

const onView = async (doctorid) => {
    try {
        const response = await axios.get(`/hospital/doctor/view?doctorid=${doctorid}`);
        const doctor = response.data;

        alert(`의사명: ${doctor.name}\n전공: ${doctor.specialty}\n휴대폰 번호: ${doctor.phone}\n등록일: ${doctor.createdat}`);

    } catch (e) {
        console.log(e);
    }
}
