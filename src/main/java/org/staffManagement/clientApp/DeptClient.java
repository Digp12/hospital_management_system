package org.staffManagement.clientApp;

import java.util.*;

import org.staffManagement.helper.ServiceHelper;
import org.staffManagement.model.Department;
import org.staffManagement.service.DeptService;
import org.staffManagement.service.serviceImpl.DeptServiceImpl;

public class DeptClient {


	Scanner scanner = new Scanner(System.in);
	public void deptOps() {
		try {
			
				System.out.println(
						"----------------------------------------------------------------------------------------------------------");
				System.out.println("Welcome To Department Management Process\n\nEnter Your Choice");
				System.out.println(
						"1. Add Department\n2. Update Department\n3. Delete Department\n4. Show All Departments\n5. Exit ");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					Department d = new Department();
					System.out.println("Enter Department Name :");
					scanner.nextLine();
					String nameString = scanner.nextLine();
					System.out.println("Enter Department Description :");
					String descString = scanner.nextLine();
					d.setName(nameString);
					d.setDescriptin(descString);
					boolean b = ServiceHelper.deptService.addDept(d);
					if(b) {
						System.out.println("Department Added Successfully...");
					}else {
						System.out.println("X-->Department Not Added...");
					}
					break;
				case 2:
                    System.out.println("Enter Department ID which you want to Update :");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Updated Department Name :");
                    String updatedNameString = scanner.nextLine();
                    System.out.println("Enter Updated Department Description :");
                    String updatedDescString = scanner.nextLine();
                    d=new Department();
                    d.setName(updatedNameString);
                    d.setDescriptin(updatedDescString);
                    d.setD_id(id);
                    if(ServiceHelper.deptService.updateDept(d)){
                        System.out.println("Department Updated Successfully...");
                    }
                    else {
                        System.out.println("X-->Department Not found...");
                    }
					break;
				case 3:
                    System.out.println("Enter Department ID which you want to Delete :");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if(ServiceHelper.deptService.deleteDept(id)){
                        System.out.println("Department Deleted Successfully...");
                    }
                    else {
                        System.out.println("X-->Department Not found...");
                    }
                    break;
				case 4:
					   ServiceHelper.deptService.getAllDept().forEach(System.out::println);
					break;
				case 5:
					System.exit(0);

				default:
					System.out.println("You Entered Wrong choice...!");
				}
				System.out.println("----------------------------------------------------------------------------------------------------------");
			
		} catch (Exception e) {
			System.out.println("Error is : " + e);
		}

	}
}
