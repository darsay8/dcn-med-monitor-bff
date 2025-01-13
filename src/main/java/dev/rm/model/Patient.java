package dev.rm.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Long patientId;
    private String name;
    private String birthDate;
    private String diagnosis;
    private String status;
    private LocalDateTime dateOfAdmission;
    private LocalDateTime updatedAt;

}
