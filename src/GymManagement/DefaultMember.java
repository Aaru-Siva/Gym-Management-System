package GymManagement;

import java.io.Serializable;
import java.util.Objects;

/*
Object Serialization - an object can be represented as a sequence of bytes
which contains object;s data, object type and the data types of data stored in the object

comparable is used to order the objects of the class(user defined)
*/

public class DefaultMember extends Object implements Serializable,Comparable <DefaultMember>{

    private Integer membershipNumber;
    private String name;                  //Initializing variables
    private String startMembershipDate;
    private String phoneNumber;
    private String memberType;

    //GymManagement.DefaultMember class - Constructor Declaration
    public DefaultMember(Integer membershipNumber, String name, String startMembershipDate, String phoneNumber){
        super();
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.startMembershipDate = startMembershipDate;
    }

   /* adding getters and setters
    getters - This is a method that reads value of a variable
    setters - This ia a method that is used to updates value of a variable */

    public Integer getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(Integer membershipNumber) {
        this.membershipNumber = membershipNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(String startMembershipDate){
        this.startMembershipDate = startMembershipDate;
    }

    //compareTo() method is used to compare the given string with current string
    @Override
    public int compareTo(DefaultMember o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Member{" +
                "membershipNumber=" + membershipNumber +
                ", name='" + name + '\'' +
                ", startMembershipDate='" + startMembershipDate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public DefaultMember(Integer membershipNumber, String name, String startMembershipDate, String phoneNumber, String memberType) {
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.startMembershipDate = startMembershipDate;
        this.phoneNumber = phoneNumber;
        this.memberType = memberType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefaultMember)) return false;
        DefaultMember member = (DefaultMember) o;
        return membershipNumber.equals(member.membershipNumber) &&
                name.equals(member.name) &&
                startMembershipDate.equals(member.startMembershipDate) &&
                phoneNumber.equals(member.phoneNumber) &&
                Objects.equals(memberType, member.memberType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipNumber, name, startMembershipDate, phoneNumber, memberType);
    }
}


