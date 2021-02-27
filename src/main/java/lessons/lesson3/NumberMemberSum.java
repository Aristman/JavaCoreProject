package lessons.lesson3;

public class NumberMemberSum {
    public static void main(String[] args) {
        System.out.println(sum(234234123));
    }

    private static int sum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
