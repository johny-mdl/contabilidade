package pt.contabilidade.excels.motorRegras;

public enum Center {
	COST, PROFIT, DIVERS;

	public static Center getCenter(String center) {
		switch (center) {
		case "cost":
			return COST;
		case "profit":
			return PROFIT;
		case "divers":
			return DIVERS;
		default:
			return null;
		}
	}
}
