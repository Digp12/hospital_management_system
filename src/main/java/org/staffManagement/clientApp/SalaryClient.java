package org.staffManagement.clientApp;

import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.Salary;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class SalaryClient {

    public void salaryOps() {
        Scanner sc = new Scanner(System.in);
        LOOP:
        do {
            System.out.println("=========================================================================================");
            System.out.println("Welcome to Salary Management");
            System.out.println("Here You can manage your salary");
            System.out.println("=========================================================================================");
            System.out.println("1. Add Salary\n2. Update Salary\n3. Delete Salary\n4. Show Salary\n5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Staff id :");
                    int staffId = sc.nextInt();
                    System.out.println("Enter Basic Salary :");
                    int bSal = sc.nextInt();
                    System.out.println("Enter Home Rental Allowance :");
                    int hra = sc.nextInt();
                    System.out.println("Enter D Allowance :");
                    int da = sc.nextInt();
                    System.out.println("Enter PF amount :");
                    int pf = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Month Year (YYYY-MM)");
                    YearMonth monthYear = YearMonth.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM"));

                    int countHolidays = ServiceHelper.salaryService.findHolidayReduction(staffId);
                    int perDaySalary = bSal / 30;
                    int netSalary = bSal + ((hra + da) - pf) - (perDaySalary * countHolidays);

                    boolean isInsertSalary = ServiceHelper.salaryService.addSalary(new Salary(0, staffId, bSal, hra, da, pf, monthYear, netSalary));
                    System.out.println(isInsertSalary ? "Record Insert Successfully" : "Something Went Wrong...");
                    break;
                case 2:
                    List<Salary> salList = ServiceHelper.salaryService.viewSalary();
                    System.out.println("Salary Id\tStaff Id\tBasic Salary\tH.R.A\tD.A\t\tP.F\t\tMonth\t\tNetSalary");
                    System.out.println("---------------------------------------------------------------------------------------------");
                    for (Salary sal : salList) {
                        System.out.println("\t"+sal.getSalary_id() + "\t\t\t" + sal.getStaff_id() + "\t\t\t" + sal.getBasic_salary() + "\t\t" + sal.getHra() + "\t" + sal.getDa() + "\t" + sal.getPf() + "\t" + sal.getMonth_year() + "\t\t" + sal.getNet_salary());
                    }
                    System.out.println("\nNow Enter Salary Id which you want to Update...");
                    int sal_id = sc.nextInt();
                    Salary salary = ServiceHelper.salaryService.getSalaryById(sal_id);
                    System.out.println(salary.getSalary_id() + "\t" + salary.getStaff_id() + "\t" + salary.getBasic_salary() + "\t" + salary.getHra() + "\t" + salary.getDa() + "\t" + salary.getPf() + "\t" + salary.getMonth_year() + "\t" + salary.getNet_salary());
                    System.out.println("Enter Staff id :");
                    int staffId2 = sc.nextInt();
                    System.out.println("Enter Basic Salary :");
                    int bSal2 = sc.nextInt();
                    System.out.println("Enter Home Rental Allowance :");
                    int hra2 = sc.nextInt();
                    System.out.println("Enter D Allowance :");
                    int da2 = sc.nextInt();
                    System.out.println("Enter PF amount :");
                    int pf2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Month Year (YYYY-MM)");
                    YearMonth monthYear2 = YearMonth.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM"));
                    int countHolidays2 = ServiceHelper.salaryService.findHolidayReduction(staffId2);
                    int perDaySalary2 = bSal2 / 30;
                    int netSalary2 = bSal2 + ((hra2 + da2) - pf2) - (perDaySalary2 * countHolidays2);

                    boolean isInsertSalary2 = ServiceHelper.salaryService.updateSalary(new Salary(sal_id, staffId2, bSal2, hra2, da2, pf2, monthYear2, netSalary2));
                    System.out.println(isInsertSalary2 ? "Record update Successfully" : "Something Went Wrong...");
                    break;
                case 3:
                    System.out.println("Enter Salary Id which you want to delete : ");
                    int salId = sc.nextInt();
                    boolean isDelete = ServiceHelper.salaryService.deleteSalary(salId);
                    System.out.println(isDelete ? "Salary deleted successfully" : " Something Went wrong....!");
                    break;
                case 4:
                    List<Salary> salList2 = ServiceHelper.salaryService.viewSalary();
                    System.out.println("Salary Id\tStaff Id\tBasic Salary\tH.R.A\tD.A\t\tP.F\t\tMonth\t\tNetSalary");
                    System.out.println("---------------------------------------------------------------------------------------------");
                    for (Salary sal : salList2) {
                        System.out.println("\t"+sal.getSalary_id() + "\t\t\t" + sal.getStaff_id() + "\t\t\t" + sal.getBasic_salary() + "\t\t" + sal.getHra() + "\t" + sal.getDa() + "\t" + sal.getPf() + "\t" + sal.getMonth_year() + "\t\t" + sal.getNet_salary());
                    }
                    break;
                case 5:
                    break LOOP;
                default:
                    System.out.println("You Enter Wrong choice...");
                    break;
            }
        } while (true);
    }
}
