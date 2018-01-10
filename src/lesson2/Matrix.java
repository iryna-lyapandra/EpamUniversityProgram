package lesson2;


/**
 * Created by a on 30/12/2017.
 */
public class Matrix {
    Integer[][] matrix;
    int rows;
    int columns;

    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new Integer[rows][columns];
    }

    public void fillMatrixRandomly() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i > j) {
                    matrix[i][j] = Integer.valueOf(1 + (int) (Math.random() * 10));
                } else if (i < j) {
                    matrix[i][j] = Integer.valueOf(10 + (int) (Math.random() * 10));
                } else {
                    matrix[i][j] = Integer.valueOf(0);
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public void findSumOfElements() {
        int sumBelow=0;
        int sumAbove=0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i > j) {
                    sumBelow += matrix[i][j];
                } else if (i < j) {
                    sumAbove += matrix[i][j];
                }
            }
        }
        System.out.println("Sum above the diagonal is " + sumAbove);
        System.out.println("Sum below the diagonal is " + sumBelow);
    }
}