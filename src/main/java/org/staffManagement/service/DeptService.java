package org.staffManagement.service;

import java.util.*;

import org.staffManagement.model.Department;

public interface DeptService {
	boolean addDept(Department dept);
	List<Department> getAllDept();
	boolean deleteDept(int deptId);
	boolean updateDept(Department dept);
    Department getDeptById(int deptId);
    Department getDeptByName(String deptName);
	
}
