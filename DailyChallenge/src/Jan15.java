public class Jan15 {
    public int setBitCounter(int num){
        int count = 0;
        while(num>0){
            if((num&1)==1){
                count++;
            }
            num = num>>1;
        }
        return  count;
    }
    public int minimizeXor(int num1, int num2) {

        int num1BitsCount = setBitCounter(num1);
        int num2BitsCount = setBitCounter(num2);

        int diff = num2BitsCount - num1BitsCount;
        int res = num1;
        if(diff == 0)  return num1;
        else if(diff<0){ // remove extra bits
            int i=0;
            while(diff<0){
                if(((num1>>i) & 1)==1){
                    res = (res ^ (1<<i));
                    diff++;
                }
                i++;
            }
        }
        else{ // add bits
            int i=0;
            while(diff>0){
                if((num1 & (1<<i))==0){
                    res = res + (1<<i);
                    diff--;
                }
                i++;
            }
        }

        return res;
    }
}

/*
num1 = 1000001
x    = 1000011
num2 = 1010100

num1 = 1010100
x    = 0010100
xor  = 1000000
x    = 1010000
xor  = 0000100
num2 = 1000001
 */
