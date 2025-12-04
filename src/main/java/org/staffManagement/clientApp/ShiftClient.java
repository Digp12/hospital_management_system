package org.staffManagement.clientApp;

import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.ShiftType;
import org.staffManagement.model.Shifts;
import org.staffManagement.model.Staff;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ShiftClient {
    Scanner scanner = new Scanner(System.in);

    public void shiftOps() {
        LOOP:
        do {
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("Welcome To Shifts Management Process\n\nEnter Your Choice");
            System.out.println("1. Assign Staff To Shifts\n2. Update Shift\n3. Delete shift\n4. Show All Assigned shifts \n5.show DateWise Shifts \n7.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter Staff Name to Assign to shift");
                        String staffName = scanner.nextLine();

                        Staff staff = ServiceHelper.staffService.getStaffByName(staffName);
                        if (staff == null) {
                            System.out.println("Staff Not Found...Try Again");
                            continue;
                        }
                        System.out.println("Enter Shift Date ");
                        String shiftDate = scanner.nextLine();
                        LocalDate date = LocalDate.parse(shiftDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        if (!date.isAfter(LocalDate.now()) && date.isEqual(LocalDate.now())) {
                            System.out.println("Please Enter Upcoming Date...Try Again");
                            continue;
                        }

                        System.out.println("Enter Shift Type");
                        String shiftType = scanner.nextLine();

                        Shifts shift1 = new Shifts();
                        shift1.setStaff(staff);
                        shift1.setShiftDate(date);
                        shift1.setShiftType(ShiftType.valueOf(shiftType));
                        shift1.setStartTime(AssignStartTime(shiftType));
                        shift1.setEndTime(AssignEndTime(shiftType));
                        Shifts shift2 = ServiceHelper.shiftsRepository.getShiftByStaffAndDate(staff, date);
                        if (shift2 != null) {
                            if (shift1.getShiftDate().isEqual(shift2.getShiftDate())) {
                                System.out.println(staffName + " has been already assigned to That Day");
                            } else {
                                ServiceHelper.shiftsRepository.assignShifts(shift1);
                                System.out.println(staffName + " has been assigned to That Day");

                            }
                        } else {
                            ServiceHelper.shiftsRepository.assignShifts(shift1);
                            System.out.println(staffName + " has been assigned to That Day");

                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    try {
                        System.out.println("Enter Shift id To Update");
                        int id = scanner.nextInt();
                        scanner.nextLine();


                        System.out.println("Enter Updated Staff Name to Assign to shift");
                        String staffName = scanner.nextLine();

                        Staff staff = ServiceHelper.staffService.getStaffByName(staffName);
                        if (staff == null) {
                            System.out.println("Staff Not Found...Try Again");
                            continue;
                        }
                        System.out.println("Enter Updated Shift Date ");
                        String shiftDate = scanner.nextLine();
                        LocalDate date = LocalDate.parse(shiftDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        if (!date.isAfter(LocalDate.now()) && date.isEqual(LocalDate.now())) {
                            System.out.println("Please Enter Upcoming Date...Try Again");
                            continue;
                        }

                        System.out.println("Enter Updated  Shift Type");
                        String shiftType = scanner.nextLine();

                        Shifts shift1 = new Shifts();
                        shift1.setStaff(staff);
                        shift1.setShiftId(id);
                        shift1.setShiftDate(date);
                        shift1.setShiftType(ShiftType.valueOf(shiftType));
                        shift1.setStartTime(AssignStartTime(shiftType));
                        shift1.setEndTime(AssignEndTime(shiftType));
                        Shifts shift2 = ServiceHelper.shiftsRepository.getShiftByStaffAndDate(staff, date);
                        if (shift2 != null) {
                            if (shift1.getShiftDate().isEqual(shift2.getShiftDate())) {
                                System.out.println(staffName + " has been already assigned to That Day");
                            } else {
                                ServiceHelper.shiftsRepository.updateShiftById(shift1);
                                System.out.println(staffName + " has been Updated to That Day");
                            }
                        } else {
                            ServiceHelper.shiftsRepository.updateShiftById(shift1);
                            System.out.println(staffName + " has been Updated to That Day");
                        }

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter Shift id To Delete");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        if(ServiceHelper.shiftsRepository.deleteShiftById(id)){
                            System.out.println("Shift Deleted Successfully");
                        }
                        else{
                            System.out.println("Shift Not Found...Try Again");
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        List<Shifts> shifts = ServiceHelper.shiftsRepository.getAllShifts();

                        for (Shifts shift : shifts) {
                            System.out.println(shift.getShiftId()+"\t"+shift.getShiftDate()+"\t"+shift.getShiftType()
                                    +"\t"+shift.getStartTime()+"\t"+shift.getEndTime()+"\t"+shift.getStaff().getStaff_id()+"\t"+shift.getStaff().getName());
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try{
                        System.out.println("Enter Date to fetch all shifts of tht date");
                        String date = scanner.nextLine();
                        LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                       List<Shifts> shifts= ServiceHelper.shiftsRepository.getAllShiftsByDate(date1);
                        for (Shifts shift : shifts) {
                            System.out.println(shift.getShiftId()+"\t"+shift.getShiftDate()+"\t"+shift.getShiftType()
                                    +"\t"+shift.getStartTime()+"\t"+shift.getEndTime()+"\t"+shift.getStaff().getStaff_id()+"\t"+shift.getStaff().getName());
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    break LOOP;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (true);
    }

    public LocalTime AssignStartTime(String shiftType) {
        if (shiftType.equalsIgnoreCase("Morning")) {
            return LocalTime.parse("08:00");
        } else if (shiftType.equalsIgnoreCase("Evening")) {
            return LocalTime.parse("04:00");
        } else if (shiftType.equalsIgnoreCase("Night")) {
            return LocalTime.parse("00:00");
        }
        return null;
    }

    LocalTime AssignEndTime(String shiftType) {
        if (shiftType.equalsIgnoreCase("Morning")) {
            return LocalTime.parse("04:00");

        } else if (shiftType.equalsIgnoreCase("Evening")) {
            return LocalTime.parse("00:00");

        } else if (shiftType.equalsIgnoreCase("Night")) {
            return LocalTime.parse("08:00");
        }
        return null;
    }

}

