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

    Matrix SumMatrix(Matrix m) {
        Matrix ResM = new Matrix(rows, columns);

        //Если сложение невозможно выводим нулевую матрицу
        if (this.rows == m.rows && this.columns == m.columns) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    ResM.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
                }
            }
        }
        return ResM;
    }

    Matrix  MultiNumber(double n) {
        Matrix ResM = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ResM.matrix[i][j] = this.matrix[i][j] * n;
            }
        }
        return ResM;
    }

    Matrix MultiMatrix(Matrix m) {
        Matrix ResM = new Matrix(this.rows, m.columns);

        //Если умножение невозможно выводим нулевую матрицу
        if (this.columns == m.rows) {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < m.columns; j++) {
                    ResM.matrix[i][j] = 0;
                    for (int k = 0; k < this.columns; k++) {
                        ResM.matrix[i][j] += this.matrix[i][k] * m.matrix[k][j];
                    }
                }
            }
        }
        return ResM;
    }

    public static void main (String[] args) {
        Matrix m1 = new Matrix(2, 2, new double[][]{ {1,2},{3,4} });
        System.out.println("вывод на печать Матрицы1");
        m1.PrintMatrix();

        Matrix m2 = new Matrix(2, 2, new double[][]{ {5,6},{7,8} });
        System.out.println("вывод на печать Матрицы2");
        m2.PrintMatrix();

        System.out.println("Сумма Матрица1+Матрица2");
        m1.SumMatrix(m2).PrintMatrix();

        System.out.println("Умножение Матрицы1 на 10");
        m1.MultiNumber(10).PrintMatrix();

        System.out.println("Умножение Матрица1*Матрица2");
        m1.MultiMatrix(m2).PrintMatrix();
    }
}
