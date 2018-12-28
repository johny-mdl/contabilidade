package pt.contabilidade.excels.output;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

import pt.contabilidade.excels.Excel;
import pt.contabilidade.util.ContabilidadeException;

public class OutputExcel extends Excel<Output> {

	public OutputExcel(Sheet sheet) throws ContabilidadeException {
		super(sheet);
	}

	@Override
	protected int headerRow() {
		return 0;
	}

	@Override
	protected int initColumn() {
		return 0;
	}

	@Override
	protected List<String> headerNames() {
		return Arrays.asList("Grouping Number", "Document Date", "Reference", "GL Account", "Vendor Number",
				"Special GL Indicator", "Debit Amount", "Credit Amount", "Payment Terms", "Baseline Date",
				"Payment Method", "Tax Code", "Trading Partner", "Cost Center", "WBS Element", "Work report",
				"Purchase Order", "Purchase Order Item", "Profit Center", "Line Item Text", "Development Code",
				"Sales Order No", "Sales Order Item", "Network No", "Network Activity No", "Customer Number",
				"Allocation");
	}

	@Override
	protected List<Output> criarRows(Sheet sheet) {
		// TODO Auto-generated method stub
		return null;
	}

}
