package pt.contabilidade.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelUtils {

	public static Object getValue(Cell cell) {
		switch (cell.getCellTypeEnum()) {
		case BOOLEAN:
			return cell.getBooleanCellValue();
		case STRING:
			return cell.getRichStringCellValue().getString().trim();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			} else {
				return cell.getNumericCellValue();
			}
		case FORMULA:
			return cell.getCellFormula();
		case BLANK:
			return "";
		default:
			return "";
		}

	}

	public static String transformToString(Cell cell) {
		if (cell == null) {
			return "";
		}
		if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
			return String.valueOf(cell.getNumericCellValue()).trim();
		} else if (cell.getCellTypeEnum().equals(CellType.STRING)) {
			return cell.getStringCellValue().trim();
		} else {
			return "";
		}
	}

	public static String getString(Cell cell) {
		if (cell == null) {
			return "";
		}
		if (cell.getCellTypeEnum().equals(CellType.STRING)) {
			return cell.getStringCellValue().trim();
		} else {
			return "";
		}
	}

	public static Double getNumeric(Cell cell) {
		if (cell == null) {
			return null;
		}
		if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
			return cell.getNumericCellValue();
		} else {
			return null;
		}
	}
}
