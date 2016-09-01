import java.awt.Color;

public class Flower implements Printable {
	
	private static int size = 5;
	private static int maxFood = 1000;

	private Coordinates coordinates;
	private int food;
	
	public Flower(Coordinates coordinates) {
		this.coordinates = coordinates;
		this.food = maxFood;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public int removeFood(int food) {
		if (food >= this.food) {
			World.getWorld().removeFlower(this);
			return this.food;
		} else {
			this.food -= food;
			return food;
		}
	}

	public int getSize() {
		return 2 * food * Flower.size / maxFood + 1;
	}
	
	public Color getColor() {
		return Color.PINK;
	}
}
