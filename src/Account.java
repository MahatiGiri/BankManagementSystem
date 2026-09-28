public class Account {

    private int accno;
    private String name;
    private double balance;
    private String acctype;

    public Account(int accno, String name,
                   double balance, String acctype) {
        this.accno = accno;
        this.name = name;
        this.balance = balance;
        this.acctype = acctype;
    }

    public int getAccno() {
        return accno;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }
}