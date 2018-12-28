package pt.contabilidade.excels.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import pt.contabilidade.excels.Excel;
import pt.contabilidade.util.ContabilidadeException;
import pt.contabilidade.util.ExcelUtils;

public class InputCommCautionExcel extends Excel<InputCommCaution> {

	public InputCommCautionExcel(Sheet sheet) throws ContabilidadeException {
		super(sheet);
		rows = criarRows(sheet);
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
		return Arrays.asList("Assignment", "Reference", "Account", "Document Number", "Document Type", "Document Date",
				"Posting Date", "Amount in local currency", "Amount in doc. curr.", "Text", "wbs", "cost center");
	}

	@Override
	protected List<InputCommCaution> criarRows(Sheet sheet) {
		List<InputCommCaution> rows = new ArrayList<>();

		for (int r = headerRow() + 1; r < sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);

			try {
				rows.add(new InputCommCaution(ExcelUtils.transformToString(row.getCell(0)),
						ExcelUtils.transformToString(row.getCell(1)), ExcelUtils.transformToString(row.getCell(2)),
						ExcelUtils.transformToString(row.getCell(3)), ExcelUtils.transformToString(row.getCell(4)),
						row.getCell(5).getDateCellValue(), row.getCell(5).getDateCellValue(),
						row.getCell(7).getNumericCellValue(), row.getCell(8).getNumericCellValue(),
						ExcelUtils.transformToString(row.getCell(9)), ExcelUtils.transformToString(row.getCell(10)),
						ExcelUtils.transformToString(row.getCell(11))));

			} catch (Exception e) {
				System.out.println(e);
			}

			// if (regras.containsKey(row.getCell(0).getStringCellValue())) {
			// regras.get(row.getCell(0).getStringCellValue()).add(regra);
			// } else {
			// regras.put(row.getCell(0).getStringCellValue(), new
			// HashSet<>(Arrays.asList(regra)));
			// }
		}

		return rows;
	}

}
