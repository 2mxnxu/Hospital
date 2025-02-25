package Hospital.reservation.controller;

import Hospital.reservation.model.dto.ResDto;
import Hospital.reservation.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hospital/reservation")
public class ResController {

    @Autowired
    private ResService resService;

    // 예약 추가 (등록)
    @PostMapping("")
    public int save(@RequestBody ResDto resDto) {
        return resService.save(resDto);
    }

    // 예약 수정
    @PutMapping("")
    public int update(@RequestBody ResDto resDto) {
        System.out.println("Received DTO: " + resDto);
        return resService.update(resDto);
    }


    // 특정 날짜의 예약 목록 조회
    @GetMapping("/bydate")
    public List<ResDto> getByDate(@RequestParam String appointmentdate) {
        return resService.getByDate(appointmentdate);
    }

    // 의사별 예약 목록 조회
    @GetMapping("/bydoctor")
    public List<ResDto> getByDoctor(@RequestParam int doctorid) {
        return resService.getByDoctor(doctorid);
    }

    // 환자별 예약 목록 조회
    @GetMapping("/bypatient")
    public List<ResDto> getByPatient(@RequestParam int patientid) {
        return resService.getByPatient(patientid);
    }

    // 예약 상태 변경 (취소)
    @PutMapping("/cancel")
    public int cancelReservation(@RequestBody ResDto resDto) {
        // resDto에서 appointmentid와 status 값을 가져와서 예약 취소 처리
        return resService.cancelReservation(resDto.getAppointmentid(), resDto.getStatus());
    }

}
