package be.lens.syntra;

public class FizzBuzz {
    public static String fizzBuzz(int i) {
        String result = "";
        if (i % 3 == 0) {
            result += "Fizz";
        }
        if (i % 5 == 0) {
            result += "Buzz";
        }
        return result.isEmpty() ? String.valueOf(i) : result;
    }
}
