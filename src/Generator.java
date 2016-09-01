public class Generator extends Thread {

	private static double rate = 0.001;
	
	public void run() {
		try {
			while (true) {
				Thread.sleep((int) (Math.random() / rate) + 1000);
				World.getWorld().addFLower(new Flower(Coordinates.random()));
			}
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
