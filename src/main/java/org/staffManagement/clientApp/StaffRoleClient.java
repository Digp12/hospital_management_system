package org.staffManagement.clientApp;

import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.StaffRole;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class StaffRoleClient {
    public void StaffRoleOps(){
        Scanner scanner=new Scanner(System.in);
       LOOP:
        do {
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Welcome To Staff Role Management Process\n\nEnter Your Choice");
            System.out.println("1. Add Staff Role\n2. Update Staff Role\n3. Delete Staff Role\n4. Show All Staff Roles\n5. Exit ");
            int choice = scanner.nextInt();
            StaffRole staffRole;
            switch (choice) {
                case 1:
                    System.out.println("Enter Staff Role");
                    String staffRoleName = scanner.next();
                    staffRole = new StaffRole();
                    staffRole.setRole(staffRoleName);
                    if (ServiceHelper.staffRoleService.addStaffRole(staffRole)) {
                        System.out.println("Staff Role Added");
                    } else {
                        System.out.println("Staff Role Not Added");
                    }
                    break;
                case 2:
                    List<StaffRole> srlist = ServiceHelper.staffRoleService.getAllStaffRoles();

                    System.out.println("Role Id\t\t\tRole Name");
                    System.out.println("---------------------------------------------------------------------------------");
                    srlist.forEach(x ->{
                        System.out.println("\t"+x.getSr_id()+"\t\t\t"+x.getRole());
                    });
                    System.out.println("\n---------------------------------------------------------------------------------");
                    System.out.println("Enter Role Id to update");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    StaffRole sr = ServiceHelper.staffRoleService.getStaffRoleById(id);
                    System.out.println("You are going to update this record\n");
                    System.out.println("\t"+sr.getSr_id()+"\t\t"+sr.getRole());
                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println("Enter New Role : ");
                    String staffRoleName1 = scanner.next();
                    staffRole = new StaffRole();
                    staffRole.setRole(staffRoleName1);
                    staffRole.setSr_id(id);
                    if (ServiceHelper.staffRoleService.updateStaffRole(staffRole)) {
                        System.out.println("Staff Role Updated");

                    } else {
                        System.out.println("Staff Role Not Updated");
                    }
                    break;
                case 3:
                    System.out.println("Enter Staff Role Id to delete");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (ServiceHelper.staffRoleService.deleteStaffRole(id)) {
                        System.out.println("Staff Role Deleted");
                    } else {
                        System.out.println("Staff Role Not Deleted");
                    }
                    break;
                case 4:
                    List<StaffRole> srlist2 = ServiceHelper.staffRoleService.getAllStaffRoles();

                    System.out.println("Role Id\t\t\tRole Name");
                    System.out.println("---------------------------------------------------------------------------------");
                    srlist2.forEach(x ->{
                        System.out.println("\t"+x.getSr_id()+"\t\t\t"+x.getRole());
                    });
                    break;
                case 5:
                    break LOOP;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }while (true);
    }
}
