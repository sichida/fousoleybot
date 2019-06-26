package fousoleybot.sensor;

public enum ColorEnum {
	RED(0), GREEN(1), BLUE(2), YELLOW(3), MAGENTA(4), ORANGE(5), WHITE(6), BLACK(7), PINK(8), GRAY(9), LIGHT_GRAY(10),
	DARK_GRAY(11), CYAN(12), BROWN(13), NONE(-1);

	private final int color;

	private ColorEnum(int color) {
		this.color = color;
	}

	public static ColorEnum fromColorId(int colorID) {
		switch (colorID) {
		case 0:
			return ColorEnum.RED;
		case 1:
			return ColorEnum.GREEN;
		case 2:
			return ColorEnum.BLUE;
		case 3:
			return ColorEnum.YELLOW;
		case 4:
			return ColorEnum.MAGENTA;
		case 5:
			return ColorEnum.ORANGE;
		case 6:
			return ColorEnum.WHITE;
		case 7:
			return ColorEnum.BLACK;
		case 8:
			return ColorEnum.PINK;
		case 9:
			return ColorEnum.GRAY;
		case 10:
			return ColorEnum.LIGHT_GRAY;
		case 11:
			return ColorEnum.DARK_GRAY;
		case 12:
			return ColorEnum.CYAN;
		case 13:
			return ColorEnum.BROWN;
		case -1:
		default:
			return ColorEnum.NONE;
		}
	}

}
