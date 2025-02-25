package Hospital.reservation.model.dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResDto {
    private int appointmentid;
    private int patientid;
    private int doctorid;
    private String appointmentdate;
    private String appointmenttime;
    private int status;
}
