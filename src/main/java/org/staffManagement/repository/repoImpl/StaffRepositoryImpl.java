package org.staffManagement.repository.repoImpl;

import org.staffManagement.dbConfig.DbConfiguration;
import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.*;
import org.staffManagement.repository.DeptRepository;
import org.staffManagement.repository.StaffRepository;
import org.staffManagement.repository.StaffRoleRepository;

import java.util.ArrayList;
import java.util.List;

public class StaffRepositoryImpl extends DbConfiguration implements StaffRepository {

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement("select * from staff");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("s_id"));
                staff.setName(resultSet.getString("s_name"));
                staff.setGender(Gender.valueOf(resultSet.getString("s_gender")));
                staff.setEmail(resultSet.getString("s_email"));
                staff.setPhone(resultSet.getString("s_phone"));
                staff.setAddress(resultSet.getString("s_address"));

                int id=resultSet.getInt("r_id");

                StaffRole staffRole= ServiceHelper.staffRoleService.getStaffRoleById(id);
                staff.setStaffRole(staffRole);
                id=resultSet.getInt("d_id");
                DeptRepository deptRepository = new DeptRepositoryImpl();
                Department department = ServiceHelper.deptService.getDeptById(id);
                staff.setDepartment(department);
                staff.setStatus(Status.valueOf(resultSet.getString("s_status")));
                staff.setJoinDate(resultSet.getDate("s_join_date"));
                staffList.add(staff);
            }
            return staffList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public List<Staff> getAllStaffByDepartment(Department department) {
        List<Staff> staffList = new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement("select * from staff where d_id=?");
            preparedStatement.setInt(1,department.getD_id());
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("s_id"));
                staff.setName(resultSet.getString("s_name"));
                staff.setGender(Gender.valueOf(resultSet.getString("s_gender")));
                staff.setEmail(resultSet.getString("s_email"));
                staff.setPhone(resultSet.getString("s_phone"));
                staff.setAddress(resultSet.getString("s_address"));
                StaffRoleRepository staffRoleRepository = new StaffRoleRepositoryImpl();
                int id=resultSet.getInt("r_id");

                StaffRole staffRole= ServiceHelper.staffRoleService.getStaffRoleById(id);
                staff.setStaffRole(staffRole);
                id=resultSet.getInt("d_id");
                DeptRepository deptRepository = new DeptRepositoryImpl();
                department = ServiceHelper.deptService.getDeptById(id);
                staff.setDepartment(department);
                staff.setStatus(Status.valueOf(resultSet.getString("s_status")));
                staff.setJoinDate(resultSet.getDate("s_join_date"));
                staffList.add(staff);

            }
            return staffList;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public List<Staff> getAllStaffByRole(StaffRole staffRole) {
        List<Staff> staffList = new ArrayList<>();
        try{
            preparedStatement=connection.prepareStatement("select * from staff where r_id=?");
            preparedStatement.setInt(1,staffRole.getSr_id());
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("s_id"));
                staff.setName(resultSet.getString("s_name"));
                staff.setGender(Gender.valueOf(resultSet.getString("s_gender")));
                staff.setEmail(resultSet.getString("s_email"));
                staff.setPhone(resultSet.getString("s_phone"));
                staff.setAddress(resultSet.getString("s_address"));
                StaffRoleRepository staffRoleRepository = new StaffRoleRepositoryImpl();
                int id=resultSet.getInt("r_id");

                staffRole= ServiceHelper.staffRoleService.getStaffRoleById(id);
                staff.setStaffRole(staffRole);
                id=resultSet.getInt("d_id");
                DeptRepository deptRepository = new DeptRepositoryImpl();
                Department department = ServiceHelper.deptService.getDeptById(id);
                staff.setDepartment(department);

                staff.setJoinDate(resultSet.getDate("join_date"));
                staff.setStatus(Status.valueOf(resultSet.getString("s_status")));

                staffList.add(staff);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public boolean addStaff(Staff staff) {
        try{
            preparedStatement=connection.prepareStatement("insert into staff(s_id,s_name,s_gender,s_phone,s_address,d_id,r_id,s_status,join_date) values(?,?,?,?,?,?,?,?,?,?,current_date)");
            preparedStatement.setInt(1, staff.getStaff_id());
            preparedStatement.setString(2, staff.getName());
            preparedStatement.setString(3, String.valueOf(staff.getGender()));
            preparedStatement.setString(4, staff.getPhone());
            preparedStatement.setString(5, staff.getAddress());
            preparedStatement.setInt(6,staff.getDepartment().getD_id());
            preparedStatement.setInt(7,staff.getStaffRole().getSr_id());
            preparedStatement.setString(9, String.valueOf(staff.getStatus()));

            return preparedStatement.executeUpdate()>0;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateStaff(Staff staff) {
        return false;
    }

    @Override
    public boolean deleteStaff(Staff staff) {
        try{
            preparedStatement=connection.prepareStatement("delete from staff where s_id=?");
            preparedStatement.setInt(1,staff.getStaff_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
