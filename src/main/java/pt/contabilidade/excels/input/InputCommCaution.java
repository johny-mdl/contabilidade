package pt.contabilidade.excels.input;

import java.util.Date;

public class InputCommCaution extends Input {

	private String wbs;
	private String cost_center;

	public InputCommCaution(String gl_account, String reference, String doc_type, String doc_number, Date doc_date,
			Date posting_date, Double amount_doc, Double amount_local_curr, String text, String assignement, String wbs,
			String cost_center) {
		super(InputName.COMM_CAUTION, gl_account, reference, doc_type, doc_number, doc_date, posting_date, amount_doc,
				amount_local_curr, text, assignement);
		this.wbs = wbs;
		this.cost_center = cost_center;
	}

	public String getWbs() {
		return wbs;
	}

	public void setWbs(String wbs) {
		this.wbs = wbs;
	}

	public String getCost_center() {
		return cost_center;
	}

	public void setCost_center(String cost_center) {
		this.cost_center = cost_center;
	}

}
