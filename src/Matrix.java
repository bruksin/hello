// Лабораторная работа 6_Классы_Объекты Смирнов АН
public class Matrix {
    private final int rows;
    private final int columns;
    private final double[][] matrix;

    Matrix() {
        this.rows    = 1;
        this.columns = 1;
        this.matrix  = new double[rows][columns];
    }

    Matrix(int rows, int columns) {
        this.rows    = rows;
        this.columns = columns;
        this.matrix  = new double[rows][columns];
    }

    Matrix(int rows, int columns, double[][] matrix) {
        this.rows    = rows;
        this.columns = columns;
        this.matrix  = matrix;
    }
    // вывод на печать
    void PrintMatrix() {
        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns;j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
         Matrix m1 = new Matrix(2, 2, new double[][]{ {1,2},{3,4} });
         m1.PrintMatrix();

        Matrix m2 = new Matrix(2, 2, new double[][]{ {5,6},{7,8} });
        m2.PrintMatrix();
    }
}
