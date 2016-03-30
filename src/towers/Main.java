package towers;

import java.util.Scanner;

public class Main {
	
	public static final boolean AUTO_SOLVE = true; // False to play manually

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Game towers = new Game(3);
		System.out.println(towers);
		
		
		if (AUTO_SOLVE) towers.solveTower();
		
		
		while (!towers.isSolved()) {
			towers.move(in.nextInt(), in.nextInt());
		}

		in.close();
	}

}


