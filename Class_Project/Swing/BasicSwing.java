import javax.swing.*;

public class BasicSwing extends JFrame
{
	public BasicSwing()
	{
		super("Basic Swing App");
		setSize(400,300);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new BasicSwing();
	}
}