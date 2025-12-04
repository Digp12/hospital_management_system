package org.staffManagement.model;

import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Shifts {
    private int shiftId;
    private Staff staff;
    private LocalDate shiftDate;
    private ShiftType ShiftType;
    private LocalTime startTime;
    private LocalTime endTime;
}
