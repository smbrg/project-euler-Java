/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/
import java.util.ArrayList;

public class Main {
    public static Long QUERY = 600851475143L;
    public static void main(String[] args) {
        Long remaining = QUERY;
        Long ans = 2L;

        while (remaining%ans == 0) {
            remaining /= ans;
        }

        ans -= 1;
        while (remaining > 1) {
            ans += 2;
            while (remaining%ans == 0) {
                remaining /= ans;
            }
        }
        System.out.println(ans);
    }
}
