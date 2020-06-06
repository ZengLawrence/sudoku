package game;

import java.util.Objects;

/**
 * Space on the board to fill number 1 to 9.  It has coordinate system of x for row and y for column.
 */
final class Square {
	
	private final int x;
	private final int y;
	
	protected Square(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x() {
		return x;
	}

	int y() {
		return y;
	}

	Row row() {
		return new Row(x);
	}
	
	Column column() {
		return new Column(y);
	}
	
	Box box() {
		return Box.box(this);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
	
}