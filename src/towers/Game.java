package towers;

import java.util.Scanner;
import java.util.Stack;

public class Game {

	private Stack<Ring> left, middle, right;
	private int height;
	private int baseSize;
	private boolean isSolved;

	public Game(int height) {
		this.height = height;
		this.baseSize = height * 2 + 3;
		left = new Stack<Ring>();
		middle = new Stack<Ring>();
		right = new Stack<Ring>();
		for (int i = height; i >= 1; i--) {
			left.add(new Ring(i));
		}
		this.isSolved = false;
	}

	/**
	 * 0 - left
	 * 1 - middle
	 * 2 - right
	 * @param from
	 * @param to
	 */
	public void move(int from, int to) {
		if (from == to || from > 2 || to > 2 || from < 0 || to < 0) return;
		Stack<Ring> fromStack, toStack;
		fromStack = from == 0 ? left : from == 1 ? middle : right;
		toStack = to == 0 ? left : to == 1 ? middle : right;
		if (fromStack.size() == 0 || (toStack.size() > 0 && fromStack.peek().size() > toStack.peek().size())) return;

		toStack.add(fromStack.pop());
		System.out.println(this);

		if (right.size() == height) isSolved = true;
	}

	public void solveTower() {
		if (isSolved) return;
		solveTowerHelper(height, left, middle, right);
		isSolved = true;
	}

	private void solveTowerHelper(int height, Stack<Ring> start, Stack<Ring> aux, Stack<Ring> end) {
		if (height < 1) return ;
		if (height == 1) {
			end.add(start.pop());
			System.out.println(this);
		} else {
			solveTowerHelper(height - 1, start, end, aux);
			end.add(start.pop());
			System.out.println(this);
			solveTowerHelper(height - 1, aux, start, end);
		}
	}

	private String ringString(Stack<Ring> stack, int i) {
		String s = "";
		String ring = stack.size() > i ? stack.get(i).toString() : "|";
		int spacing = (baseSize - ring.length()) / 2;
		for (int j = 0; j < spacing; j++) {
			s += " ";
		}
		return s + ring + s;
	}

	public boolean isSolved() {
		return isSolved;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = height - 1; i >= 0; i--) {

			s += ringString(left, i) + " ";

			s += ringString(middle, i) + " ";

			s += ringString(right, i) + "\n";
		}
		String base = "";
		for (int i = 0; i < baseSize; i++) {
			//base += Math.abs(baseSize/2 - i) <= 1 ? "=" : " ";
			base += "=";
		}
		base += " " + base + " " + base;
		return s + base;
	}

}


