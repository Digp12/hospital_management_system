package org.staffManagement.helper;

import org.staffManagement.repository.AttendaceRepo;
import org.staffManagement.service.*;
import org.staffManagement.service.serviceImpl.*;

public class ServiceHelper {
   public static DeptService deptService = new DeptServiceImpl();
   public static StaffRoleService staffRoleService = new StaffRoleServiceImpl();
    public static AttendanceService attendanceService = new AttendanceServiceImpl();
    public static StaffService staffService = new StaffServiceImpl();
    public static ShiftsService shiftsService = new ShiftsServiceImpl();
    public static SalaryService salaryService = new SalaryServiceImpl();
}
