package org.staffManagement.clientApp;

import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.Attendance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AttendanceClient {

    Scanner sc = new Scanner(System.in);


    public void AttendanceOps(){

        System.out.println("=======================================================================");
        System.out.println("Welcome....\n Here you can manage staff Attendance");
        System.out.println("1. Add Attendance\n2. Update Attendance\n3. Delete Attendance\n4. Show All Attendance");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("Enter staff id");
                int sid = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter date (yyyy-mm-dd):");
                LocalDate date = LocalDate.parse(sc.nextLine());
                System.out.println("Enter In time (HH:mm):");
                LocalTime inTime = LocalTime.parse(sc.nextLine());
                System.out.println("Enter Out time (HH:mm):");
                LocalTime outTime = LocalTime.parse(sc.nextLine());
                boolean b = ServiceHelper.attendanceService.addAttendance(new Attendance(0,sid,date,inTime,outTime,"present"));
                System.out.println(b?"Attendance Recorded Successfully...":"Attendance Not Recorded Something went Wrong...");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
