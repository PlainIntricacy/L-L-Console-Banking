import java.text.DecimalFormat;

/**
 * Created by Tudor on 9/8/2015.
 *	1 - removed boolean empty
 */
public class Account {

    String name;
    double balance;
    DecimalFormat df = new DecimalFormat("#.##");

    public Account(){
        this.name = "";
        this.balance = 0.0;
    }

    public Account(String x, double y){
        this.name = x;
        this.balance = y;
    }

    public void clearAccount(){
        this.name = "";
        this.balance = 0.0;
    }

    public String giveName(){
        return this.name;
    }

    public String giveBalance(){
        return df.format(this.balance);
    }

    public void giveInfo(){
        System.out.println();
        System.out.println("Account information:");
        System.out.println("Name: " + this.name);
        System.out.println("Balance: $" + this.giveBalance());
        System.out.println();
    }

    public void setName(String q){
        this.name = q;
    }

    public void setBalance(double q){
        this.balance = q;
    }

    public void addInterest(){
        this.balance+=((this.balance/100)*3);
    }

    public void withdraw(double q){
        if(this.balance<q){
            System.out.println("Invalid transaction: not enough funds");
        }else{
            setBalance(this.balance-q);
        }
    }

    public void deposit(double q){
        setBalance(this.balance+q);
    }
}
