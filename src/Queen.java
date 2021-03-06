import java.awt.Image;

public class Queen extends Piece
{

	public static final String ABBREV = "Q";

	public static final String WQUEEN_IMG = "C:\\ChessIcons\\whiteQueen.png";
	public static final String BQUEEN_IMG = "C:\\ChessIcons\\blackQueen.png";

	private Image wQueenImg;
	private Image bQueenImg;

	/**
	 * Constructs a new Queen.<br>
	 * Moving Requirements: A queen can move anywhere diagonally, up, down,
	 * left, or right.
	 * 
	 * @param color
	 *              the color of the queen
	 */
	public Queen(ChessColor color, String id)
	{
		super(color, id);
	}

	public int canMove(Board board, Position p1, Position p2)
	{
		// for moving to an empty spot or an occupied spot
		// check that p1 has a piece on it & both positions are valid
		if (Board.isValid(p1) && Board.isValid(p2) && !board.isEmpty(p1))
		{
			Rook lateral = new Rook(getChessColor(), "rook used for queen");
			Bishop diagonal = new Bishop(getChessColor(), "bishop used for queen");
			int latOut = lateral.canMove(board, p1, p2);
			int diaOut = diagonal.canMove(board, p1, p2);

			// if this move is valid for a Rook or a Bishop
			// then it is valid for a queen
			if (latOut > 0)
			{
				return latOut;
			}
			if (diaOut > 0)
			{
				return diaOut;
			}
		}

		return Piece.INVALID_MOVE;
	}

	@Override
	public void resizeImg(int newSize)
	{
		String filePath;
		if (super.getChessColor() == ChessColor.WHITE)
		{
			filePath = WQUEEN_IMG;
		} else
		{
			filePath = BQUEEN_IMG;
		}

		Image newImg = Piece.defaultResizeImg(filePath, newSize);

		if (super.getChessColor() == ChessColor.WHITE)
		{
			wQueenImg = newImg;
		} else
		{
			bQueenImg = newImg;
		}
	}

	@Override
	public Image getImage()
	{
		if (super.getChessColor() == ChessColor.WHITE)
		{
			return wQueenImg;
		}
		return bQueenImg;
	}

	@Override
	public String getFilePath()
	{
		if (this.getChessColor() == ChessColor.WHITE)
		{
			return WQUEEN_IMG;
		} else
		{
			return BQUEEN_IMG;
		}
	}

}
