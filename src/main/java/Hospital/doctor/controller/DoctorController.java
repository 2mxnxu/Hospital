package Hospital.doctor.controller;

import Hospital.doctor.model.dto.DoctorDto;
import Hospital.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("")
    public int save(@RequestBody DoctorDto doctorDto) {
        return doctorService.save(doctorDto);
    }
    @GetMapping("")
    public List<DoctorDto> findAll() {
        return doctorService.findAll();
    }
    @PutMapping("")
    public int update(@RequestBody DoctorDto doctorDto) {
       return doctorService.update(doctorDto);
    }
    @DeleteMapping("")
    public void delete(@RequestParam int doctorid) {
        doctorService.delete(doctorid);
    }

    @GetMapping("/view")
    public DoctorDto view(@RequestParam int doctorid) {
        return doctorService.findById(doctorid);
    }
}
