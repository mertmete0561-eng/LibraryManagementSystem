package entities;

public class StudentMember extends Member {

    public StudentMember(int id, String name) {
        super(id, name, false);
    }

    @Override
    public double calculateFee(int overdueDays) {
        return super.calculateFee(overdueDays) * 0.5;
    }
}