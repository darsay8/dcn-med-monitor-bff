package dev.rm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alert {
    private Long alertId;
    private Long patientId;
    private Long vitalSignId;
    private String type;
    private String level;
    private String description;
    private Long timestamp;
}
