package org.staffManagement.repository.repoImpl;

import org.staffManagement.dbConfig.DbConfiguration;
import org.staffManagement.model.Attendance;
import org.staffManagement.repository.AttendaceRepo;

import java.util.List;

public class AttendaceRepoImpl extends DbConfiguration implements AttendaceRepo {
    @Override
    public boolean addAttendance(Attendance a) {
        try{
            preparedStatement = connection.prepareStatement("insert into attendance(a_id,s_id,att_date,in_time,out_time,status) values(?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setInt(2,a.getStaff_id());
            preparedStatement.setString(3, String.valueOf(a.getDate()));
            preparedStatement.setString(4,String.valueOf(a.getIn_time()));
            preparedStatement.setString(5,String.valueOf(a.getOut_time()));
            preparedStatement.setString(6,a.getStatus());
            int value = preparedStatement.executeUpdate();
            return value >= 1;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean updateAttendance(Attendance a) {
        return false;
    }

    @Override
    public boolean deleteAttendance(int id) {
        return false;
    }

    @Override
    public List<Attendance> showAllAttendance() {
        return List.of();
    }
}
