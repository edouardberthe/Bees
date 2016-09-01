import java.util.ArrayList;

public class World {

	private static World world = new World();
	private ArrayList<Hive> hives;
	private ArrayList<Flower> flowers;
	private boolean[][] field;
	
	private World() {
		hives = new ArrayList<Hive>();
		flowers = new ArrayList<Flower>();
		field = new boolean[Window.width][Window.height];
		for (int i = 0 ; i < Window.width ; i++) {
			for (int j = 0; j < Window.height; j++) {
				field[i][j] = false;
				
			}
		}
	}

	public static World getWorld() {
		return world;
	}

	public boolean hasFlower(Movable movable) {
		for (Flower flower: flowers) {
			if (movable.isAt(flower)) {
				return true;
			}
		}
		return false;
	}
	
	public Flower getFlower(Movable movable) throws Exception {
		for (Flower flower: flowers) {
			if (movable.isAt(flower)) {
				return flower;
			}
		}
		throw new Exception("Pas de fleur ici");
	}

	public void addHive(Hive hive) {
		this.hives.add(hive);
	}
	
	public void addFLower(Flower flower) {
		this.flowers.add(flower);
	}
	
	public boolean removeFlower(Flower flower) {
		return flowers.remove(flower);
	}

	public ArrayList<Hive> getHives() {
		return hives;
	}

	public ArrayList<Flower> getFlowers() {
		return flowers;
	}

	public boolean hasPheromone(Coordinates coord) {
		return field[coord.getX()][coord.getY()];
	}

	public void addPheromone(Coordinates coord) {
		field[coord.getX()][coord.getY()] = true;
	}
}
