package StaffManagement;

public class FullTime extends Staff{
    public double bonus;
    public double forfeit;
    public double salary;

    public FullTime() {
    }

    public FullTime(int id, String name, int age, long phone, String email, double bonus, double forfeit, double salary) {
        super(id, name, age, phone, email);
        this.bonus = bonus;
        this.forfeit = forfeit;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTime{" +
                "bonus=" + bonus +
                ", forfeit=" + forfeit +
                ", salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getForfeit() {
        return forfeit;
    }

    public void setForfeit(double forfeit) {
        this.forfeit = forfeit;
    }

    public double salary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double total() {
        return salary + (bonus - forfeit);
    }



}
