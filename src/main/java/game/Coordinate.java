package game;

import java.util.Objects;

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
		Coordinate other = (Coordinate) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
	
}