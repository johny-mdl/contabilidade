package pt.contabilidade.excels.input;

import java.util.Date;

public class InputComm extends Input {

	public InputComm(String gl_account, String reference, String doc_type, String doc_number, Date doc_date,
			Date posting_date, Double amount_doc, Double amount_local_curr, String text, String assignement) {
		super(InputName.COMM, gl_account, reference, doc_type, doc_number, doc_date, posting_date, amount_doc,
				amount_local_curr, text, assignement);

	}

}
