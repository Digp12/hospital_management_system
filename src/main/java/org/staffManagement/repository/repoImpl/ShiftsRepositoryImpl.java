package org.staffManagement.repository.repoImpl;

import org.staffManagement.dbConfig.DbConfiguration;
import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.ShiftType;
import org.staffManagement.model.Shifts;
import org.staffManagement.model.Staff;
import org.staffManagement.model.Status;
import org.staffManagement.repository.ShiftsRepository;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShiftsRepositoryImpl extends DbConfiguration implements ShiftsRepository {

    @Override
    public boolean assignShifts(Shifts shifts) {
        try {
            preparedStatement = connection.prepareStatement("insert into shifts (s_id,shift_date,start_time,end_time) values(?,?,?,?)");
            preparedStatement.setInt(1, shifts.getStaff().getStaff_id());
            preparedStatement.setDate(2, Date.valueOf(shifts.getShiftDate()));
            preparedStatement.setTime(3, Time.valueOf(shifts.getStartTime()));
            preparedStatement.setTime(4, Time.valueOf(shifts.getEndTime()));
            return preparedStatement.executeUpdate()>0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Shifts> getAllShifts() {
        List<Shifts> shiftsList = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement("select * from shifts");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Shifts shifts = new Shifts();
                shifts.setShiftId(resultSet.getInt("shift_id"));
                Staff staff = ServiceHelper.staffService.getStaffById(resultSet.getInt("s_id"));
                shifts.setStaff(staff);
                shifts.setShiftDate((resultSet.getDate("shift_date").toLocalDate()));
                shifts.setStartTime((resultSet.getTime("start_time").toLocalTime()));
                shifts.setEndTime((resultSet.getTime("end_time").toLocalTime()));
                shifts.setShiftType(ShiftType.valueOf(resultSet.getString("shift_type")));
                shiftsList.add(shifts);
            }
            return shiftsList;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public Shifts getShiftById(int id) {
        try{
            preparedStatement = connection.prepareStatement("select * from shifts where shift_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               Shifts shifts = new Shifts();
               shifts.setShiftId(resultSet.getInt("shift_id"));
               shifts.setShiftDate((resultSet.getDate("shift_date").toLocalDate()));
               shifts.setStartTime((resultSet.getTime("start_time").toLocalTime()));
               shifts.setEndTime((resultSet.getTime("end_time").toLocalTime()));
               Staff staff = ServiceHelper.staffService.getStaffById(resultSet.getInt("s_id"));
               shifts.setStaff(staff);
               shifts.setShiftType(ShiftType.valueOf(resultSet.getString("shift_type")));
               return shifts;
           }
           else  return null;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteShiftById(int id) {
        try{
            preparedStatement = connection.prepareStatement("delete from shifts where shift_id = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()>0;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Shifts getShiftByStaffAndDate(Staff staff,LocalDate date) {
        try{
            preparedStatement = connection.prepareStatement("select * from shifts where s_id = ? and shift_date = ?");
            preparedStatement.setInt(1, staff.getStaff_id());
            preparedStatement.setDate(2, Date.valueOf(date));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Shifts shifts = new Shifts();
                shifts.setShiftId(resultSet.getInt("shift_id"));
                shifts.setShiftDate((resultSet.getDate("shift_date").toLocalDate()));
                shifts.setStartTime((resultSet.getTime("start_time").toLocalTime()));
                shifts.setEndTime((resultSet.getTime("end_time").toLocalTime()));
                Staff staf = ServiceHelper.staffService.getStaffById(resultSet.getInt("s_id"));
                shifts.setStaff(staf);
                shifts.setShiftType(ShiftType.valueOf(resultSet.getString("shift_type")));
                return shifts;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteShiftByStaff(Staff staff) {
        return false;
    }

    @Override
    public List<Shifts> getAllShiftsByDate(LocalDate date) {
        try{
            List<Shifts> shiftsList = new ArrayList<>();
            preparedStatement = connection.prepareStatement("select * from shifts where shift_date = ?");
            preparedStatement.setDate(1, Date.valueOf(date));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Shifts shifts = new Shifts();
                shifts.setShiftId(resultSet.getInt("shift_id"));
                shifts.setShiftDate((resultSet.getDate("shift_date").toLocalDate()));
                shifts.setStartTime((resultSet.getTime("start_time").toLocalTime()));
                shifts.setEndTime((resultSet.getTime("end_time").toLocalTime()));
                shifts.setShiftType(ShiftType.valueOf(resultSet.getString("shift_type")));
                shifts.setStaff(ServiceHelper.staffService.getStaffById(resultSet.getInt("s_id")));
                shiftsList.add(shifts);
            }
            return shiftsList;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateShiftById(Shifts shifts) {
        try{
            preparedStatement =connection.prepareStatement("update shifts set start_time = ?, end_time = ? ,s_id=?,shift_date=?,shift_type=? where shift_id = ?");
            preparedStatement.setTime(1, Time.valueOf(shifts.getStartTime()));
            preparedStatement.setTime(2, Time.valueOf(shifts.getEndTime()));
            preparedStatement.setInt(3, shifts.getStaff().getStaff_id());
            preparedStatement.setDate(4, Date.valueOf(shifts.getShiftDate()));
            preparedStatement.setString(5,String.valueOf(shifts.getShiftType()));
            preparedStatement.setInt(6, shifts.getShiftId());
            return preparedStatement.executeUpdate()>0;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
