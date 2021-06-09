package GymManagement;

public class Date extends DefaultMember{
    private int month;
    private int day;
    private int year;


    public Date(int membershipNumber, String name,  String startMembershipDate, String phoneNumber,int month, int day, int year) {
        super(membershipNumber, name,  startMembershipDate, phoneNumber);
        this.month = month;
        this.day = day;
        this.year = year;
    }
//getters and setters
    public int getMonth(int month){
        return month;
    }

    public int setMonth(int testMon){
        if (testMon>0 && testMon<=12)
            return testMon;
        else{
            System.out.printf("Invalid month (%d)set to 1.",testMon);
            return 1;
        }
    }

    public int getDay(int testDay){
        return day;
    }

    public int setDay(int testDay) {
        int daysPerMonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};   //Days
        if (testDay > 0 && testDay <= daysPerMonth[month])
            return testDay;
        if (month == 2 && testDay == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) //month
            return testDay;
        System.out.printf("Invalid day (%d)set to 1.",testDay);
        return 1;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }


    public String toString(){
        return String.format("%d%d%d",month,day,year);
    }
}