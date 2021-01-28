package com.ybs.ex1;



public class GameBoard {
    private char [][] matrix;
    private char player;

    public GameBoard(){
        matrix=new char[3][3];
        newGame();
    }
    public void newGame(){
        player='X';
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                matrix[i][j] = ' ';
            }
        }
    }
    public char setBoard(int i,int j){
        matrix[i][j]=player;
        if (this.player == 'X')
            this.player = 'O';
        else
            this.player = 'X';
        return (this.player=='X')?'O':'X';

    }
    public String end()
    {
        //Checking Line
        for (int i = 0; i < matrix.length; i++)
            for (int j=0; j < matrix.length-1; j++) {
                if (matrix[i][j] != matrix[i][j + 1] || matrix[i][j] == ' ')
                    break;
                if (j+1 == matrix.length - 1)
                    return matrix[i][j]+""+(i*3+1)+""+(i*3+2)+""+(i+1)*3+"";
            }
        //Checker column
        for (int i=0; i < matrix.length; i++) {
            for ( int j=0 ; j < matrix.length-1; j++) {
                if(matrix[j][i]!=matrix[j+1][i]||matrix[j][i]==' ')
                    break;
                if(j+1==matrix.length-1)
                    return matrix[j-1][i]+""+(i+1)+""+(i+4)+""+(i+7)+"";
            }
        }
        for (int i = 0; i < matrix.length-1; i++) {
            if(matrix[i][i]!=matrix[i+1][i+1]||matrix[i][i]==' ')
                break;
            if(i+1==matrix.length-1)
                return matrix[i][i]+""+(i)+""+(i+4)+""+(i+8)+"";
        }
        //Make diagonal checker
        for(int i=0, j=matrix.length-1;i<matrix.length-1;i++,j--){
            if(matrix[i][j]!=matrix[i+1][j-1]||matrix[i][j]==' ')
                break;
            if(j==1)
                return matrix[i+1][j-1]+""+(j+6)+""+(j+2)+""+(j+4);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]==' ')
                    return "  ";
            }
        }
        return "D";//teko
    }

}

