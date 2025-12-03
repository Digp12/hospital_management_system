package org.staffManagement.clientApp;

import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.*;
import org.staffManagement.service.StaffRoleService;

import java.util.Scanner;

public class StaffClient {

    public void StaffOps(){
        Scanner scanner = new Scanner(System.in);
         do{
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("Welcome To Staff Management Process\n\nEnter Your Choice");
            System.out.println("1. Add New Staff\n2. Update Staff\n3. Delete Staff\n4. Show All Staff\n5. show All Staff By Department \n6.show All Staff By Staff Role \n 7.show All Staff \n 8.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter Staff ID");
                        int staff_id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Department Name");
                        String deptname = scanner.nextLine();

                            Department department = ServiceHelper.deptService.getDeptByName(deptname);
                            if(department == null){
                                System.out.println("Department Not Found...Try Again");
                                continue;
                            }
                        System.out.println("Enter Staff Role");
                        String staffrole = scanner.nextLine();

                        StaffRole staffRole = ServiceHelper.staffRoleService.getStaffRoleByName(staffrole);
                        if(staffRole == null){
                            System.out.println("Staff Role Not Found... Try Again");
                            continue;
                        }

                        System.out.println("Enter Staff Name");
                        String staffname = scanner.nextLine();
                        System.out.println("Enter Staff Gender");
                        Gender staffgender = Gender.valueOf(scanner.nextLine());
                        System.out.println("Enter Staff Email");
                        String staffemail = scanner.nextLine();
                        System.out.println("Enter Staff Phone Number");
                        String staffphonenumber = scanner.nextLine();
                        System.out.println("Enter Staff Address");
                        String address=scanner.nextLine();
                        System.out.println("Enter Staff Status");
                        Status status=Status.valueOf(scanner.nextLine());

                        Staff staff=new Staff();
                        staff.setName(staffname);
                        staff.setGender(staffgender);
                        staff.setEmail(staffemail);
                        staff.setPhone(staffphonenumber);
                        staff.setAddress(address);
                        staff.setStatus(status);
                        staff.setDepartment(department);
                        staff.setStaffRole(staffRole);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:


            }
        }while(true);

    }
}
