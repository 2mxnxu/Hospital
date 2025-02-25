package Hospital.patient.service;

import Hospital.patient.model.dto.PatientDto;
import Hospital.patient.model.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientMapper patientMapper;  // 잘못된 부분 수정

    public int save(PatientDto patientDto) {
        return patientMapper.save(patientDto);
    }

    public PatientDto getById(int patientid) {
        return patientMapper.findById(patientid);
    }

    public int update(PatientDto patientDto) {
        return patientMapper.update(patientDto);
    }

    public void delete(int patientid) {
        patientMapper.delete(patientid);
    }

    public List<PatientDto> getAll() {
        return patientMapper.findAll();
    }
}

