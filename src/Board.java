public class Board{
    private String[][] boardArray;
    private int numToWin;
    private int emptySquares;
    private int indexlastPlayedRow;
    private int indexlastPlayedCol;
    private String lastMark;

    public Board(int numRows, int numCol, int numToWin){
        boardArray = new String[numRows + 1][numCol];
        this.numToWin = numToWin;
        emptySquares = numCol * (numRows + 1) - boardArray[0].length;

        this.clearBoard();
    }

    public int getNumRows(){
        return boardArray.length;
    }

    public int getNumCols(){
        return boardArray[0].length;
    }

    public String getMark(int row, int col){
        return boardArray[row][col];
    }

    public void clearBoard(){
        for(int r = 0; r < boardArray.length; r++){
            for(int c = 0; c < boardArray[0].length; c++){
                boardArray[r][c] = " ";
            }
        }

        for(int i = 0; i < boardArray[0].length; i++){
            boardArray[0][i] = String.valueOf(i + 1);
        }
    }

    public int getEmptySquares(){
        return emptySquares;
    }

    public Board copy(){
        Board newBoard = new Board(boardArray.length, boardArray[0].length, this.numToWin);
        newBoard.emptySquares = this.emptySquares;
        newBoard.boardArray = boardArray.clone();
        return newBoard;
    }

    public boolean play(int col, String mark){
        for(int c = 0; c < boardArray.length; c++){
            if(col > boardArray[0].length){
                break;
            }

            if(boardArray[c][col - 1].equals(" ")){
                boardArray[c][col - 1] = mark;
                emptySquares--;
                indexlastPlayedRow = c;
                indexlastPlayedCol = col - 1;
                lastMark = mark;
                return true;
            }
        }
        return false;
    }

    public String checkForWin() {
        int consecutiveMarks = 0;

        // n|s check
        for (int r = indexlastPlayedRow - (numToWin - 1); r < indexlastPlayedRow + (numToWin - 1); r++) {
            if(r > -1 && r < boardArray.length)
            {
                if (boardArray[r][indexlastPlayedCol].equals(lastMark))
                {
                    consecutiveMarks++;
                } else
                {
                    consecutiveMarks = 0;
                }

                if (consecutiveMarks == numToWin) {
                    return lastMark;
                }
            }
        }
        consecutiveMarks = 0;

        // e|w check
        for (int c = indexlastPlayedCol - (numToWin - 1); c < indexlastPlayedCol + (numToWin - 1); c++) {
            if(c > -1 && c < boardArray[0].length){
                if (boardArray[indexlastPlayedRow][c].equals(lastMark)) {
                    consecutiveMarks++;
                } else
                {
                    consecutiveMarks = 0;
                }
            }

            if (consecutiveMarks == numToWin) {
                return lastMark;
            }
        }
        consecutiveMarks = 0;

        // l|r diagonal check
        int i = 0;
        for(int r = indexlastPlayedRow - (numToWin - 1); r < indexlastPlayedRow + (numToWin - 1); r++){
            if(r > -1 &&
                    r < boardArray.length &&
                    indexlastPlayedCol - (numToWin - 1) + i > -1 &&
                    indexlastPlayedCol - (numToWin - 1) + i < boardArray[0].length) {
                if (boardArray[r][indexlastPlayedCol - (numToWin - 1) + i].equals(lastMark)) {
                    consecutiveMarks++;
                } else {
                    consecutiveMarks = 0;
                }
            }

            if(consecutiveMarks == numToWin){
                return lastMark;
            }
            i++;
        }
        consecutiveMarks = 0;

        i = 0;
        // r|l diagonal check
        for(int r = indexlastPlayedRow - (numToWin - 1); r < indexlastPlayedRow + (numToWin - 1); r++){
            if(r > -1 &&
                    r < boardArray.length &&
                    indexlastPlayedCol - (numToWin - 1) + i > -1 &&
                    indexlastPlayedCol - (numToWin - 1) + i < boardArray[0].length){
                if(boardArray[r][indexlastPlayedCol + (numToWin - 1) - i].equals(lastMark)){
                    consecutiveMarks++;
                }
                else{
                    consecutiveMarks = 0;
                }
            }

            if(consecutiveMarks == numToWin){
                return lastMark;
            }
            i++;
        }
        return null;
    }
}