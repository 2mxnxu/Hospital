// [4] 삭제 함수
const onDelete = async(patientid) => {
    if (confirm("정말 삭제하시겠습까?")) {
        const response = await axios.delete(`/hospital/patient?patientid=${patientid} `);
        if (response.data == 1) {
        onFindAll();
            alert("삭제 성공!");
        }
    }
}
// [3] 개별 수정 함수
const onUpdate = async(patientid) => {
    const name = prompt("수정할 이름:");
    const birthdate = prompt("수정할 생년월일:");
    const phone = prompt("수정할 휴대폰번호:");
    const address = prompt("수정할 주소:");

    const obj = { patientid, name, birthdate, phone, address  };

    const response = await axios.put(`/hospital/patient`, obj);
    if (response.data == 1) {
    onFindAll();
        alert("수정 성공!");

    }
}
// [2] 전체 조회 함수
const onFindAll = async () => {
    try {
        const response = await axios.get('/hospital/patient');
        console.log(response.data);

        const tbody = document.querySelector('tbody');
        let html = ``;
        response.data.forEach(patient => {
            // 의사명에 링크 추가
            html += `<tr>
                        <td><a href="#" onclick="onView(${patient.patientid})">${patient.name}</a></td>
                        <td>${patient.birthdate}</td>
                        <td>${patient.phone}</td>
                        <td>${patient.address}</td>
                        <td><button onclick="onUpdate(${patient.patientid})">수정</button></td>
                        <td><button onclick="onDelete(${patient.patientid})">삭제</button></td>
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
    const birthdate = document.querySelector('.birthdate').value;
    const phone = document.querySelector('.phone').value;
    const address = document.querySelector('.address').value;

    const obj = { name , birthdate , phone, address };
    console.log( obj );

    axios.post( '/hospital/patient' , obj )
        .then( response => { console.log( response.data ); onFindAll(); })
        .catch( e => { console.log( e ); } )

}
onFindAll();

const onView = async (patientid) => {
    try {
        const response = await axios.get(`/hospital/patient/view?patientid=${patientid}`);
        const patient = response.data;

        alert(`이름: ${patient.name}\n생년월일: ${patient.birthdate}\n휴대폰 번호: ${patient.phone}\n주소: ${patient.address}\n등록일: ${patient.createdat}`);

    } catch (e) {
        console.log(e);
    }
}
