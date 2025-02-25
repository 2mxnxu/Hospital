// 신규 진료 예약 추가 함수
const onSave = async () => {
    const patientid = document.querySelector('#patientid').value;
    const doctorid = document.querySelector('#doctorid').value;
    const appointmentdate = document.querySelector('#appointmentdate').value;
    const appointmenttime = document.querySelector('#appointmenttime').value;

    const reservation = { patientid, doctorid, appointmentdate, appointmenttime };
    try {
        const response = await axios.post('/hospital/reservation', reservation);
        if (response.data === 1) {
            alert("예약 성공");
            onFindAll();
        }
    } catch (e) {
        console.log(e);
    }
};

// 특정 날짜의 예약 목록 조회 함수
const onFindByDate = async () => {
    const date = document.querySelector('#findDate').value;
    try {
        const response = await axios.get(`/hospital/reservation/bydate?appointmentdate=${date}`);
        displayReservations(response.data);
    } catch (e) {
        console.log(e);
    }
};

// 환자별 예약 조회 함수
const onFindByPatient = async () => {
    const patientid = document.querySelector('#patientSearch').value;
    try {
        const response = await axios.get(`/hospital/reservation/bypatient?patientid=${patientid}`);
        displayReservations(response.data);
    } catch (e) {
        console.log(e);
    }
};

// 의사별 예약 조회 함수
const onFindByDoctor = async () => {
    const doctorid = document.querySelector('#doctorSearch').value;
    try {
        const response = await axios.get(`/hospital/reservation/bydoctor?doctorid=${doctorid}`);
        displayReservations(response.data);
    } catch (e) {
        console.log(e);
    }
};

// 예약 수정 함수
const onUpdate = async (appointmentid) => {
    // 사용자에게 새로운 예약 날짜와 시간을 입력 받음
    const appointmentdate = prompt("새로운 예약 날짜 (예: 2025-03-01):");
    const appointmenttime = prompt("새로운 예약 시간 (예: 09:30:00):");

    // 새로운 예약 정보를 담은 객체 생성
    const resDto = {
        appointmentid: appointmentid,
        appointmentdate: appointmentdate,
        appointmenttime: appointmenttime
    };

    try {
        // 예약 수정 API 호출 (PUT 요청)
        const response = await axios.put('/hospital/reservation', resDto);

        if (response.data === 1) {
            alert("예약 수정 성공!");
            onFindAll(); // 예약 목록 갱신
        } else {
            alert("예약 수정 실패!");
        }
    } catch (e) {
        console.log(e);
    }
};


// 예약 취소 함수
const onCancel = async (appointmentid) => {
    if (confirm("정말로 예약을 취소하시겠습니까?")) {
        const resDto = {
            appointmentid: appointmentid,
            status: 0  // 예약 취소 상태로 설정
        };

        try {
            // 예약 취소 API 호출 (PUT 요청)
            const response = await axios.put('/hospital/reservation/cancel', resDto);

            if (response.data === 1) {
                alert("예약 취소 성공!");
                onFindAll(); // 예약 목록 갱신
            } else {
                alert("예약 취소 실패!");
            }
        } catch (e) {
            console.log(e);
        }
    }
};



// 예약 목록 출력 함수
const displayReservations = (reservations) => {
    const tbody = document.getElementById('reservationTable');
    let html = '';
    reservations.forEach(reservation => {
        html += `<tr>
                    <td>${reservation.appointmentid}</td>
                    <td>${reservation.patientid}</td>
                    <td>${reservation.doctorid}</td>
                    <td>${reservation.appointmentdate}</td>
                    <td>${reservation.appointmenttime}</td>
                    <td>${reservation.status === 1 ? '예약됨' : '취소됨'}</td>
                    <td><button onclick="onUpdate(${reservation.appointmentid})">수정</button></td>
                    <td><button onclick="onCancel(${reservation.appointmentid})">취소</button></td>
                </tr>`;
    });
    tbody.innerHTML = html;
};
