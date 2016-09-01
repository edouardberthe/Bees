import java.awt.Color;

import javax.swing.event.EventListenerList;

public class Bee extends Movable implements Runnable {
	
	private static int size = 3;
	private static int speed = 3;
	private static int lag = 50;
	private static int maxFood = 10;
	
	public World world;
	private Coordinates coordinates;
	private Hive hive;
	private int food;
	
	private final EventListenerList listeners = new EventListenerList();
	
	public Bee(Hive hive) {
		this.hive = hive;
		this.world = hive.world;
		this.coordinates = new Coordinates(hive.getCoordinates().getX(), hive.getCoordinates().getY());
		this.food = 0;
		new Thread(this).start();
	}
	
	public void run() {
		try {
			while (true) {
				Thread.sleep(Bee.lag);
				move();
				fill();
				put();
			}
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	private static int randInt() {
		return (int) (Math.random() * speed * 2 - speed);
	}
	
	private void move() {
		if (hasFood()) {
			int dx = (int) (Math.random() * speed * 2 - speed) - Integer.signum(coordinates.getX() - hive.getCoordinates().getX());
			int dy = (int) (Math.random() * speed * 2 - speed) - Integer.signum(coordinates.getY() - hive.getCoordinates().getY());
			coordinates.addX(dx);
			coordinates.addY(dy);
			world.addPheromone(coordinates);
		} else {
			coordinates.addX(Bee.randInt());
			coordinates.addY(Bee.randInt());
		}
		fireMove();
	}
	
	private void fill() {
		if (world.hasFlower(this) && !isFull()) {
			try {
				addFood(world.getFlower(this).removeFood(maxFood - food));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void put() {
		if (isAt(hive) && hasFood()) {
			removeFood(hive.put(food));
		}
	}
	
	private void fireMove() {
		for (MoveListener listener : this.getMoveListeners()) {
			listener.onMove();
		}
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	private MoveListener[] getMoveListeners() {
		return listeners.getListeners(MoveListener.class);
	}
	
	public void addMoveListener(MoveListener moveListener) {
		listeners.add(MoveListener.class, moveListener);
	}
	
	public int getSize() {
		return Bee.size;
	}
	
	public boolean hasFood() {
		return food != 0;
	}
	
	public boolean isFull() {
		return food == maxFood;
	}
	
	public void setFood(int food) {
		this.food = Math.max(0, Math.min(maxFood, food));
	}
	
	public void addFood(int food) {
		setFood(this.food + food);
	}
	
	public void removeFood(int food) {
		setFood(this.food - food);
	}

	@Override
	public Color getColor() {
		if (hasFood()) {
			return Color.RED;
		} else {
			return Color.BLUE;
		}
	}
}
