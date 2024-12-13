public class Exercise3 {
    /**
     *
     * @param amount price
     * @param type Account status (NotRegistered = 1, SimpleCustomer = 2, ValuableCustomer = 3, MostValuableCustomer = 4)
     * @param years Time in years that the client is our customer
     * @return THE PRICE
     */
    public double calculate(double amount, int type, int years) {
        double disc = (years > 5) ? 0.05 : years / 100.0;
        double result;

        switch (type) {
            case 1:
                result = amount;
                break;
            case 2:
                result = (amount - 0.1 * amount) * (1 - disc);
                break;
            case 3:
                result = 0.7 * amount * (1 - disc);
                break;
            case 4:
                result = (amount - 0.5 * amount) * (1 - disc);
                break;
            default:
                result = amount;
        }
        return result;
    }
}
