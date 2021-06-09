package GymManagement;

public class Over60Member extends DefaultMember {

    private int age;

    //Over60Members class - Constructor Declaration
    public Over60Member(Integer membershipNumber, String name, String startMembershipDate, String phoneNumber, int age) {
        super(membershipNumber, name, startMembershipDate, phoneNumber);
        setAge(age);
    }

    public Over60Member(Integer membershipNumber, String name, String startMembershipDate, String phoneNumber, String memberType, int age) {
        super(membershipNumber, name, startMembershipDate, phoneNumber, memberType);
        this.age = age;
    }

    //getters setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 60) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid Age");
        }
    }


}
