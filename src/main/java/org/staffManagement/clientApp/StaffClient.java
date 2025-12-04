package org.staffManagement.clientApp;

import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.*;
import org.staffManagement.service.StaffRoleService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static com.mysql.cj.util.TimeUtil.DATE_FORMATTER;

public class StaffClient {

    public void StaffOps() {
        Scanner scanner = new Scanner(System.in);
        LOOP:
        do {
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("Welcome To Staff Management Process\n\nEnter Your Choice");
            System.out.println("1. Add New Staff\n2. Update Staff\n3. Delete Staff\n4. Show All Staff\n5. show All Staff By Department \n6.show All Staff By Staff Role \n 7.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter Department Name");
                        String deptname = scanner.nextLine();

                        Department department = ServiceHelper.deptService.getDeptByName(deptname);
                        if (department == null) {
                            System.out.println("Department Not Found...Try Again");
                            continue;
                        }
                        System.out.println("Enter Staff Role");
                        String staffrole = scanner.nextLine();

                        StaffRole staffRole = ServiceHelper.staffRoleService.getStaffRoleByName(staffrole);
                        if (staffRole == null) {
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
                        String address = scanner.nextLine();
                        System.out.println("Enter Staff Status");
                        Status status = Status.valueOf(scanner.nextLine());
                        System.out.print("Please enter a date in the format dd/mm/YYYY :");
                        String date = scanner.nextLine();

                        LocalDate userDate = LocalDate.parse(date,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        Staff staff = new Staff();
                        staff.setName(staffname);
                        staff.setGender(staffgender);
                        staff.setEmail(staffemail);
                        staff.setPhone(staffphonenumber);
                        staff.setAddress(address);
                        staff.setStatus(status);
                        staff.setDepartment(department);
                        staff.setStaffRole(staffRole);
                        staff.setJoinDate(userDate);
                        if (ServiceHelper.staffService.addStaff(staff)) {
                            System.out.println("Staff Added Successfully...");
                        } else {
                            System.out.println("Adding New Staff is Failed...Try Again");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Enter Staff Id to Update");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter Updated Department Name");
                        String deptname = scanner.nextLine();

                        Department department = ServiceHelper.deptService.getDeptByName(deptname);
                        if (department == null) {
                            System.out.println("Department Not Found...Try Again");
                            continue;
                        }
                        System.out.println("Enter Updated Staff Role");
                        String staffrole = scanner.nextLine();

                        StaffRole staffRole = ServiceHelper.staffRoleService.getStaffRoleByName(staffrole);
                        if (staffRole == null) {
                            System.out.println("Staff  Updated Role Not Found... Try Again");
                            continue;
                        }
                        System.out.print("Please enter a date in the format dd/mm/YYYY :");
                        String date = scanner.nextLine();

                        LocalDate userDate = LocalDate.parse(date,  DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.println("Enter Updated Staff Name");
                        String staffname = scanner.nextLine();
                        System.out.println("Enter Updated Staff Gender");
                        Gender staffgender = Gender.valueOf(scanner.nextLine());
                        System.out.println("Enter Updated Staff Email");
                        String staffemail = scanner.nextLine();
                        System.out.println("Enter Updated Staff Phone Number");
                        String staffphonenumber = scanner.nextLine();
                        System.out.println("Enter Updated Staff Address");
                        String address = scanner.nextLine();
                        System.out.println("Enter Updated Staff Status");
                        Status status = Status.valueOf(scanner.nextLine());

                        Staff staff = new Staff(id,staffname,staffgender,staffphonenumber,staffemail,address,userDate,status,department,staffRole);

                        if (ServiceHelper.staffService.updateStaff(staff)) {
                            System.out.println("Staff Updated Successfully...");
                        } else {
                            System.out.println("updating Staff is Failed...Try Again");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter Staff Id to Delete");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        if (ServiceHelper.staffService.deleteStaff(id)) {
                            System.out.println("Staff Deleted Successfully...");
                        } else {
                            System.out.println("Deleting Staff Failed...Try Again");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        List<Staff> staffs = ServiceHelper.staffService.getAllStaff();
                        if (staffs != null) {
                            staffs.forEach(System.out::println);
                        } else {
                            System.out.println("Staff Table is empty...first add somthing");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {

                        System.out.println("Enter Department Name to Find Department wise staff");
                        String deptname = scanner.nextLine();
                        Department department = ServiceHelper.deptService.getDeptByName(deptname);
                        if (department == null) {
                            System.out.println("Department Not Found...Try Again");
                            continue;
                        }
                        List<Staff> staffs = ServiceHelper.staffService.getAllStaffByDepartment(department);
                        if (staffs != null) {
                            staffs.forEach(System.out::println);
                        } else {
                            System.out.println("Staffs are not available in this Deparment...");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Enter Staff Role to Find Role wise Staff");
                        String staffrole = scanner.nextLine();
                        StaffRole staffRole = ServiceHelper.staffRoleService.getStaffRoleByName(staffrole);
                        if (staffRole == null) {
                            System.out.println("Staff  Role Not Found...Try Again");
                            continue;
                        } else {
                            List<Staff> staffs = ServiceHelper.staffService.getAllStaffByRole(staffRole);
                            if (staffs != null) {
                                staffs.forEach(System.out::println);
                            } else {
                                System.out.println("Staff are not available in this Staff Role...");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    break LOOP;
                default:
                    System.out.println("Invalid Input...");
                    break;
            }
        } while (true);
    }
}
