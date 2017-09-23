package gcd;

import java.util.LinkedList;
import java.util.List;

public class GCD {
    public static void main(String[] args) {
        System.out.printf("Eucledian: GCD of 1920 and 1080 = %d\n", gcdEucledian(1920, 1080));
        System.out.printf("PrimeFactors: GCD of 1920 and 1080 = %d\n", gcdPrimeFactors(1920, 1080));
        System.out.printf("Eucledian: GCD of 459 and 183 = %d\n", gcdEucledian(459, 183));
        System.out.printf("PrimeFactors: GCD of 459 and 183 = %d\n", gcdPrimeFactors(459, 183));
        System.out.printf("Eucledian: GCD of 789456 and 321654 = %d\n", gcdEucledian(789456, 321654));
        System.out.printf("PrimeFactors: GCD of 789456 and 321654 = %d\n", gcdPrimeFactors(789456, 321654));
    }
    public static int gcdPrimeFactors(int a, int b){
        List<Integer> primeA;
        primeA = new LinkedList<>();
        List<Integer> primeB;
        primeB = new LinkedList<>();
        int gcd = 1;
        for (int i = 2; a > 1;) {
            if (a % i == 0) {
                primeA.add(i);
                a /= i;
            }
            else i++;
        }
        for (int i = 2; b > 1;) {
            if (b % i == 0) {
                primeB.add(i);
                b /= i;
            }
            else i++;
        }
        int iA = 0;
        int iB = 0;
        while(iA < primeA.size() && iB < primeB.size()){
            if (primeA.get(iA) == primeB.get(iB)) {
                gcd *= primeA.get(iA);
                iA++;
                iB++;
            }
            else if (primeA.get(iA) < primeB.get(iB)){
                iA++;
            }
            else if (primeA.get(iA) > primeB.get(iB)){
                iB++;
            }
        } 
        return gcd;
    }
    public static int gcdEucledian(int a, int b){
        if (b == 0) return a;
        return gcdEucledian(b, a % b);
    }
}
