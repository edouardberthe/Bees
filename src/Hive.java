import java.awt.Color;
import java.util.ArrayList;

public class Hive implements Printable {
	
	public static int size = 30;

	private int initialNumberOfBees = 200;
	private ArrayList<Bee> bees;
	private Coordinates coordinates;
	public World world;
	private int food;
	
	public Hive(World world) {
		this(world, new Coordinates(200, 200));
	}
	
	public Hive(World world, Coordinates coordinates) {
		this.world = world;
		this.food = 0;
		this.coordinates = coordinates;
		bees = new ArrayList<Bee>();
		for (int i=0; i< this.initialNumberOfBees; i++) {
			bees.add(new Bee(this));
		}
	}
	
	public int put(int food) {
		this.food += food;
		return food;
	}
	
	public String toString() {
		return "Hive of " + this.getNumberOfBees() + " bees.";
	}
	
	public int getNumberOfBees() {
		return this.bees.size();
	}

	public int getInitialNumberOfBees() {
		return initialNumberOfBees;
	}

	public void setInitialNumberOfBees(int initialNumberOfBees) {
		this.initialNumberOfBees = initialNumberOfBees;
	}

	public ArrayList<Bee> getBees() {
		return bees;
	}

	public void setBees(ArrayList<Bee> bees) {
		this.bees = bees;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	public int getSize() {
		return Hive.size;
	}
	
	public Color getColor() {
		return Color.DARK_GRAY;
	}
}
