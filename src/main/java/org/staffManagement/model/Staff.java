package org.staffManagement.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private int staff_id;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private Date joinDate;
    private String status;
    private Department department;
    private StaffRole staffRole;

}
