package org.staffManagement.service.serviceImpl;

import java.util.List;

import org.staffManagement.model.Department;
import org.staffManagement.repository.DeptRepository;
import org.staffManagement.repository.DeptRepositoryImpl;
import org.staffManagement.service.DeptService;

public class DeptServiceImpl implements DeptService {

	DeptRepository deptRepository = new DeptRepositoryImpl();
	@Override
	public boolean addDept(Department dept) {
		
		return deptRepository.addDept(dept);
	}

	@Override
	public List<Department> getAllDept() {
	
		return deptRepository.getAllDept();
	}

	@Override
	public boolean deleteDept(int deptId) {
		return deptRepository.deleteDept(deptId);
	}

	@Override
	public boolean updateDept(Department dept) {
		return deptRepository.updateDept(dept);
	}

}
