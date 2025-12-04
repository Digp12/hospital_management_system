package org.staffManagement.service.serviceImpl;

import org.staffManagement.model.Salary;
import org.staffManagement.repository.SalaryRepo;
import org.staffManagement.repository.repoImpl.SalaryRepoImpl;
import org.staffManagement.service.SalaryService;

import java.util.List;

public class SalaryServiceImpl implements SalaryService {

    SalaryRepo salaryRepo = new SalaryRepoImpl();
    @Override
    public boolean addSalary(Salary s) {
        return salaryRepo.addSalary(s);
    }

    @Override
    public boolean updateSalary(Salary s) {
        return salaryRepo.updateSalary(s);
    }

    @Override
    public boolean deleteSalary(int sid) {
        return salaryRepo.deleteSalary(sid);
    }

    @Override
    public List<Salary> viewSalary() {
        return salaryRepo.viewSalary();
    }

    @Override
    public int findHolidayReduction(int id) {
        return salaryRepo.findHolidayReduction(id);
    }

    @Override
    public Salary getSalaryById(int salId) {
        return salaryRepo.getSalaryById(salId);
    }
}
