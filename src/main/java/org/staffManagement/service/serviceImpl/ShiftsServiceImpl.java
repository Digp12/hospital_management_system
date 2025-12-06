package org.staffManagement.service.serviceImpl;

import org.staffManagement.model.Shifts;
import org.staffManagement.model.Staff;
import org.staffManagement.repository.ShiftsRepository;
import org.staffManagement.repository.repoImpl.ShiftsRepositoryImpl;
import org.staffManagement.service.ShiftsService;

import java.time.LocalDate;
import java.util.List;

public class ShiftsServiceImpl implements ShiftsService {

   private ShiftsRepository shiftsRepository=new ShiftsRepositoryImpl();
    @Override
    public boolean assignShifts(Shifts shifts) {
        return shiftsRepository.assignShifts(shifts);
    }

    @Override
    public List<Shifts> getAllShifts() {
        return shiftsRepository.getAllShifts();
    }

    @Override
    public Shifts getShiftById(int id) {
        return shiftsRepository.getShiftById(id);
    }

    @Override
    public boolean deleteShiftById(int id) {
        return shiftsRepository.deleteShiftById(id);
    }

    @Override
    public Shifts getShiftByStaffAndDate(Staff staff, LocalDate date) {
        return shiftsRepository.getShiftByStaffAndDate(staff, date);
    }

    @Override
    public boolean deleteShiftByStaff(Staff staff) {
        return shiftsRepository.deleteShiftByStaff(staff);
    }

    @Override
    public List<Shifts> getAllShiftsByDate(LocalDate date) {
        return shiftsRepository.getAllShiftsByDate(date);
    }

    @Override
    public boolean updateShiftById(Shifts shifts) {
        return shiftsRepository.updateShiftById(shifts);
    }
}
