import java.util.ArrayList;

public class CafeUtil {

    // getStreakGoal
    public int getStreakGoal(int weeks) {
        int sum = 0;

        // Sum
        for(int i = 0; i <= weeks; i++) {
            sum = i + sum;
        }
        return sum;
        // another way to do it
        // return weeks * (weeks + 1) / 2;
    }

    // printPriceChart
    public void printPriceChart(String productName, double price, int maxNumber) {

        System.out.println(productName);
        // It will print 1 - $15.00 example
        for(int i = 1; i <= maxNumber; i++) {
            System.out.println(i + " - $" + i * price);
        }
        return;

    }

    // GetOrderTotal
    public double getOrderTotal(double[] lineItems) {
        double sum = 0.00;
        for ( double item : lineItems ) {
            sum = sum + item;

        }
        return sum;
    }

    // DisplayMenu
    public void displayMenu(ArrayList<String> menu, ArrayList<Double> prices) {
        // It will print
        for(int i = 0; i < menu.size(); i++) {
            System.out.println(i + " " + menu.get(i) + " -- $" + prices.get(i));
        }
        return;
    }

    // AddCustomer
    public void addCustomer(ArrayList<String> customerList) {

        System.out.println("What is your name?");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");

        System.out.println("Number of people " + customerList.size());
        customerList.add(userName);
        return;

    }

}
