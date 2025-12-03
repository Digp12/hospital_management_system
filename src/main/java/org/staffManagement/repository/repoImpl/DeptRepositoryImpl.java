package org.staffManagement.repository.repoImpl;

import java.util.ArrayList;
import java.util.List;

import org.staffManagement.dbConfig.DbConfiguration;
import org.staffManagement.model.Department;
import org.staffManagement.repository.DeptRepository;

public class DeptRepositoryImpl extends DbConfiguration implements DeptRepository {

	@Override
	public boolean addDept(Department dept) {
		try {
			
			preparedStatement = connection.prepareStatement("insert into department(d_id,d_name,d_desc) values(?,?,?)");
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, dept.getName());
			preparedStatement.setString(3, dept.getDescriptin());
			int b =  preparedStatement.executeUpdate();
			return b == 1?true:false;
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<Department> getAllDept() {
		try {
			List<Department> list = new ArrayList<Department>();
			Department department = null;
			preparedStatement = connection.prepareStatement("select * from department");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				department = new Department();
				department.setD_id(resultSet.getInt("d_id"));
				department.setName(resultSet.getString("d_name"));
				department.setDescriptin(resultSet.getString("d_desc"));
				list.add(department);
			}
			return list;
		}catch(Exception x) {
			System.out.println(x);
			return null;
		}
	}

	@Override
	public boolean deleteDept(int deptId) {
        try {
            preparedStatement = connection.prepareStatement("delete  from department where d_id=?");
            preparedStatement.setInt(1, deptId);
            return preparedStatement.executeUpdate()>0;
        }catch (Exception e){
            System.out.println(e);
        }
		return false;
	}

	@Override
	public boolean updateDept(Department dept) {
        try{
            preparedStatement=connection.prepareStatement("update department set d_name=?,d_desc=? where d_id=?");
            preparedStatement.setString(1,dept.getName());
            preparedStatement.setString(2, dept.getDescriptin());
            preparedStatement.setInt(3, dept.getD_id());
            return preparedStatement.executeUpdate()>0;
        }catch(Exception e){
            System.out.println(e);
        }
		return false;
	}

    @Override
    public Department getDeptById(int deptId) {
        try{

            preparedStatement = connection.prepareStatement("select * from department where d_id=?");
            preparedStatement.setInt(1, deptId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Department department = new Department();
                department.setD_id(resultSet.getInt("d_id"));
                department.setName(resultSet.getString("d_name"));
                department.setDescriptin(resultSet.getString("d_desc"));
                return department;
            }else return null;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Department getDeptByName(String deptName) {
        try{
            preparedStatement = connection.prepareStatement("select * from department where d_name=?");
            preparedStatement.setString(1, deptName);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Department department = new Department();
                department.setD_id(resultSet.getInt("d_id"));
                department.setName(resultSet.getString("d_name"));
                department.setDescriptin(resultSet.getString("d_desc"));
                return department;

            }else return null;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
