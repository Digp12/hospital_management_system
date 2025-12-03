package org.staffManagement.service.serviceImpl;

import org.staffManagement.repository.AdminLoginRepo;
import org.staffManagement.repository.AdminLoginRepoImpl;
import org.staffManagement.service.AdminLoginService;

public class AdminLoginServiceImpl implements AdminLoginService{
	
	AdminLoginRepo adminLoginRepo = new AdminLoginRepoImpl();
	
	@Override
	public boolean isLogin(String un, String pass) {
		return adminLoginRepo.isLogin(un,pass);
	}

}
