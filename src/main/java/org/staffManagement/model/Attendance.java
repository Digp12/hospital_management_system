package org.staffManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    private int id;
    private int staff_id;
    private LocalDate date;
    private LocalTime in_time;
    private LocalTime out_time;
    private String status;
}
