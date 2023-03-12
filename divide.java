public class AddStrings {
    public static void main(String[] args) {
        String num1 = "12345678901234567890";
        String num2 = "98765432109876543210";
        System.out.println(divide(num1, num2));
    }
    public static String divide(String num1, String num2)
    {
        // Convert num1 and num2 to integer arrays
        int[] dividend = new int[num1.length()];
        int[] divisor = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            dividend[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            divisor[i] = num2.charAt(i) - '0';
        }

        // Perform division
        StringBuilder quotient = new StringBuilder();
        int index = 0;
        int[] temp = new int[dividend.length];
        while (index < dividend.length) {
            while (index < dividend.length && temp[0] == 0) {
                // Shift next digit into temp array
                for (int i = 0; i < divisor.length && index + i < dividend.length; i++) {
                    temp[i] = dividend[index + i];
                }
                index++;
            }

            int factor = 0;
            while (compare(temp, divisor) >= 0) {
                subtract(temp, divisor);
                factor++;
            }
            quotient.append(factor);
        }

        // Handle case where quotient is zero
        if (quotient.length() == 0) {
            quotient.append('0');
        }

        // Print the quotient
        System.out.println("Quotient: " + quotient);
    }
    // Compare two integer arrays (returns 1 if a > b, 0 if a == b, -1 if a < b)
    private static int compare(int[] a, int[] b) {
        if (a.length > b.length) {
            return 1;
        }
        if (a.length < b.length) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                return 1;
            }
            if (a[i] < b[i]) {
                return -1;
            }
        }
        return 0;
    }

    // Subtract two integer arrays (assumes a >= b)
    private static void subtract(int[] a, int[] b) {
        int borrow = 0;
        for (int i = b.length - 1; i >= 0; i--) {
            int diff = a[i + a.length - b.length] - b[i] - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            a[i + a.length - b.length] = diff;
        }
        for (int i = a.length - b.length - 1; i >= 0; i--) {
            if (borrow == 0) {
                break;
            }
            int diff = a[i] - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            a[i] = diff;
        }
    }
}
