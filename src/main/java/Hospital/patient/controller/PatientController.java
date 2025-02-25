package Hospital.patient.controller;

import Hospital.patient.model.dto.PatientDto;
import Hospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("")
    public int save(@RequestBody PatientDto patientDto) {
        return patientService.save(patientDto);
    }
    @GetMapping("")
    public List<PatientDto> getAll() {
        return patientService.getAll();
    }
    @PutMapping("")
    public int update(@RequestBody PatientDto patientDto) {
        return patientService.update(patientDto);
    }
    @DeleteMapping("")
    public void delete(@RequestParam int patientid) {
        patientService.delete(patientid);
    }
    @GetMapping("/view")
    public PatientDto view(@RequestParam int patientid) {
        return patientService.getById(patientid);
    }
}
