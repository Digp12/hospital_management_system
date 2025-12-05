package org.staffManagement.repository;

import org.staffManagement.model.StaffRole;

import java.util.List;

public interface StaffRoleRepository {
     List<StaffRole> getAllStaffRoles();
     StaffRole getStaffRoleById(int id);
     boolean addStaffRole(StaffRole staffRole);
     boolean updateStaffRole(StaffRole staffRole);
     boolean deleteStaffRole(int id);
     StaffRole getStaffRoleByName(String name);
}
