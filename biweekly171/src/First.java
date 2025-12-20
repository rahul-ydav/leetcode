public class First {
    boolean isPrime(int n) {

        if (n <= 1) return false;
        if (n == 2 || n == 3)   return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i *i<=n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean completePrime(int num) {

        int k = num;
        int pow = 1;
        int num2 = 0;
        while(k>0){
            if(!isPrime(k)){
                return false;
            }
            num2 = num2 + pow*(k%10);
            System.out.println("num2:"+num2);
            if(!isPrime(num2)){
                return false;
            }
            k = k/10;
            pow = pow*10;
        }

//        StringBuilder sb = new StringBuilder(""+num);
//        String revn = sb.reverse().toString();
//        k = Integer.parseInt(revn);
//        System.out.println(revn);
//        while(k>0){
//            if(!isPrime(k)){
//                return false;
//            }
//            k = k/10;
//        }

        return true;
    }
}
