package org.staffManagement.DepartmentModule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.Department;

import java.util.List;

public class DeparmentModuleTest {

    @Test
    void testAddDeptSuccess() {
        Department d = new Department();
        d.setName("Cardiology");
        d.setDescriptin("Heart related department");

        boolean result = ServiceHelper.deptService.addDept(d);

        Assertions.assertTrue(result, "Department should be added when valid data is passed");
    }

    @Test
    void testAddDeptFailByNullName() {
        Department d = new Department();
        d.setName(null);
        d.setDescriptin("Description");

        boolean result = ServiceHelper.deptService.addDept(d);

        Assertions.assertFalse(result, "Department should not be added when name is null");
    }

    @Test
    void testAddDeptFailByEmptyName() {
        Department d = new Department();
        d.setName("");                      // Empty string case
        d.setDescriptin("Description");

        boolean result = ServiceHelper.deptService.addDept(d);

        Assertions.assertFalse(result, "Department should not be added when name is empty");
    }

    @Test
    void testUpdateDeptSuccess() {
        Department d = new Department();
        d.setName("Neurology");
        d.setDescriptin("Brain related department");

        ServiceHelper.deptService.addDept(d);
        int deptId = d.getD_id();  // assuming id assigned after save

        Department updated = new Department();
        updated.setD_id(deptId);
        updated.setName("NeuroScience");
        updated.setDescriptin("Updated desc");

        boolean result = ServiceHelper.deptService.updateDept(updated);

        Assertions.assertTrue(result, "Department should be updated for correct ID");
    }

    @Test
    void testUpdateDeptFailWrongId() {
        Department d = new Department();
        d.setD_id(999);                      // Wrong ID which does not exist
        d.setName("Wrong Name");
        d.setDescriptin("Wrong desc");

        boolean result = ServiceHelper.deptService.updateDept(d);

        Assertions.assertFalse(result, "Update should fail when incorrect ID is passed");
    }

    @Test
    void testDeleteDeptSuccess() {
        Department d = new Department();
        d.setName("Dental");
        d.setDescriptin("Teeth treatment");

        ServiceHelper.deptService.addDept(d);
        int deptId = d.getD_id();

        boolean result = ServiceHelper.deptService.deleteDept(deptId);

        Assertions.assertTrue(result, "Department should be deleted successfully");
    }

    @Test
    void testDeleteDeptFailWrongId() {
        boolean result = ServiceHelper.deptService.deleteDept(10000); // Non existing ID

        Assertions.assertFalse(result, "Delete should fail for invalid Department ID");
    }

    @Test
    void testGetAllDept() {
        List<Department> list = ServiceHelper.deptService.getAllDept();
        Assertions.assertNotNull(list, "List should not be null");
    }
}
