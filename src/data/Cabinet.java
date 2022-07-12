/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.*;

/**
 *
 * @author linh1
 */
public class Cabinet {
   private Scanner sc = new Scanner(System.in);
   private List<Student> arr = new ArrayList();
   
 
    public void addAStudent(){
        String id, name;
        int yob;
        double gpa;
        
        System.out.println("Input the student profile #" + (arr.size() + 1) + "student ");
        while(true){
            System.out.println("Input id: ");
            id = sc.nextLine().trim().toUpperCase();
            Student xxx = searchAStudent(id);
            if(xxx == null)
                break;
            else
                System.out.println("Duplicated id. Try with another one!!!...");
        }
        
        System.out.println("Input name: ");
        name = sc.nextLine().trim().toUpperCase();
        
        System.out.println("Input yob: ");
        yob = Integer.parseInt(sc.nextLine());
        
        System.out.println("Input gpa: ");
        gpa = Double.parseDouble(sc.nextLine());
        
        arr.add(new Student(id, name, yob, gpa));
        System.out.println("Adding successfully");
    }
    
    //PRINT STUDENT LIST
    public void printStudentList(){
        if(arr.isEmpty()){
            System.out.println("The student list is empty");
            return;   // break cai ham luon khi gap thang return
        }
        System.out.println("There is/are " + arr.size() + "student(s)");
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).showProfile();
        }
    }
    
    //SERACH A STUDENT BY USING STUDENT ID
    // 1. phuc vu tinh nang tim 1 sv theo id
    // 2. phuc vu them cho cai viec kiem tra id co trung hay ko khi tao moi
    //ham search co 2 cach tra ve: tra ve vi tri tim thay trong Tui
    // Cach thu hai tra ve toa do cua object
    public Student searchAStudent(String id){
        if(arr.isEmpty())
            return null;
        
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getId().equalsIgnoreCase(id)){
                return arr.get(i);
            }  // Neu thay sv, tra ve cai the thu i tham chieu vung new tim thay
        }
        // di het vong for ma ko thay thi la ko ton tai sv do thoii...
        return null;
    }
    // I make this one version 2 to make it easier to do the removing a student
    public int searchAStudentV2(String id){
        if(arr.isEmpty())
            return -1;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
    
    public void searchAStudent(){
        String keyword;
        System.out.println("Input the id of the student that u want to seearch: ");
        keyword = sc.nextLine();
        Student xxx = searchAStudent(keyword);
        if(xxx == null)
            System.out.println("NOT FOUND");
        else{
            System.out.println("The student is:");
            xxx.showProfile();
        }
   }

    public void updateAStudent(){
        String keyword;
        double newGPA = 0;
        keyword = sc.nextLine();
        System.out.println("Please enter the id of the student that u want to update: ");
        Student xxx = searchAStudent(keyword);
        if(xxx == null)
            System.out.println("Not found. Nothing to update");
        else{
            System.out.println("Found. Here is the the student updating");
            xxx.showProfile();
            System.out.println("Input a new gpa: ");
            newGPA = Double.parseDouble(sc.nextLine());
            xxx.setGpa(newGPA);
           
        }
    }
    
    public void removeAStudent(){
        String keyword;
        System.out.println("Please enter the id of the student that u want to remove: ");
        keyword = sc.nextLine();
        int xxx = searchAStudentV2(keyword);
        if(xxx == -1)
            System.out.println("NOT FOUND. We can not remove a student that we do not have...");
        else{
            System.out.println("FOUND.");
            arr.remove(xxx);
        }
        System.out.println("Removing the student successfully");
    }
}
