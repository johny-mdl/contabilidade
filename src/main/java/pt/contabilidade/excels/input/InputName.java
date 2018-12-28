package pt.contabilidade.excels.input;

public enum InputName {
	COMM, COMM_CAUTION;

	public static InputName getName(String name) {
		switch (name) {
		case "COMM":
			return COMM;
		case "COMM CAUTION":
			return COMM_CAUTION;
		default:
			return null;
		}
	}
}
