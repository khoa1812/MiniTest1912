package StaffManagement;

public class PartTime extends Staff {
    public int times;

    public PartTime() {
    }

    public PartTime(int id, String name, int age, long phone, String email, int times) {
        super(id, name, age, phone, email);
        this.times = times;
    }


    @Override
    public String toString() {
        return "PartTime{" +
                "times=" + times +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public double total() {
        return times * 100000;
    }
}
