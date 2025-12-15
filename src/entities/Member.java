package entities;

public class Member {

    private int id;
    private String name;
    private boolean admin;

    public Member(int id, String name, boolean admin) {
        this.id = id;
        this.name = name;
        this.admin = admin;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isAdmin() { return admin; }

    public double calculateFee(int overdueDays) {
        return overdueDays <= 0 ? 0 : overdueDays * 2;
    }
}