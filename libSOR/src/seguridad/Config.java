package seguridad;

public class Config {
	private static boolean cifradoAsimetrico = true;
	private static boolean cifradoSimetrico = true;
	
	public static boolean isCifradoAsimetrico() {
		return cifradoAsimetrico;
	}
	public static void setCifradoAsimetrico(boolean cifradoAsimetricoOn) {
		Config.cifradoAsimetrico = cifradoAsimetricoOn;
	}
	public static boolean isCifradoSimetrico() {
		return cifradoSimetrico;
	}
	public static void setCifradoSimetrico(boolean cifradoSimetricoOn) {
		Config.cifradoSimetrico = cifradoSimetricoOn;
	}
}
