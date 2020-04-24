package com.client.generic;

public class RobotInCircle {

	public static void main(String... args) {
		String s = "L";
		int d = 0, x = 0, y = 0;
		for (char c : s.toCharArray()) {
			if (c == 'R') {
				d = (d + 1) % 4;
			} else if (c == 'L') {
				d = (4 + d - 1) % 4;
			} else {
				switch (d) {
				case 0:
					x++;
					break;
				case 1:
					y++;
					break;
				case 2:
					x--;
					break;
				case 3:
					y--;
					break;
				}
			}

		}
		System.out.println(x == 0 && y == 0);
	}

}
