package org.staffManagement.repository;

import org.staffManagement.model.Department;
import org.staffManagement.model.Staff;
import org.staffManagement.model.StaffRole;

import java.util.List;

public interface StaffRepository {
     List<Staff> getAllStaff();
     List<Staff> getAllStaffByDepartment(Department department);
     List<Staff> getAllStaffByRole(StaffRole staffRole);
     boolean addStaff(Staff staff);
     boolean updateStaff(Staff staff);
     boolean deleteStaff(int id);
     Staff getStaffById(int id);
     Staff getStaffByName(String staffName);
}
