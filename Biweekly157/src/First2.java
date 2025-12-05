import java.util.*;

public class First2 {
    public long sumOfLargestPrimes(String s) {
        int n = s.length();


        TreeSet<Long> st = new TreeSet<>();
        for(int l=n; l>0; l--){
            for(int i=0; i<=n-l; i++){
                long currInt = Long.parseLong(s.substring(i, i+l));

                if(!st.contains(currInt) && isPrime(currInt)){
//                    ans+=currInt;
                    st.add(currInt);
                }
            }
        }
//        List<Integer> lt = new ArrayList<>(st);

        int count = 3;
        long ans = 0;
        Iterator<Long> descendingIterator = st.descendingIterator();
        while (descendingIterator.hasNext() && count>0) {
            Long number = descendingIterator.next();
//            System.out.println(number);
            ans+=number;
            count--;
        }
        return ans;
    }

    boolean isPrime(long n) {
        int count = 0;

        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
            }
        }

        if (count == 0) {
            return true;
        }

        return false;
    }
}
