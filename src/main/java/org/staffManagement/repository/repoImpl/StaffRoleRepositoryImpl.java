package org.staffManagement.repository.repoImpl;

import org.staffManagement.dbConfig.DbConfiguration;
import org.staffManagement.model.StaffRole;
import org.staffManagement.repository.StaffRoleRepository;

import java.util.ArrayList;
import java.util.List;

public class StaffRoleRepositoryImpl extends DbConfiguration implements StaffRoleRepository {
    @Override
    public List<StaffRole> getAllStaffRoles() {
        try{
            preparedStatement = connection.prepareStatement("select * from staffrole");
            resultSet = preparedStatement.executeQuery();
            List<StaffRole> staffRoles = new ArrayList<>();
            while(resultSet.next()){
                StaffRole staffRole = new StaffRole();
                staffRole.setRole(resultSet.getString("r_name"));
                staffRole.setSr_id(resultSet.getInt("r_id"));
                staffRoles.add(staffRole);
            }
            return staffRoles;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public StaffRole getStaffRoleById(int id) {
        try {
            preparedStatement = connection.prepareStatement("select * from staffrole where r_id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                StaffRole staffRole = new StaffRole();
                staffRole.setRole(resultSet.getString("r_name"));
                staffRole.setSr_id(resultSet.getInt("r_id"));
                return staffRole;


            }
            else {
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean addStaffRole(StaffRole staffRole) {
        try{
            preparedStatement=connection.prepareStatement("insert into staffrole (r_name) values (?)");
            preparedStatement.setString(1, staffRole.getRole());
            return preparedStatement.executeUpdate()>0;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateStaffRole(StaffRole staffRole) {
        try{
            preparedStatement=connection.prepareStatement("update staffrole set r_name=? where r_id=?");
            preparedStatement.setString(1, staffRole.getRole());
            preparedStatement.setInt(2, staffRole.getSr_id());
            return preparedStatement.executeUpdate()>0;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteStaffRole(int id) {
        try {
            preparedStatement=connection.prepareStatement("delete from staffrole where r_id=?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()>0;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public StaffRole getStaffRoleByName(String name) {
        try{
            preparedStatement=connection.prepareStatement("select * from staffrole where r_name=?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                StaffRole staffRole = new StaffRole();
                staffRole.setRole(resultSet.getString("r_name"));
                staffRole.setSr_id(resultSet.getInt("r_id"));
                return staffRole;
            }else {
                return null;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
