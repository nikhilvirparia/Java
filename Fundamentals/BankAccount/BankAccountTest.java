public class BankAccountTest {

    public static void main(String[] args) {
        Bank newaccount = new Bank (2000, 700);

        newaccount.setCheckingDeposit(200);
        newaccount.setCheckingWithdraw(3000);


        System.out.println(newaccount.getCheckingBalance());
        System.out.println(newaccount.getSavingsBalance());
        System.out.println(newaccount.getAccountBalance());
    }


}
