import java.util.Arrays;

public class Lt3529 {
        public int countCells(char[][] grid, String pattern) {

            int n = grid.length;
            int m = grid[0].length;
            int pLen = pattern.length();


            int[] table = getKmpTable(pattern);

            int[][] mp1 = new int[n][m];
            int[][] mp2 = new int[n][m];

            System.out.println(Arrays.toString(table));
            int pi = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m;){
                    if(grid[i][j] == pattern.charAt(pi)){
                        pi++;
                        j++;
                    }
                    else{
                        if(pi>0)    pi = table[pi-1];
                        else{
                            j++;
                        }
                    }
                    if(pi==pLen){
                        pi = table[pi-1];
                        mp1[i][j-1] = 1;
                    }

                }
            }
            int k = 0;

            for(int i=n-1; i>=0; i--){
                for(int j=m-1; j>=0; j--){
                    if(mp1[i][j]==1){
                        k = pLen;
                    }
                    if(k>0){
                        mp1[i][j] = 1;
                        k--;
                    }
                }
            }

            System.out.println("mp1");
            for(int[] mpe : mp1){
                System.out.println(Arrays.toString(mpe));
            }


            pi = 0;
            for(int j=0; j<m; j++){
                for(int i=0; i<n;){
                    if(grid[i][j] == pattern.charAt(pi)){
                        pi++;
                        i++;
                    }
                    else{
                        if(pi>0)    pi = table[pi-1];
                        else{
                            i++;
                        }
                    }
                    if(pi==pLen){
                        pi = table[pi-1];
                        mp2[i-1][j] = 1;
                    }
                }
            }

            k=0;
            for(int i=n-1; i>=0; i--){
                for(int j=m-1; j>=0; j--){
                    if(mp2[i][j]==1){
                        k = pLen;
                    }
                    if(k>0){
                        mp2[i][j] = 1;
                        k--;
                    }
                }
            }
            System.out.println("mp2");
            for(int[] mpe : mp2){
                System.out.println(Arrays.toString(mpe));
            }
            int count = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(mp1[i][j]==1 && mp2[i][j]==1){
                        count++;
                    }
                }
            }

            return count;
        }

        int[] getKmpTable(String s){
            int n = s.length();
            int[] table = new int[n];
            int index = 0;
            int i=1;
            while(i<n){
                if(s.charAt(i)==s.charAt(index)){
                    table[i] = ++index;
                    i++;
                }
                else{
                    if(index!=0){
                        index = table[index-1];
                    }
                    else{
                        i++;
                    }
                }
            }

            return table;
        }
    }