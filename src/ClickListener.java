import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener
{
	private boolean firstClick;
	private ChessComp comp;

	private int firstPixelX;
	private int firstPixelY;

	private String description;

	/**
	 * Constructs a ClickListener with the given ChessComp.
	 * <br>
	 * The first click is recorded, then the second click. After the second click, a
	 * description of the move is avaliable until the next first click.
	 * 
	 * @param comp
	 *             the chess component
	 */
	public ClickListener(ChessComp comp)
	{
		firstClick = true;
		this.comp = comp;
		firstPixelX = 0;
		firstPixelY = 0;
		description = "";
	}

	/**
	 * Returns the description of ClickListener.<br>
	 * The description is an empty string if in the middle of the next move.
	 * 
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// first click or second click?
		if (firstClick)
		{
			description = "";
			firstPixelX = e.getX();
			firstPixelY = e.getY();
		}
		// move if second click
		else
		{
			description = comp.movePiece(firstPixelX, firstPixelY, e.getX(), e.getY());
			System.out.println(description);
		}

		firstClick = !firstClick;
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// do nothing

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// do nothing

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// do nothing

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// do nothing

	}

}
