public class Bank {

    // Create private variables for checking, saving, total accounts, and account balance
    private double checkingBalance;
    private double savingsBalance;
    private static int totalAccounts = 0;
    private static double accountBalance;

    // Create an empty method
    public Bank() {};

    // Create Bank method with checking and saving balance
    public Bank(double checkingBalance, double savingsBalance ) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.totalAccounts++;
        this.accountBalance = checkingBalance + savingsBalance;
    }

    // GetcheckingBalance
    public double getCheckingBalance() {
        return checkingBalance;
    }

    // SetChecking for the deposit
    public void setCheckingDeposit(double deposit) {
        checkingBalance += deposit;
        accountBalance += deposit;
    }

    // SetChecking Withdraw method
    public void setCheckingWithdraw(double withdraw) {
        if(checkingBalance < withdraw) {
            System.out.println("There is no Money");
        } else {
            checkingBalance -= withdraw;
            accountBalance -= withdraw;
        }
    }

    // GetSavingsBalance
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // setSaving Deposit method
    public void setSavingsDeposit (double deposit) {
        savingsBalance += deposit;
        accountBalance += deposit;
    }

    //setSavingsWithdraw method
    public void setSavingsWithdraw (double withdraw) {
        if(savingsBalance < withdraw) {
            System.out.println("There is no Money");
        } else {
            savingsBalance -= withdraw;
            accountBalance -= withdraw;
        }
    }

    // getAccountBalance
    public double getAccountBalance() {
        return accountBalance;
    }

}
