package Hospital.reservation.service;

import Hospital.reservation.model.dto.ResDto;
import Hospital.reservation.model.mapper.ResMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResService {

        @Autowired
        private ResMapper resMapper;

        public int update(ResDto resDto) {
                System.out.println( resDto);
                return resMapper.update(resDto);
        }


        public int cancelReservation(int appointmentid, int status) {
                // status가 0으로 설정되어야 하므로, DB에서 해당 예약의 상태를 변경하는 쿼리 실행
                return resMapper.cancelReservation(appointmentid, status);
        }


        public List<ResDto> getByDate(String appointmentdate) {
        return resMapper.findByDate(appointmentdate);
        }

        public List<ResDto> getByDoctor(int doctorid) {
                return resMapper.findByDoctor(doctorid);
        }


        public List<ResDto> getByPatient(int patientid) {
        return resMapper.findByPatient(patientid);
        }

        public int save(ResDto resDto) {
            return resMapper.save(resDto);

        }
}


