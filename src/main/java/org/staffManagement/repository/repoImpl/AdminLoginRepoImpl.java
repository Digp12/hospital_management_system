package org.staffManagement.repository.repoImpl;

import org.staffManagement.dbConfig.DbConfiguration;
import org.staffManagement.repository.AdminLoginRepo;

public class AdminLoginRepoImpl extends DbConfiguration implements AdminLoginRepo {
	
	
	public boolean isLogin(String un, String pass) {
		try {
			
			preparedStatement = connection.prepareStatement("select * from admin where aname=? and apassword=?");
			preparedStatement.setString(1, un);
			preparedStatement.setString(2, pass);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error is :"+ e);
			return false;
		}
	}

}
