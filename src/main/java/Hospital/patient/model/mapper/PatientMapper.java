package Hospital.patient.model.mapper;

import Hospital.patient.model.dto.PatientDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientMapper {
    @Insert("INSERT INTO patient (name, birthdate, phone, address) VALUES (#{name}, #{birthdate}, #{phone}, #{address})")
    int save(PatientDto patientDto);
    @Update("UPDATE patient SET name = #{name}, birthdate = #{birthdate}, phone = #{phone}, address = #{address} WHERE patientid = #{patientid}")
    int update(PatientDto patientDto);
    @Delete("DELETE FROM patient WHERE patientid = #{patientid}")
    int delete(int patientid);
    @Select("SELECT * FROM patient WHERE patientid = #{patientid}")
    PatientDto findById(int patientid);
    @Select("SELECT * FROM patient")
    List<PatientDto> findAll();
}
