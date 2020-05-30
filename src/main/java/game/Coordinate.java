package game;

final class Coordinate {
	
	private final int x;
	private final int y;
	
	protected Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x() {
		return x;
	}

	int y() {
		return y;
	}
	
	
}