package pt.contabilidade.excels.input;

import java.util.Date;

public class Input {
	private InputName input_name;

	private String reference;
	private String account;
	private String document_Number;
	private String document_Type;
	private Date document_Date;
	private Date posting_Date;
	private Double amount_in_local_currency;
	private Double amount_in_doc_curr;
	private String text;
	private String assignement;
	private String matchingText;

	public Input(InputName input_name, String gl_account, String reference, String doc_type, String doc_number,
			Date doc_date, Date posting_date, Double amount_doc, Double amount_local_curr, String text,
			String assignement) {
		this.input_name = input_name;
		this.account = gl_account;
		this.reference = reference;
		this.document_Type = doc_type;
		this.document_Number = doc_number;
		this.document_Date = doc_date;
		this.posting_Date = posting_date;
		this.amount_in_doc_curr = amount_doc;
		this.amount_in_local_currency = amount_local_curr;
		this.text = text;

		this.assignement = assignement;
		this.matchingText = assignement.substring(0, assignement.indexOf("-"));
	}

	public String getAssignement() {
		return assignement;
	}

	public void setAssignement(String assignement) {
		this.assignement = assignement;
	}

	public String getMatchingText() {
		return matchingText;
	}

	public void setMatchingText(String matchingText) {
		this.matchingText = matchingText;
	}

	public InputName getInput_name() {
		return input_name;
	}

	public void setInput_name(InputName input_name) {
		this.input_name = input_name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDocument_Number() {
		return document_Number;
	}

	public void setDocument_Number(String document_Number) {
		this.document_Number = document_Number;
	}

	public String getDocument_Type() {
		return document_Type;
	}

	public void setDocument_Type(String document_Type) {
		this.document_Type = document_Type;
	}

	public Date getDocument_Date() {
		return document_Date;
	}

	public void setDocument_Date(Date document_Date) {
		this.document_Date = document_Date;
	}

	public Date getPosting_Date() {
		return posting_Date;
	}

	public void setPosting_Date(Date posting_Date) {
		this.posting_Date = posting_Date;
	}

	public Double getAmount_in_local_currency() {
		return amount_in_local_currency;
	}

	public void setAmount_in_local_currency(Double amount_in_local_currency) {
		this.amount_in_local_currency = amount_in_local_currency;
	}

	public Double getAmount_in_doc_curr() {
		return amount_in_doc_curr;
	}

	public void setAmount_in_doc_curr(Double amount_in_doc_curr) {
		this.amount_in_doc_curr = amount_in_doc_curr;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
