package GymManagement;

public class StudentMember extends DefaultMember{

    private String schoolName;      //Initializing variables


    //Student class - Constructor Declaration
    public StudentMember(Integer membershipNumber, String name, String startMembershipDate, String phoneNumber, String schoolName) {
        super(membershipNumber, name, startMembershipDate, phoneNumber);
        this.schoolName = schoolName;
    }

    public StudentMember(Integer membershipNumber, String name, String startMembershipDate, String phoneNumber, String memberType, String schoolName) {
        super(membershipNumber, name, startMembershipDate, phoneNumber, memberType);
        this.schoolName = schoolName;
    }

    /* adding getters and setters
    getters - This is a method that reads value of a variable
    setters - This ia a method that is used to updates value of a variable */

    public String getSchoolName() {
        return schoolName;
    } //getters

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    } //setters


}
