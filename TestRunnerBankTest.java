import java.util.ArrayList;

public class TestRunnerBankTest {
    public static void main(String[] args) {
        BankAccount a = new BankAccount();

        ArrayList<Thread> t = new ArrayList<>();
        int NUM_DEPOSITOR = 2;
        int NUM_WITHDRAW = 2;
        int VALUE = 100;
        int ROUND = 10000;
        //สร้างคนฝาก
        for(int i=0 ; i<3 ; i++){
            Thread x = new Thread(new Depositor(a,VALUE,ROUND));
            t.add(x);
        }
         //สร้างคนถอน
        for(int i=0 ; i<3 ; i++){
            Thread x = new Thread(new Withdrawer(a,VALUE,ROUND));
            t.add(x);
        }
        //สั่งทำงาน
        for(Thread thread : t){
            thread.start();
        }
        //ทำงานเสร็จ
        try{
            for(Thread Thread : t){
                Thread.join();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    
        System.out.println("Expect Value :"+((NUM_DEPOSITOR*VALUE*ROUND)-(NUM_WITHDRAW*VALUE*ROUND)));
        System.out.println("Real value : "+a.getbalance());
    }
}
