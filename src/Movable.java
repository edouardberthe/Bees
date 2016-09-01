
public abstract class Movable implements Printable {
	
	public boolean isAt(Printable printable) {
		return getCoordinates().distance(printable.getCoordinates()) < printable.getSize();
	}
}
