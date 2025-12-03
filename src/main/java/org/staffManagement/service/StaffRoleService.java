package org.staffManagement.service;

import org.staffManagement.model.StaffRole;

import java.util.List;

public interface StaffRoleService {
    public List<StaffRole> getAllStaffRoles();
    public StaffRole getStaffRoleById(int id);
    public boolean addStaffRole(StaffRole staffRole);
    public boolean updateStaffRole(StaffRole staffRole);
    public boolean deleteStaffRole(int id);
    public StaffRole getStaffRoleByName(String name);

}
