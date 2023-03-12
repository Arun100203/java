public class SubtractStrings {
    public static void main(String[] args) {
        String num1 = "12345678901234567890";
        String num2 = "98765432109876543210";
        System.out.println(subtract(num1, num2));
    }
    public static String subtract(String num1, String num2)
    {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        } else if (num1.length() == num2.length() && num1.compareTo(num2) < 0) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        StringBuilder result = new StringBuilder();
        int borrow = 0;
        int diff = num1.length() - num2.length();

        // Perform subtraction digit-by-digit
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = i - diff >= 0 ? num2.charAt(i - diff) - '0' : 0;
            int diffDigit = digit1 - digit2 - borrow;
            if (diffDigit < 0) {
                diffDigit += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diffDigit);
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        // Reverse the result and return it
        return result.reverse().toString();
    }
}
