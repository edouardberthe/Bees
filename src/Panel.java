import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Panel extends JPanel implements MoveListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	public Panel() {
		this.addMouseListener(this);
	}
	
	private ArrayList<Printable> getPrintables() {
		ArrayList<Printable> list = new ArrayList<Printable>();
		for (Flower flower: World.getWorld().getFlowers()) {
			list.add(flower);
		}
		for (Hive hive: World.getWorld().getHives()) {
			list.add(hive);
			for (Bee bee: hive.getBees()) {
				list.add(bee);
			}
		}
		return list;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Printable printable : getPrintables()) {
			g.setColor(printable.getColor());
			g.fillOval(
					printable.getCoordinates().getX() - printable.getSize() / 2,
					printable.getCoordinates().getY() - printable.getSize() / 2,
					printable.getSize(),
					printable.getSize()
			);
		}
		g.setColor(Color.ORANGE);
		for (int i=0; i < Window.width;i++) {
			for (int j=0; j < Window.height; j++) {
				if (World.getWorld().hasPheromone(new Coordinates(i,j))) {
					g.fillOval(i, j, 1, 1);
				}
			}
		}
	}

	@Override
	public void onMove() {
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Coordinates coordinates = new Coordinates(e.getX(), e.getY());
		if (SwingUtilities.isLeftMouseButton(e)) {
			Hive hive = new Hive(World.getWorld(), coordinates);
			World.getWorld().addHive(hive);
			for (Bee bee : hive.getBees()) {
				bee.addMoveListener(this);
			}
		} else {
			World.getWorld().addFLower(new Flower(coordinates));
		}
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
