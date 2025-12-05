public class Second {

    int[] finder(String[][] input){
        int n = input.length;
        int[] res = new int[n];

        return res;
    }
    class Spreadsheet {

        private int rows;
        private int cols = 26;
        private int[][] mt;

        public Spreadsheet(int rows) {
            this.rows= rows;
            mt = new int[rows][cols];
        }

        public void setCell(String cell, int value) {
            int col  = cell.charAt(0)-'A';
            int row = Integer.parseInt(cell.substring(1))-1;

            mt[row][col] = value;
        }

        public void resetCell(String cell) {
            int col  = cell.charAt(0)-'A';
            int row = Integer.parseInt(cell.substring(1))-1;

            mt[row][col] = 0;
        }

        public int getValue(String formula) {
            int opIdx = 0;
            for(int i=0; i<formula.length(); i++){
                if(formula.charAt(i)=='+'){
                    opIdx = i;
                    break;
                }
            }
            String digit1 = formula.substring(1, opIdx);
            String digit2 = formula.substring(opIdx+1);

            int num1 = sentize(digit1);
            int num2 = sentize(digit1);
            return num1+num2;
        }

        private int sentize(String digit){
            if(digit.charAt(0)>='A' && digit.charAt(0)<='Z'){
                int col  = digit.charAt(0)-'A';
                int row = Integer.parseInt(digit.substring(1))-1;
                return mt[row][col];
            }

            return Integer.parseInt(digit);
        }
    }
}
