package towers;

public class Ring {
	
	private int size;

	public Ring(int size) {
		if (size < 1) {
			throw new RuntimeException("Ring size must be > 0");
		}
		this.size = size;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += "_";
		}
		s += "|" + s;
		return s;
	}

}


