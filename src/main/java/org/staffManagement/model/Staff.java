package org.staffManagement.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Staff {

    private int staff_id;
    private String name;
    private Gender gender;
    private String phone;
    private String email;
    private String address;
    private LocalDate joinDate;
    private Status status;
    private Department department;
    private StaffRole staffRole;
}
