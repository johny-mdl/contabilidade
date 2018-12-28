package pt.contabilidade.excels.motorRegras;

public enum Center {
	COST, PROFIT;

	public static Center getCenter(String center) {
		switch (center) {
		case "cost":
			return COST;
		case "profit":
			return PROFIT;
		default:
			return null;
		}
	}
}
