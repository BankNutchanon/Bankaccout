public class BankAccount {
     private long balance = 0;

     public  synchronized void deposit(long amount){
            balance += amount;
     }
     public  synchronized void withdraw(long amount){
            if(balance>=amount)
                balance -= amount;
     }
     public long getbalance(){
            return this.balance;
     }
}
