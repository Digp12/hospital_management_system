package org.staffManagement.repository;

import org.staffManagement.model.Shifts;
import org.staffManagement.model.Staff;

import java.time.LocalDate;
import java.util.List;

public interface ShiftsRepository {
    public boolean assignShifts(Shifts shifts);
    public List<Shifts> getAllShifts();
    public Shifts getShiftById(int id);
    public boolean deleteShiftById(int id);
    public Shifts getShiftByStaffAndDate(Staff staff, LocalDate date);
    public boolean deleteShiftByStaff(Staff staff);
    public List<Shifts> getAllShiftsByDate(LocalDate date);
    public boolean updateShiftById(Shifts shifts);
}
