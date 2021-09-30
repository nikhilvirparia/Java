public class BankAccountTest {

    public static void main(String[] args) {
        //create newbankaccount
        Bank newaccount = new Bank (2000, 700);

        // The new account setChecking deposit and withdraw
        newaccount.setCheckingDeposit(100);
        newaccount.setCheckingWithdraw(6000);

        // Get Checking, saving and account Balance
        System.out.println(newaccount.getCheckingBalance());
        System.out.println(newaccount.getSavingsBalance());
        System.out.println(newaccount.getAccountBalance());

    }


}
