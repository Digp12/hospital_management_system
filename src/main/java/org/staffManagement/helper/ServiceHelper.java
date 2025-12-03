package org.staffManagement.helper;

import org.staffManagement.service.DeptService;
import org.staffManagement.service.serviceImpl.DeptServiceImpl;

public class ServiceHelper {
   public static DeptService deptService = new DeptServiceImpl();
}
