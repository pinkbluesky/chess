import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

public class ChessViewer
{

	public static void main(String[] args)
	{

		JFrame frame = new JFrame();
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ChessComp comp = new ChessComp(frame.getWidth(), frame.getHeight());
		frame.add(comp);

		// Resize listener for frame
		class ResizeListener implements ComponentListener
		{
			private ChessComp comp;

			public ResizeListener(ChessComp comp)
			{
				this.comp = comp;
			}

			@Override
			public void componentResized(ComponentEvent e)
			{
				comp.resizeBoard(frame.getWidth(), frame.getHeight());
			}

			@Override
			public void componentMoved(ComponentEvent e)
			{
			}

			@Override
			public void componentShown(ComponentEvent e)
			{
			}

			@Override
			public void componentHidden(ComponentEvent e)
			{
			}
		}

		ResizeListener resizeL = new ResizeListener(comp);
		frame.addComponentListener(resizeL);

		// Mouse Listener for clicking the squares
		ClickListener clickL = new ClickListener(comp);
		comp.addMouseListener(clickL);

		frame.setVisible(true);

	}

}
