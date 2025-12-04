package org.staffManagement.repository;

import org.staffManagement.model.Department;
import org.staffManagement.model.Staff;
import org.staffManagement.model.StaffRole;

import java.util.List;

public interface StaffRepository {
    public List<Staff> getAllStaff();
    public List<Staff> getAllStaffByDepartment(Department department);
    public List<Staff> getAllStaffByRole(StaffRole staffRole);
    public boolean addStaff(Staff staff);
    public boolean updateStaff(Staff staff);
    public boolean deleteStaff(int id);
}
