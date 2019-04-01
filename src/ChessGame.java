
public class ChessGame
{

    public static final int NPIECES = 16;
    private Board board;
    private Piece[] white;
    private Piece[] black;

    /**
     * Constructs a new ChessGame. <br>
     * <br>
     * Initialize both sides with 16 pieces (8 pawns, 2 rooks, 2 knights, 2
     * bishops, 1 queen, 1 king).<br>
     * The ids for the pieces are as follows: ColorFirstletterofpieceNumber<br>
     * --> WP1 (White Pawn 1) or BQ (Black Queen) <br>
     * <br>
     * The pieces are placed in set locations (row, col)-id: <br>
     * <br>
     * (6,0)-WP1, (6,1)-WP2, (6,2)-WP3, (6,3)-WP4, (6,4)-WP5, (6,5)-WP6,
     * (6,6)-WP7, (6,7)-WP8, (7,0)-WR1, (7,1)-WK1, (7,2)-WB1, (7,3)-WQ,
     * (7,4)-WK, (7,5)-WB2, (7,6)-WK2, (7,7)-WR2<br>
     * <br>
     * (1,0)-BP1, (1,1)-BP2, (1,2)-BP3, (1,3)-BP4, (1,4)-BP5, (1,5)-BP1,
     * (1,6)-BP0, (1,7)-BP8, (0,0)-BR1, (0,1)-BK1, (0,2)-BB1, (0,3)-BQ,
     * (0,4)-BK, (0,5)-BB2, (0,6)-BK2, (0,7)-BR2
     */
    public ChessGame()
    {
	// initalize a default board
	board = new Board();

	white = new Piece[NPIECES];
	// initalize white pieces
	white[0] = new Pawn(Color.WHITE, "WP1");
	white[1] = new Pawn(Color.WHITE, "WP2");
	white[2] = new Pawn(Color.WHITE, "WP3");
	white[3] = new Pawn(Color.WHITE, "WP4");
	white[4] = new Pawn(Color.WHITE, "WP5");
	white[5] = new Pawn(Color.WHITE, "WP6");
	white[6] = new Pawn(Color.WHITE, "WP7");
	white[7] = new Pawn(Color.WHITE, "WP8");
	white[8] = new Rook(Color.WHITE, "WR1");
	white[9] = new Knight(Color.WHITE, "WK1");
	white[10] = new Bishop(Color.WHITE, "WB1");
	white[11] = new Queen(Color.WHITE, "WQ");
	white[12] = new King(Color.WHITE, "WK");
	white[13] = new Bishop(Color.WHITE, "WB2");
	white[14] = new Knight(Color.WHITE, "WK2");
	white[15] = new Rook(Color.WHITE, "WR2");

	black = new Piece[NPIECES];
	// initalize black pieces
	black[0] = new Pawn(Color.BLACK, "BP1");
	black[1] = new Pawn(Color.BLACK, "BP2");
	black[2] = new Pawn(Color.BLACK, "BP3");
	black[3] = new Pawn(Color.BLACK, "BP4");
	black[4] = new Pawn(Color.BLACK, "BP5");
	black[5] = new Pawn(Color.BLACK, "BP6");
	black[6] = new Pawn(Color.BLACK, "BP7");
	black[7] = new Pawn(Color.BLACK, "BP8");
	black[8] = new Rook(Color.BLACK, "BR1");
	black[9] = new Knight(Color.BLACK, "BK1");
	black[10] = new Bishop(Color.BLACK, "BB1");
	black[11] = new Queen(Color.BLACK, "BQ");
	black[12] = new King(Color.BLACK, "BK");
	black[13] = new Bishop(Color.BLACK, "BB2");
	black[14] = new Knight(Color.BLACK, "BK2");
	black[15] = new Rook(Color.BLACK, "BR2");

	// put pieces on the board
	int curWRow = 6;
	int curBRow = 1;
	int curCol = 0;
	for (int i = 0; i < NPIECES; i++)
	{
	    board.putPiece(white[i], new Position(curWRow, curCol));
	    board.putPiece(black[i], new Position(curBRow, curCol));

	    curCol = (curCol + 1) % 8;

	    // when it is the second row
	    if (i >= NPIECES / 2)
	    {
		curWRow++;
		curBRow--;
	    }
	}
    }
}
