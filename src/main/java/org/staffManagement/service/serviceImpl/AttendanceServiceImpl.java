package org.staffManagement.service.serviceImpl;

import org.staffManagement.model.Attendance;
import org.staffManagement.repository.AttendaceRepo;
import org.staffManagement.repository.repoImpl.AttendaceRepoImpl;
import org.staffManagement.service.AttendanceService;

import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {

    private AttendaceRepo attendaceRepo = new AttendaceRepoImpl();

    @Override
    public boolean addAttendance(Attendance a) {
        return attendaceRepo.addAttendance(a);
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
