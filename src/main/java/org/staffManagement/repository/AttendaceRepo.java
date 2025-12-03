package org.staffManagement.repository;

import org.staffManagement.model.Attendance;

import java.util.List;

public interface AttendaceRepo {
    boolean addAttendance(Attendance a);
    boolean updateAttendance(Attendance a);
    boolean deleteAttendance(int id);
    List<Attendance> showAllAttendance();
}
