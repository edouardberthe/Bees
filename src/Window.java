import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private static final long serialVersionUID = 5259700796854880162L;
	
	public static int height = 400;
	public static int width = 1000;

	public Window() {
		setTitle("Bees simulation software");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		World world = World.getWorld();
		JPanel panel = new Panel();
		Generator generator = new Generator();
		generator.start();
		setContentPane(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Window();
	}

}
