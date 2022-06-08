import java.util.Arrays;

public class Game {
    int S;
    int W;
    int T;
    int P;


    public void CreateField(String s,String name) {   //Генерируем игровое поле в зависимости от типа существа
        char strField[] = s.toCharArray();
        int Field[][] = new int[4][4];
        int count = 0;
        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field[i].length; j++) {
                switch (strField[count]) {
                    case 'S':
                        Field[i][j] = this.S;
                        count++;
                        break;

                    case 'W':
                        Field[i][j] = this.W;
                        count++;
                        break;

                    case 'T':
                        Field[i][j] = this.T;
                        count++;
                        break;

                    case 'P':
                        Field[i][j] = this.P;
                        count++;
                        break;
                }
            }
        }
        Field[0][0]=0;
        getMin(Field,4,4,name,strField);
    }


    public void DrawField(char arr[]) {                    //Вывести игровое поле
        for (int i = 0; i < arr.length; i++) {
            if (i % 4 == 0 || i % 4 == 0 || i % 8 == 0 || i % 12 == 0) {
                System.out.println();
                System.out.print(arr[i] + "\t");
            } else {
                System.out.print(arr[i] + "\t");
            }
        }
        System.out.println("\n");
    }



    public  int getMin(int[][] map, int n, int m,String name,char[] strField) { // Находим кратчайший путь
        // Специальный ввод
        if(map==null||n<=0||m<=0) return 0;
        // Создание матрицы результатов динамического программирования dp [] []
        int[][] dp=new int[n][m];
        //  Решаем значение результата первой строки и первого столбца
        dp[0][0]=map[0][0];
        for(int i=1;i<m;i++){
            dp[0][i]=dp[0][i-1]+map[0][i];
        }
        // Находим результирующее значение первого столбца
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+map[i][0];
        }
        // Найти любой dp [i] [j] сверху вниз, слева направо
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=map[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        // ④Возврат результата в правом нижнем углу
        System.out.print( "Минимальные затраты существа "+name+" по местности:\n");
        DrawField(strField);
        System.out.print("Составляет: "+dp[n-1][m-1]);
        return dp[n-1][m-1];
    }


}
