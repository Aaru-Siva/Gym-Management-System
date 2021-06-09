package GymManagement;

import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Implements is used to implement a Interface
public class MyGymManager implements GymManager{

    private ArrayList<DefaultMember> memberList = new ArrayList<DefaultMember>();
/* Array - These are used to store multiple values in a single variable
    List - It provides a way to store the ordered collection */

    //adding a member
    @Override
    public void addMember(DefaultMember member) {
        if (memberList.size() < 100){
            memberList.add(member);
            System.out.println("Number of used slots: "+ memberList.size());
            System.out.println("Number of free slots: "+(100-memberList.size()));
        }else {
            System.out.println("There is no free slots to add members");
        }
    }

    @Override      //deleting a member
    public boolean deleteMember(Integer membershipNumber) {
        boolean flag = false;
        for (DefaultMember member: memberList) {
            if(member.getMembershipNumber().equals(membershipNumber)) {
                flag = true;
                memberList.remove(member);
                System.out.println("Member belongs to " + membershipNumber + " has been removed");
                System.out.println("Number of used space: " + memberList.size());
                System.out.println("Number of free space: " + (100 - memberList.size()));
                if (member instanceof StudentMember) {
                    System.out.println("Member type is : StudentMember");
                } else if (member instanceof Over60Member) {
                    System.out.println("Member type is : Over60Member");
                } else {
                    System.out.println("Member type is : DefaultMember");
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("can not found");
        }
        return flag;
    }

    @Override   //printing
    public void print() {
        if (memberList.size() == 0 ){
            System.out.println("Empty list\n");
        }else{
            for(DefaultMember member: memberList){

                System.out.println("Membership No: "+member.getMembershipNumber()+" ");
                System.out.println("Name is " +member.getName()+" ");
                System.out.println("Membership start date is: " + member.getStartMembershipDate());

                if (member instanceof StudentMember){
                    String schoolName = ((StudentMember) member).getSchoolName();
                    System.out.println("Membership type is StudentMember");
                    System.out.println("school Name is "  + schoolName);

                } else if (member instanceof Over60Member) {
                    int age = ((Over60Member) member).getAge();
                    System.out.println("Member type is Over60Member");
                    System.out.println("Age is " + age);

                } else {
                    System.out.println("Member type is DefaultMember");
                }
                System.out.println("");
            }
        }
    }

    @Override   //sorting member list
    public List<DefaultMember> sort() {

        //arralist for get member names
        ArrayList<String> arrayList = new ArrayList<>();

        //add names to the arraylist
        for (int i=0 ; i<memberList.size(); i++){
            String name = memberList.get(i).getName();
            arrayList.add(name);
        }

        //array to store member names
        String [] array = arrayList.toArray(new String[] {});

        //sorting names in ascending order
        Sort.bubSort(array,true);

        //convert array to list
        List<String> sortList = Arrays.asList(array);

        //match member names with object
        for (String element : sortList){
            for (DefaultMember o : memberList){
                if (element.equals(o.getName())){
                    System.out.println(o.toString());
                }
            }
        }

        return memberList;
    }

    //Override is used to indicate that the subclass is replacing inherited behavior

    @Override   //storing data
    public void save() {
        DefaultMember[] save = memberList.toArray(new DefaultMember[]{});
        File file = new File("Store.txt");
        BufferedWriter fileOut;

        /* FileWriter - This is used to write character oriented data to a file
        BufferedWriter - This is used to write a stream of characters to the specified destinations */

        try (FileWriter filw = new FileWriter(file)) {
            fileOut = new BufferedWriter(filw);

            /*  flush() method is used to flush the content of the buffer to the output stream
             *  newLine() method is used to separate the next line as a new line */

            int q = memberList.size();
            for (int a = 0; a < memberList.size(); a++) {
                String schoolName;
                int age;

                if (memberList.get(a) instanceof StudentMember) {
                    schoolName = ((StudentMember) memberList.get(a)).getSchoolName();
                    fileOut.write(
                            " Membership Number : " + memberList.get(a).getMembershipNumber()
                                    + " Name : " + memberList.get(a).getName()
                                    + " startMembershipDate : " + memberList.get(a).getStartMembershipDate()
                                    + " phoneNumber : " + memberList.get(a).getPhoneNumber()
                                    + " schoolName : " + ((StudentMember) memberList.get(a)).getSchoolName()
                    );

                } else if (memberList.get(a) instanceof Over60Member) {
                    age = ((Over60Member) memberList.get(a)).getAge();
                    fileOut.write(
                            " Membership Number : " + memberList.get(a).getMembershipNumber()
                                    + " Name : " + memberList.get(a).getName()
                                    + " startMembershipDate : " + memberList.get(a).getStartMembershipDate()
                                    + " phoneNumber : " + memberList.get(a).getPhoneNumber()
                                    + " Age : " + ((Over60Member) memberList.get(a)).getAge()
                    );

                } else {
                    fileOut.write(
                            " Membership Number : " + memberList.get(a).getMembershipNumber()
                                    + " Name : " + memberList.get(a).getName()
                                    + " startMembershipDate : " + memberList.get(a).getStartMembershipDate()
                                    + " phoneNumber : " + memberList.get(a).getPhoneNumber());
                }


                System.out.println("saved successfully");

                fileOut.flush();
                fileOut.newLine();
            }

        } catch (IOException e) {
            System.out.println("No data to save");
        }
    }

    //this is for add member details into a file for tableview purpose
    public void saveForSearch() {
        DefaultMember[] save = memberList.toArray(new DefaultMember[]{});
        File file = new File("saveForSearch.txt");
        BufferedWriter fileOut;

        /* FileWriter - This is used to write character oriented data to a file
        BufferedWriter - This is used to write a stream of characters to the specified destinations */

        try (FileWriter filw = new FileWriter(file)) {
            fileOut = new BufferedWriter(filw);

            /*  flush() method is used to flush the content of the buffer to the output stream
             *  newLine() method is used to separate the next line as a new line */

            int q = memberList.size();
            for (int a = 0; a < memberList.size(); a++) {
                String schoolName;
                int age;

                if (memberList.get(a) instanceof StudentMember){
                    schoolName = ((StudentMember) memberList.get(a)).getSchoolName();
                    fileOut.write(
                            memberList.get(a).getMembershipNumber()
                                    + " " + memberList.get(a).getName()
                                    +" " + memberList.get(a).getStartMembershipDate()
                                    +" " + memberList.get(a).getPhoneNumber()
                                    +" " + ((StudentMember) memberList.get(a)).getSchoolName()
                                    +" 0"
                                    +" student");

                } else if (memberList.get(a) instanceof Over60Member) {
                    age = ((Over60Member) memberList.get(a)).getAge();
                    fileOut.write(
                            memberList.get(a).getMembershipNumber()
                                    + " " + memberList.get(a).getName()
                                    +" " + memberList.get(a).getStartMembershipDate()
                                    +" " + memberList.get(a).getPhoneNumber()
                                    +" null"
                                    +" " + ((Over60Member) memberList.get(a)).getAge()
                                    +" over60");

                } else {
                    fileOut.write(
                            memberList.get(a).getMembershipNumber()
                                    + " " + memberList.get(a).getName()
                                    +" " + memberList.get(a).getStartMembershipDate()
                                    +" " + memberList.get(a).getPhoneNumber()
                                    +" null 0 default");
                }

                System.out.println("saved successfully");

                fileOut.flush();
                fileOut.newLine();
            }

        } catch (IOException e) {
            System.out.println("No data to save");
        }
    }

    //searching member details
    public static <T> int searchRecord(T[] array, T searchValue){
        for (int i = 0; i<array.length;i++){
            if (array[i].equals(searchValue)){
                return i;
            }
        }return -1;
    }

    @Override
    public void search(String searchValue, Label lbl) {
        DefaultMember[] members = memberList.toArray(new DefaultMember[]{});
        ArrayList<DefaultMember> arrayList = new ArrayList<>();
        File file = new File("saveForSearch.txt");
        try {
            Scanner scanner =  new Scanner(file);


            while (scanner.hasNext()){
                int memberId = scanner.nextInt();
                String name = scanner.next();
                String date = scanner.next();
                String contact = scanner.next();
                String school = scanner.next();
                int memberAge = scanner.nextInt();
                String memberType = scanner.next();

                DefaultMember member = null;
                //inserting data into the table
                if (memberType.equals("student")){
                    member = new StudentMember(memberId, name, date, contact, memberType,school);

                } else if (memberType.equals("over60")) {
                    member = new Over60Member(memberId, name, date, contact,memberType, memberAge);

                }else {
                    member = new DefaultMember(memberId, name, date, contact,memberType);
                }
                arrayList.add(member);
            }


            String memName ;
            int id;

            for (DefaultMember member : arrayList){
                System.out.println(member.toString());
                if (searchValue.equals(member.getName()) || searchValue == String.valueOf(member.getMembershipNumber())){
                    lbl.setText(member.toString());
                    break;
                }else {
                    lbl.setText("not found");
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
