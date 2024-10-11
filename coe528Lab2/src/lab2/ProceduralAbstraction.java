package lab2;

public class ProceduralAbstraction {

    public static int reverseFactorial(int x) {

        if (x > 0) {
            int i;
            int fact = 1;
            for (i = 1; fact < x; i++) {
                fact = fact * i;
            }
            return i - 1;

        } else {

            return 1;
        }
    }

    public static boolean isMatrixNice(int[][] arr) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i][i];
        }

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            if (rowSum != sum || colSum != sum) {
                return false;
      
            }
        }

        int diagSum = 0;
        for (int i = 0; i < n; i++) {
            diagSum += arr[i][n - i - 1];
        }
        if (diagSum != sum) {
            return false;
        }

        System.out.println("The sum is: " + sum);
        return true;
    }

    public static void main(String[] args) {
        
        int[][] test1 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        int[][] test2 = {{-3, 1, 0}, {4, -3, 4}, {7, -9, 0}};
        
        System.out.println("The reverseFactorial of 24 is: " + reverseFactorial(24));
        System.out.println("The reverseFactorial of 119 is: " + reverseFactorial(119));
        
        System.out.println("Is the matrix nice? " + isMatrixNice(test1));
        System.out.println("Is the matrix nice? " + isMatrixNice(test2));

    }
}
