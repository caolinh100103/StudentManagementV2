/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementv2;

import data.*;
import java.util.*;

/**
 *
 * @author linh1
 */
public class StudentManagementV2 {
    private static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        Cabinet se = new Cabinet();
        int choice = 0;
        do{
            try {  
            System.out.println("1.Adding a student: ");
            System.out.println("2.Printing the list of student: ");
            System.out.println("3.Searching a student: ");
            System.out.println("4.Updating a student: ");
            System.out.println("5.Removing a student: ");
            System.out.println("6.Exit.");
            System.out.println("Please enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please try again...");
            }
            switch(choice){
                case 1:
                    se.addAStudent();
                    break;
                case 2:
                    se.printStudentList();
                    break;
                case 3:
                    se.searchAStudent();
                    break;
                case 4:
                    se.updateAStudent();
                    break;
                case 5:
                    se.removeAStudent();
                    break;
                case 6:
                    System.out.println("Good bye!!!");
                    break;
                default:
                    System.out.println("Please enter again...");
            }
        }while(choice != 6);
    }
    
}
