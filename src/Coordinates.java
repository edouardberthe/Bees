
public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Coordinates coordinates) {
		return this.x == coordinates.x && this.y == coordinates.y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void addX(int x) {
		this.x += x;
	}
	
	public void addY(int y) {
		this.y += y;
	}
	
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}
	
	public static Coordinates random () {
		return new Coordinates((int) (Math.random() * 1000), (int) (Math.random() * 400));
	}
	
	public double distance(Coordinates coordinates) {
		return Math.sqrt(Math.pow(x - coordinates.getX(), 2) + Math.pow(y - coordinates.getY(),2));
	}
}
