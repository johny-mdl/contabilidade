package pt.contabilidade.excels.output;

import pt.contabilidade.excels.input.Input;
import pt.contabilidade.excels.motorRegras.Center;
import pt.contabilidade.excels.motorRegras.Regra;

public class Transaction {

	private Output creditTransaction;
	private Output debitTransaction;
	private static Integer grouping_number = 0;
	private String text;
	private final String alloc = "ALLOC";

	public Transaction() {

	}

	public Transaction(Input input, Regra regra) {
		grouping_number++;
		this.text = input.getText();

		this.creditTransaction = createCreditTransaction(input);
		this.debitTransaction = createDebitTransaction(input, regra);
	}

	private Output createDebitTransaction(Input input, Regra regra) {
		Output debit = new Output();

		debit.setGrouping_Number(grouping_number);
		debit.setGL_Account(regra.getGl());
		debit.setDebit_Amount(String.valueOf(input.getAmount_in_doc_curr()));
		debit.setTax_Code("IX"); // TODO tirar este martelanço, isto é para quando o IVA esta separado

		if (regra.getCenter().equals(Center.COST)) {
			debit.setCost_Center(regra.getPc());
		} else if (regra.getCenter().equals(Center.PROFIT)) {
			debit.setProfit_Center(regra.getPc());
		}

		debit.setLine_Item_Text(text);
		debit.setAllocation(alloc);

		return debit;
	}

	private Output createCreditTransaction(Input input) {
		Output credit = new Output();

		credit.setGrouping_Number(grouping_number);
		credit.setGL_Account(input.getAccount());
		credit.setDocument_Date(input.getDocument_Date().toString());
		credit.setCredit_Amount(String.valueOf(input.getAmount_in_doc_curr()));

		credit.setLine_Item_Text(text);
		credit.setAllocation(alloc);

		return credit;
	}

	public Output getCreditTransaction() {
		return creditTransaction;
	}

	public void setCreditTransaction(Output creditTransaction) {
		this.creditTransaction = creditTransaction;
	}

	public Output getDebitTransaction() {
		return debitTransaction;
	}

	public void setDebitTransaction(Output debitTransaction) {
		this.debitTransaction = debitTransaction;
	}

}
