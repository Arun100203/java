public class AddStrings {
    public static void main(String[] args) {
        String num1 = "12345678901234567890";
        String num2 = "-98765432109876543210";
        System.out.println(abs(num1));
        System.out.println(abs(num2));
    }
    public static String abs(String num)
    {
        if(num.charAt(0) == '-')
          return num.substring(1);
      
        return num;
    }
}
