package org.staffManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    int salary_id;
    int staff_id;
    int basic_salary;
    int Hra;
    int Da ;
    int Pf;
    YearMonth month_year;
    int net_salary;
}
