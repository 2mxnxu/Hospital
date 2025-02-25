package Hospital.doctor.service;

import Hospital.doctor.model.dto.DoctorDto;
import Hospital.doctor.model.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    public int save(DoctorDto doctorDto) {
        return doctorMapper.save(doctorDto);
    }

    public DoctorDto findById(int doctorid) {
        return doctorMapper.findById(doctorid);
    }

    public int update(DoctorDto doctorDto) {
        return doctorMapper.update(doctorDto);
    }

    public int delete(int doctorid) {
        return doctorMapper.delete(doctorid);
    }

    public List<DoctorDto> findAll() {
        return doctorMapper.findAll();
    }
}
