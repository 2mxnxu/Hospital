package Hospital.reservation.model.mapper;

import Hospital.reservation.model.dto.ResDto;
import lombok.Setter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ResMapper {
    @Insert("INSERT INTO appointment (patientid, doctorid, appointmentdate, appointmenttime) VALUES (#{patientid}, #{doctorid}, #{appointmentdate}, #{appointmenttime})")
    int save(ResDto resDto);

    @Update("UPDATE appointment SET appointmentdate = #{appointmentdate}, " +
            "appointmenttime = #{appointmenttime} WHERE appointmentid = #{appointmentid}")
    int update(ResDto resDto);

    @Update("UPDATE appointment SET status = #{status} WHERE appointmentid = #{appointmentid} AND status = 1")
    int cancelReservation(int appointmentid, int status);


    @Select("SELECT a.appointmentid, a.patientid, p.name AS patient_name, a.appointmentdate, a.appointmenttime, a.status, a.createdat, a.doctorid " +
            "FROM appointment a " +
            "JOIN patient p ON a.patientid = p.patientid " +
            "WHERE a.appointmentdate = #{appointmentdate}")
    List<ResDto> findByDate(String appointmentdate);

    // 의사별 예약 목록 조회
    @Select("SELECT a.appointmentid, a.patientid, p.name AS patient_name, a.appointmentdate, a.appointmenttime, a.status, a.createdat, a.doctorid " +
            "FROM appointment a " +
            "JOIN patient p ON a.patientid = p.patientid " +
            "WHERE a.doctorid = #{doctorid}")
    List<ResDto> findByDoctor(int doctorid);

    // 환자별 예약 목록 조회
    @Select("SELECT a.appointmentid, a.patientid, p.name AS patient_name, a.appointmentdate, a.appointmenttime, a.status, a.createdat, a.doctorid " +
            "FROM appointment a " +
            "JOIN patient p ON a.patientid = p.patientid " +
            "WHERE a.patientid = #{patientid}")
    List<ResDto> findByPatient(int patientid);

}
