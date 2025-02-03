public class MultithreadedMatrixMultiplication {

    public static class MatrixWorker implements Runnable {
        private int row;
        private int[][] matrixA;
        private int[][] matrixB;
        private int[][] result;
        private int colsA;
        private int colsB;

        public MatrixWorker(int row, int[][] matrixA, int[][] matrixB, int[][] result, int colsA, int colsB) {
            this.row = row;
            this.matrixA = matrixA;
            this.matrixB = matrixB;
            this.result = result;
            this.colsA = colsA;
            this.colsB = colsB;
        }

        @Override
        public void run() {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[row][j] += matrixA[row][k] * matrixB[k][j];
                }
            }
        }
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];
        Thread[] threads = new Thread[rowsA];

        for (int i = 0; i < rowsA; i++) {
            threads[i] = new Thread(new MatrixWorker(i, matrixA, matrixB, result, colsA, colsB), "Row-" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{2, 0}, {1, 2}};

        int[][] result = multiplyMatrices(matrixA, matrixB);

        System.out.println("Result of the multiplication:");
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
