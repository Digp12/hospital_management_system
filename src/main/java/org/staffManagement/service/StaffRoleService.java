package org.staffManagement.service;

import org.staffManagement.model.StaffRole;

import java.util.List;

public interface StaffRoleService {
    List<StaffRole> getAllStaffRoles();
    StaffRole getStaffRoleById(int id);
    boolean addStaffRole(StaffRole staffRole);
    boolean updateStaffRole(StaffRole staffRole);
    boolean deleteStaffRole(int id);
    StaffRole getStaffRoleByName(String name);

}
