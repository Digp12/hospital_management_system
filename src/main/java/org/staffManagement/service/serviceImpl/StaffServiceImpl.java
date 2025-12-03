package org.staffManagement.service.serviceImpl;

import org.staffManagement.model.Department;
import org.staffManagement.model.Staff;
import org.staffManagement.model.StaffRole;
import org.staffManagement.repository.StaffRepository;
import org.staffManagement.repository.repoImpl.StaffRepositoryImpl;
import org.staffManagement.service.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository=new StaffRepositoryImpl();
    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    @Override
    public List<Staff> getAllStaffByDepartment(Department department) {
        return staffRepository.getAllStaffByDepartment(department);
    }

    @Override
    public List<Staff> getAllStaffByRole(StaffRole staffRole) {
        return staffRepository.getAllStaffByRole(staffRole);
    }

    @Override
    public boolean addStaff(Staff staff) {
        return staffRepository.addStaff(staff);
    }

    @Override
    public boolean updateStaff(Staff staff) {
        return false;
    }

    @Override
    public boolean deleteStaff(Staff staff) {
        return s;
    }
}
