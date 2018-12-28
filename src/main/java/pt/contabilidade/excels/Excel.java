package pt.contabilidade.excels;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import pt.contabilidade.util.ContabilidadeException;

public abstract class Excel<P> {

	protected List<P> rows = new ArrayList<>();

	public Excel(final Sheet sheet) throws ContabilidadeException {
		if (!validaHeader(sheet.getRow(headerRow()))) {
			throw new ContabilidadeException("Excel em formato errado");
		}
	}

	public List<P> getRows() {
		return rows;
	}

	protected boolean validaHeader(Row row) {
		int j = 0;

		for (int i = initColumn(); i < lastColumn(); i++) {
			if (!row.getCell(i).getStringCellValue().trim().equals(headerNames().get(j++).trim())) {
				return false;
			}
		}
		return true;
	}

	protected abstract int headerRow();

	protected abstract int initColumn();

	protected int lastColumn() {
		return headerNames().size() - 1;
	};

	protected abstract List<String> headerNames();

	protected abstract List<P> criarRows(final Sheet sheet);
}
