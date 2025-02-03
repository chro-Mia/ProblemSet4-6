/*
 * The BoardViewer is written as a separate class in case someone wants to
 * implement a graphical user interface instead of terminal output. It is
 * good programming practice to have separate classes for processing (modeling)
 * the data and for viewing it.
 */

public class BoardViewer
{
    public BoardViewer()
    {

    }

    public void showBoard(Board board)
    {

        System.out.println();

        int numRows = board.getNumRows();
        int numCols = board.getNumCols();

        printLineDivider(numCols);


        for(int row = numRows - 1; row >= 0; row--)
        {
            System.out.print("|");
            for(int col = 0; col <= numCols - 1; col++)
            {
                System.out.print(" " + board.getMark(row,col) + " |");
            }
            System.out.println();
            printLineDivider(numCols);
        }
    }

    private void printLineDivider(int numCols)
    {

        // 4 per column, plus one because there's a bar on both sides
        for(int i = 0; i < numCols*4 + 1; i++)
        {
            System.out.print("-");
        }
        System.out.println();
    }
}