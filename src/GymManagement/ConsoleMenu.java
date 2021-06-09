package GymManagement;

import javafx.application.Application;

import java.util.Scanner;

public class ConsoleMenu {

    private static MyGymManager manager = new MyGymManager();
    private static int count = 1;

    public static void main(String[] args) {

        //Creating a new scanner object
        Scanner input = new Scanner(System.in);
        int count;
        for (count = 0; count <= 100; count++) {    //Limiting the maximum number upto 100

            System.out.println("\n--------------------Welcome to gym management system-------------------");
            System.out.println("A for Add (insert) member"); //Adding member
            System.out.println("D for Delete member"); //deleting member
            System.out.println("P for Print list of members"); //listing members
            System.out.println("L for Sort members");  //sorting members
            System.out.println("S for Save members");  //storing member details
            System.out.println("V for viewing members"); //viewing members
            System.out.println("Q for Quiting members");   //by clicking this user can quit the program

            System.out.print("\nEnter your choice : ");
            String choice = input.next();
            System.out.println("");

            /*switch statement allows a variable to be tested for equality against a list of value */
            switch (choice) {
                case ("A"):                //case 1
                case ("a"):
                    insertMember();
                    break;
                case ("D"):                //case 2
                case ("d"):
                    deleteMember();
                    break;
                case ("P"):                //case 3
                case ("p"):
                    manager.print();
                    break;
                case ("L"):                //case 4
                case ("l"):
                    manager.sort();
                    break;
                case ("S"):                //case 5
                case ("s"):
                    manager.save();
                    break;
                case ("Q"):                //case 6
                case ("q"):
                    System.out.println("Programming ended!");
                    System.exit(0);
                    break;
                case ("V"):                //case 7
                case ("v"):
                    manager.saveForSearch();
                    Application.launch(Table.class,args);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    //Delete member
    private static void deleteMember() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter membership number: ");
        Integer membershipNumber = input.nextInt();
        boolean result = manager.deleteMember(membershipNumber);
        if (result) {
            count--;
        }
    }

    //inserting member (adding member)
    private static void insertMember() {
        Scanner input = new Scanner(System.in);
        if (count < 100) {
            int membershipNumber = count;

            System.out.println("Enter membership number: " + membershipNumber);
            System.out.print("Enter the name: ");

            String name = input.nextLine();
            while (!name.matches("[a-zA-Z]+")){
                System.out.println("Invalid Input! Enter correct Input");
                System.out.print("Enter the name: ");
                name = input.next();
            }

            System.out.print("Enter the date in the following format DD/MM/YYYY: ");
            String membershipStartDate = input.nextLine();


            System.out.print("Enter your phone number: ");
            String phoneNumber = input.nextLine();
            while (!phoneNumber.matches("[0-9]{10}$+")){
                System.out.println("Invalid Phone number!");
                System.out.print("Enter your phone number: ");
                phoneNumber = input.nextLine();
            }
            System.out.print("Enter the type of membership (D-Default member S-Student member O-Over60 member)");
            String type = input.nextLine();
            while (!(type.toLowerCase().equals("d")||type.toLowerCase().equals("s")||type.toLowerCase().equals("o"))){
                System.out.println("Wrong type! please enter the correct type");
                System.out.print("Enter the type of membership (D-Default member S-Student member O-Over60 member) : ");
                type = input.nextLine();
            }
            DefaultMember member = null;

            switch (type) {
                case "D":
                case "d":   //setting both lower and upper case for switch
                    member = new DefaultMember(membershipNumber, name, membershipStartDate, phoneNumber);
                    break;
                case "S":
                case "s":
                    System.out.print("School Name: ");
                    String schoolName = input.next();
                    while (!schoolName.matches("[a-zA-Z]+")){
                        System.out.println("Invalid Input! Enter correct Input");
                        System.out.println("School Name: ");
                        schoolName = input.nextLine();
                    }
                    member = new StudentMember(membershipNumber, name, membershipStartDate, phoneNumber,schoolName);
                    break;
                case "O":
                case "o":
                    System.out.print("Age: ");
                    int age = input.nextInt();
                    while(!(age>=60 && age<100)){
                        System.out.println("Please enter a valid age!");
                        System.out.print("Age: ");
                        age = input.nextInt();
                    }
                    member = new Over60Member(membershipNumber, name, membershipStartDate, phoneNumber, age);
                    break;
                default:
                    System.out.println("Invalid input");
            }
            manager.addMember(member);
            count++;
        } else {
            System.out.println("no free space! membership has achieved the maximum level");
        }
    }
}
