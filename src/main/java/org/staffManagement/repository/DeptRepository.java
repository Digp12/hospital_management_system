package org.staffManagement.repository;

import java.util.*;

import org.staffManagement.model.Department;

public interface DeptRepository {
	boolean addDept(Department dept);
	List<Department> getAllDept();
	boolean deleteDept(int deptId);
	boolean updateDept(Department dept);
    Department getDeptById(int deptId);
    Department getDeptByName(String deptName);

}
