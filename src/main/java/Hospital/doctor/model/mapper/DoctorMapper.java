package Hospital.doctor.model.mapper;

import Hospital.doctor.model.dto.DoctorDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {
    @Insert("INSERT INTO doctor (name, specialty, phone) VALUES (#{name}, #{specialty}, #{phone})")
    int save(DoctorDto doctor);

    @Update("UPDATE doctor SET name = #{name}, specialty = #{specialty}, phone = #{phone} WHERE doctorid = #{doctorid}")
    int update(DoctorDto doctor);

    @Delete("DELETE FROM doctor WHERE doctorid = #{doctorid}")
    int delete(int doctorid);

    @Select("SELECT * FROM doctor WHERE doctorid = #{doctorid}")
    DoctorDto findById(int doctorid);

    @Select("SELECT * FROM doctor")
    List<DoctorDto> findAll();


}
