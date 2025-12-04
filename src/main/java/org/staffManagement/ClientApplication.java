package org.staffManagement;
import java.util.*;

import org.staffManagement.clientApp.*;
import org.staffManagement.service.AdminLoginService;
import org.staffManagement.service.serviceImpl.AdminLoginServiceImpl;

public class ClientApplication {
	public static void main(String[] args) {
		
		try {
		
		
			Scanner sc = new Scanner(System.in);
			
			System.out.println("==================================================================================================");
			System.out.println("Welcome To Hospital Staff Management ");
			System.out.println("==================================================================================================");
			System.out.println("Enter Your userName : ");
			String userName = sc.nextLine();
			System.out.println("Enter Your Password : ");
			String password = sc.nextLine();
		
			AdminLoginService adminLoginService = new AdminLoginServiceImpl();
		
			boolean isLoginOk = adminLoginService.isLogin(userName,password);
			if(isLoginOk) {
				try (Scanner scanner = new Scanner(System.in)) {
					do {
						System.out.println(
								"----------------------------------------------------------------------------------------------------------");
						System.out.println("Enter Your Choice");
						System.out.println(
								"1. Manage Department\n2. Manage StaffRole\n3. Manage Staff\n4. Manage Attendance\n5. Manage Shifts\n6.Manage Salary\n7. Exit ");
						int choice = scanner.nextInt();

						switch (choice) {
						case 1:
							DeptClient dpClient = new DeptClient();
							dpClient.deptOps();
							break;
						case 2:
                            StaffRoleClient staffroleclient = new StaffRoleClient();
                            staffroleclient.StaffRoleOps();
							break;
						case 3:
                            StaffClient staffclient = new StaffClient();
                            staffclient.StaffOps();
							break;
						case 4:
                            AttendanceClient ac = new AttendanceClient();
                            ac.AttendanceOps();
							break;
						case 5:

							break;
						case 6:
                            SalaryClient salaryClient = new SalaryClient();
                            salaryClient.salaryOps();
							break;
						case 7:
							System.exit(0);

						default:
							System.out.println("You Entered Wrong choice...!");
						}
						System.out.println(
								"----------------------------------------------------------------------------------------------------------");
					} while (true);
				} catch (Exception e) {
					System.out.println("Error is : " + e);
				}
			}else {
				System.out.println("Invalid Credentials...!\nPlease try Again With valid Credentials");
			}
		}catch (Exception e) {
			System.out.println("Error is : "+e);
		}
		
	}
}
