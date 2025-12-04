package org.staffManagement.clientApp;

import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.Attendance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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
                System.out.println("Enter attendance id for update record ");
                int a_id2 = sc.nextInt();
                Attendance adt = ServiceHelper.attendanceService.getAttendanceById(a_id2);
                System.out.println(adt.getId()+"\t"+adt.getStaff_id()+"\t"+adt.getDate()+"\t"+adt.getIn_time()+"\t"+adt.getOut_time()+"\t"+adt.getStatus());

                System.out.println("Update field where you want to update...");
                System.out.println("Enter staff id");
                sid = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter date (yyyy-mm-dd):");
                date = LocalDate.parse(sc.nextLine());
                System.out.println("Enter In time (HH:mm):");
                inTime = LocalTime.parse(sc.nextLine());
                System.out.println("Enter Out time (HH:mm):");
                outTime = LocalTime.parse(sc.nextLine());

                System.out.println("Enter Status :");
                String status = sc.nextLine();

                System.out.println(sid+" "+date+" "+inTime+" "+outTime+" "+date);
                b = ServiceHelper.attendanceService.updateAttendance(new Attendance(a_id2,sid,date,inTime,outTime,status));
                System.out.println("Value of b "+b);
                System.out.println(b ? "Attendance update Successfully..." : "Attendance Not updated Something went Wrong...");
                break;
            case 3:
                System.out.println("Enter Id of attendance to delete record : ");
                int a_id = sc.nextInt();
                b = ServiceHelper.attendanceService.deleteAttendance(a_id);
                System.out.println(b ? "Record deleted...":"something went wrong...");
                break;
            case 4:
                List<Attendance> list = ServiceHelper.attendanceService.showAllAttendance();
                for (Attendance at : list){
                    System.out.println(at.getId()+"\t"+at.getStaff_id()+"\t"+at.getDate()+"\t"+at.getIn_time()+"\t"+at.getOut_time()+"\t"+at.getStatus());
                }
                break;
        }
    }
}
