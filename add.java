public class AddStrings {
    public static void main(String[] args) {
        String num1 = "12345678901234567890";
        String num2 = "98765432109876543210";
        System.out.println(add(num1, num2));
    }
    public static String add(String num1, String num2)
    {
        
        // Make num1 the longer number
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int diff = num1.length() - num2.length();

        // Perform addition digit-by-digit
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = i - diff >= 0 ? num2.charAt(i - diff) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        // Add the final carry if necessary
        if (carry != 0) {
            result.append(carry);
        }

        // Reverse the result and return it
        return result.reverse().toString();
    }
}
