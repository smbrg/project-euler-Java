/* This program calculates the largest prime less than the query's square root */

import java.util.ArrayList;

public class Main {
    public static Long QUERY = 600851475143L;
    public static void main(String[] args) {
        //no prime factor of our number is larger than its square root
        int limit = (int) Math.sqrt(QUERY);
        ArrayList<Integer> primes = findPrimes(limit);
        System.out.println(primes.get(primes.size()-1)); //the last prime added to the list is our answer
    }

    /* 
    My implementation of Sieve of Eratosthenes
    Intentionally not using a hashmap so I don't have to sort it over and over
     */
    public static ArrayList<Integer> findPrimes(int limit) {
        System.out.println(limit + " is limit");

        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Pair<Integer, Boolean>> candidates = new ArrayList<Pair<Integer, Boolean>>();
        Integer i;

        //list all numbers from 2 to our target number
        //the boolean value means "this number is prime" which will get updated
        for (i = 2; i <= limit; i++) {
            candidates.add(new Pair<Integer, Boolean>(i, true));
        }

        Integer size = limit - 1;
        Pair<Integer, Boolean> curPair;
        Integer curVal;
        Integer j;
        for (i = 0; i < size; i++) {
            curPair = candidates.get(i); 
            if (curPair.getSecond()) {
                curVal = curPair.getFirst();
                result.add(curVal);
                for (j = i+curVal; j < size; j += curVal) {
                    candidates.get(j).setSecond(false);
                }
            }
        } 
        return result;
    }
}
