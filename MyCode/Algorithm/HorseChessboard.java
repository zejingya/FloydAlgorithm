package Algorithm;

import java.awt.*;
import java.util.ArrayList;

public class HorseChessboard {

    private static int X;
    private static int Y;
    private static boolean visited[];
    private static boolean finished;

    public static void traversalChessboard(int[][] chessboard, int row, int column, int step){

        chessboard[row][column] = step;
        visited[row * X + column] = true;
        ArrayList<Point> ps = next(new Point(column, row));

        sort(ps);

        while(!ps.isEmpty()) {
            Point p = ps.remove(0);
            if(!visited[p.y * X + p.x]) {
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }

        if(step < X * Y && !finished ) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    public static ArrayList<Point> next(Point curPoint){

        ArrayList<Point> ps = new ArrayList<Point>();
        Point p1 = new Point();

        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y -1) >= 0) {
            ps.add(new Point(p1));
        }
        //�ж����������6���λ��
        if((p1.x = curPoint.x - 1) >=0 && (p1.y=curPoint.y-2)>=0) {
            ps.add(new Point(p1));
        }
        //�ж����������7���λ��
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //�ж����������0���λ��
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //�ж����������1���λ��
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //�ж����������2���λ��
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //�ж����������3���λ��
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //�ж����������4���λ��
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    public static void sort(ArrayList<Point> ps){

        ps.sort((o1, o2) -> {

            int count1 = next(o1).size();
            int count2 = next(o2).size();

            if (count1 < count2){
                return -1;
            } else if (count1 == count2){
                return 0;
            }else return 1;
        });
    }
}
