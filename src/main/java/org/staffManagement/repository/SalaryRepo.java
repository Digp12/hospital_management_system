package org.staffManagement.repository;

import org.staffManagement.model.Salary;

import java.util.List;

public interface SalaryRepo {
    boolean addSalary(Salary s);
    boolean updateSalary(Salary s);
    boolean deleteSalary(int sid);
    List<Salary> viewSalary();
    int findHolidayReduction(int id);

    Salary getSalaryById(int salId);
}
