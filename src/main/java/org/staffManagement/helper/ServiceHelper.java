package org.staffManagement.helper;

import org.staffManagement.repository.AttendaceRepo;
import org.staffManagement.service.AttendanceService;
import org.staffManagement.service.DeptService;
import org.staffManagement.service.StaffRoleService;
import org.staffManagement.service.serviceImpl.AttendanceServiceImpl;
import org.staffManagement.service.serviceImpl.DeptServiceImpl;
import org.staffManagement.service.serviceImpl.StaffRoleServiceImpl;

public class ServiceHelper {
   public static DeptService deptService = new DeptServiceImpl();
   public static StaffRoleService staffRoleService = new StaffRoleServiceImpl();
    public static AttendanceService attendanceService = new AttendanceServiceImpl();
}
