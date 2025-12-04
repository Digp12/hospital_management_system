package org.staffManagement.service;

import org.staffManagement.model.Attendance;

import java.util.List;

public interface AttendanceService {
    boolean addAttendance(Attendance a);
    boolean updateAttendance(Attendance a);
    boolean deleteAttendance(int id);
    List<Attendance> showAllAttendance();
    Attendance getAttendanceById(int id);
}
