package jd;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @Author lihongxing
 * @Date 2023/8/19 11:10
 */


public class _1 {
    public static boolean checkWin(char[][] board, char player) {
        if(player == '*'){
            for(int i = 0;i < 3;i++){
                for(int j = 0;j < 3;j++){
                    if(board[i][j] == '*'){
                        if((i == 1 && board[i - 1][j] == 'o' && board[i + 1][j] == 'o') ||
                                (j == 1 && board[i][j - 1] == 'o' && board[i][j + 1] == 'o')){
                            return false;
                        }
                    }
                }
            }
        }
        if(player == 'o'){
            for(int i = 0;i < 3;i++){
                for(int j = 0;j < 3;j++){
                    if(board[i][j] == 'o'){
                        if((i == 1 && board[i - 1][j] == '*' && board[i + 1][j] == '*') ||
                                (j == 1 && board[i][j - 1] == '*' && board[i][j + 1] == '*')){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<String> res = new ArrayList<>();
        while (t-- > 0) {
            char[][] board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                board[i] = scanner.next().toCharArray();
            }
            //小红黑棋*
            boolean isHongWin = checkWin(board,'*');
            //小紫白棋o
            boolean isZiWin = checkWin(board,'o');
            if(isHongWin && isZiWin){
                res.add("draw");
            }else if(isZiWin){
                res.add("yukari");
            }else if(isHongWin){
                res.add("kou");
            }else{
                res.add("draw");
            }
        }
        for (String re : res) {
            System.out.println(re);
        }
    }
}


