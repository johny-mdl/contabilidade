package pt.contabilidade.excels.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import pt.contabilidade.excels.Excel;
import pt.contabilidade.util.ContabilidadeException;

public class InputCommExcel extends Excel<InputComm> {

	public InputCommExcel(Sheet sheet) throws ContabilidadeException {
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
		return Arrays.asList("G/L Account", "Reference", "Document Type", "Document Number", "Document Date",
				"Posting Date", "Amount in doc. curr.", "Amount in local currency", "Text", "Assignment");
	}

	@Override
	protected List<InputComm> criarRows(Sheet sheet) {
		List<InputComm> rows = new ArrayList<>();

		for (int r = headerRow() + 1; r < sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);

			try {
				rows.add(new InputComm(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(),
						row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(),
						row.getCell(4).getDateCellValue(), row.getCell(5).getDateCellValue(),
						row.getCell(6).getNumericCellValue(), row.getCell(7).getNumericCellValue(),
						row.getCell(8).getStringCellValue(), row.getCell(9).getStringCellValue()));

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
