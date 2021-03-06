import java.awt.Image;

public class King extends Piece
{

	public static final String ABBREV = "K";

	public static final String WKING_IMG = "C:\\ChessIcons\\whiteKing.png";
	public static final String BKING_IMG = "C:\\ChessIcons\\blackKing.png";

	private Image wKingImg;
	private Image bKingImg;

	private boolean isFirst;

	/**
	 * Constructs a new King. <br>
	 * Moving Requirements: It can only move north, east, south, and west by 1
	 * square.
	 * 
	 * @param color
	 *              the color of the king
	 */
	public King(ChessColor color, String id)
	{
		super(color, id);
		isFirst = true;
	}

	public int canMove(Board board, Position p1, Position p2)
	{
		// for moving to an empty spot or an occupied spot
		// check that p1 has a piece on it & both positions are valid
		if (Board.isValid(p1) && Board.isValid(p2) && !board.isEmpty(p1))
		{
			// king can only move N1, E1, S1, W1, NE1, SE1, SW1, NW1
			// if p2 is any of these, then this is a valid move
			if (p2.equals(Board.moveNorth(p1, 1)) || p2.equals(Board.moveEast(p1, 1))
					|| p2.equals(Board.moveSouth(p1, 1)) || p2.equals(Board.moveWest(p1, 1))
					|| p2.equals(Board.moveNE(p1, 1)) || p2.equals(Board.moveSE(p1, 1))
					|| p2.equals(Board.moveSW(p1, 1)) || p2.equals(Board.moveNW(p1, 1)))
			{
				if (isValidMove(board, p1, p2) > 0)
				{
					return isValidMove(board, p1, p2);
				}
			}
		}

		return Piece.INVALID_MOVE;
	}

	/**
	 * Changes the value of isFirst.
	 */
	public void toggleFirst()
	{
		isFirst = !isFirst;
	}

	/**
	 * Returns isFirst.
	 * 
	 * @return isFirst
	 */
	public boolean isFirst()
	{
		return isFirst;
	}

	@Override
	public void resizeImg(int newSize)
	{
		String filePath;
		if (super.getChessColor() == ChessColor.WHITE)
		{
			filePath = WKING_IMG;
		} else
		{
			filePath = BKING_IMG;
		}

		Image newImg = Piece.defaultResizeImg(filePath, newSize);

		if (super.getChessColor() == ChessColor.WHITE)
		{
			wKingImg = newImg;
		} else
		{
			bKingImg = newImg;
		}
	}

	@Override
	public Image getImage()
	{
		if (super.getChessColor() == ChessColor.WHITE)
		{
			return wKingImg;
		}
		return bKingImg;
	}

	@Override
	public String getFilePath()
	{
		if (this.getChessColor() == ChessColor.WHITE)
		{
			return WKING_IMG;
		} else
		{
			return BKING_IMG;
		}
	}
}
