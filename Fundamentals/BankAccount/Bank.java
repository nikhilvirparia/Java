public class Bank {

    private double checkingBalance;
    private double savingsBalance;
    private static int totalAccounts = 0;
    private static double accountBalance;

    public Bank() {};

    public Bank(double checkingBalance, double savingsBalance ) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.totalAccounts++;
        this.accountBalance = checkingBalance + savingsBalance;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setCheckingDeposit(double deposit) {
        checkingBalance += deposit;
        accountBalance += deposit;
    }

    public void setCheckingWithdraw(double withdraw) {
        if(checkingBalance < withdraw) {
            System.out.println("There is no Money");
        } else {
            checkingBalance -= withdraw;
            accountBalance -= withdraw;
        }
    }

    public void setSavingsDeposit (double deposit) {
        savingsBalance += deposit;
        accountBalance += deposit;
    }

    public void setSavingsWithdraw (double withdraw) {
        if(savingsBalance < withdraw) {
            System.out.println("There is no Money");
        } else {
            savingsBalance -= withdraw;
            accountBalance -= withdraw;
        }
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
