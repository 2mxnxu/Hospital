package Hospital.doctor.model.dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private int doctorid;
    private String name;
    private String specialty;
    private String phone;
    private String createdat;
}
