import java.util.Arrays;
import java.util.Scanner;
public class Main {
    // массив для хранения позиций фигур
    static int[][] positions = new int[3][2];
    public static void main(String[] args) {
        System.out.println("pos example: 6 4");
        // получение позиций фигур
        int[] King = Get_pos("King");
        int[] Rook = Get_pos("Rook");
        int[] Bishop = Get_pos("Bishop");

        // значение для определения наличия шаха
        boolean check = false;

        // проверка на наличие шаха от ладьи и отсутствие перекрытия
        if ((King[1] == Rook[1] || King[0] == Rook[0]) && !((Bishop[0] == Rook[0] || Bishop[1] == Rook[1])
                && ((Math.max(King[1], Rook[1]) > Bishop[1] && Math.min(King[1], Rook[1]) < Bishop[1])
                || (Math.max(King[0], Rook[0]) > Bishop[0] && Math.min(King[0], Rook[0]) < Bishop[0])))) {
            System.out.println("Rook check");
            check = true;
        }

        // проверка на наличие шаха от слона и отсутствие перекрытия
        if ((Math.abs(King[0] - Bishop[0]) == Math.abs(King[1] - Bishop[1]))
                && !((Math.abs(Rook[0] - Bishop[0]) == Math.abs(Rook[1] - Bishop[1]))
                && ((Math.max(King[1], Bishop[1]) > Rook[1] && Math.min(King[1], Bishop[1]) < Rook[1])
                || (Math.max(King[0], Bishop[0]) > Rook[0] && Math.min(King[0], Bishop[0]) < Rook[0])))) {
            System.out.println("Bishop check");
            check = true;
        }

        // срабатывает при отсутствии шаха
        if (!check){System.out.println("King is in safe");}
    }

    // метод для получения позиций фигур
    public static int[] Get_pos(String chessman){
        Scanner sc = new Scanner(System.in);

        // определение индекса для записи в двумерный массив позиции фигуры
        int index = 0;
        switch (chessman){
            case "King":
                break;
            case "Rook":
                index = 1;
                break;
            case "Bishop":
                index = 2;
                break;
            default:
                break;
        }

        // цикл заканчивается при коректном вводе
        while (true) {
            System.out.print(chessman + " pos ");
            int[] pos = {sc.nextInt(), sc.nextInt()};
            if(pos[0]>8 || pos[0]<1 || pos[1]>8 || pos[1]<1){ // проверка на наличие фигуры на поле
                System.out.println("Out of range");
            } else if(Arrays.equals(positions[0],pos) || Arrays.equals(positions[1],pos) || Arrays.equals(positions[2],pos)) { // проверка на занятость клетки
                System.out.println("Cell is occupied");
            } else {
                System.out.println();
                positions[index] = pos; // выход из цикла и запись позиции в двумерный массив
                return pos;
            }
        }
    }
}
