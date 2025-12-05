package org.staffManagement.StaffRoleModule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.StaffRole;

public class StaffRoleModuleTest {
    @Test
    void addStaffRolePass() {
        StaffRole staffRole=new StaffRole();
        staffRole.setSr_id(0);
        staffRole.setRole("Nurse");
        Assertions.assertTrue(ServiceHelper.staffRoleService.addStaffRole(staffRole) ,"Staff Role will add if we pass correct details" );
    }

}
