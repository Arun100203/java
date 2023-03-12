public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "12345678901234567890";
        String num2 = "98765432109876543210";
        System.out.println(multiply(num1, num2));
    }
    public static String multiply(String num1, String num2)
    {
       if (num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int[] result = new int[num1.length() + num2.length()];

        // Perform multiplication digit-by-digit
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int prod = digit1 * digit2 + result[i + j + 1];
                result[i + j] += prod / 10;
                result[i + j + 1] = prod % 10;
            }
        }

        // Convert result array to string
        StringBuilder output = new StringBuilder();
        for (int digit : result) {
            if (digit > 0 || output.length() > 0) {
                output.append(digit);
            }
        }

        // Handle case where result is zero
        if (output.length() == 0) {
            output.append('0');
        }
        return output;
    }
}
