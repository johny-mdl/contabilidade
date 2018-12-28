package pt.contabilidade.excels.motorRegras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import pt.contabilidade.excels.Excel;
import pt.contabilidade.excels.input.Input;
import pt.contabilidade.excels.input.InputName;
import pt.contabilidade.util.ContabilidadeException;
import pt.contabilidade.util.ExcelUtils;

public class MotorRegras extends Excel<Regra> {

	// private Map<String, Integer> posicaoRegra = new HashMap<>();
	//
	// private Integer posicao = 0;

	public MotorRegras(final Sheet sheet) throws ContabilidadeException {
		super(sheet);
		rows = criarRows(sheet);
	}

	@Override
	public int headerRow() {
		return 3;
	}

	@Override
	public int initColumn() {
		return 1;
	}

	@Override
	public List<String> headerNames() {
		return Arrays.asList("Text", "Type Pièce", "GL", "Code TVA", "PC", "Obs,", "Center", "Matching text");

	}

	@Override
	protected List<Regra> criarRows(final Sheet sheet) {
		List<Regra> regras = new ArrayList<>();

		for (int r = headerRow() + 1; r < sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);

			try {
				if (row != null && row.getCell(1) != null) {
					regras.add(new Regra(InputName.getName(ExcelUtils.getString(row.getCell(1))),
							ExcelUtils.getString(row.getCell(2)), ExcelUtils.getString(row.getCell(3)),
							ExcelUtils.getString(row.getCell(4)), ExcelUtils.transformToString(row.getCell(5)),
							ExcelUtils.transformToString(row.getCell(6)),
							Center.getCenter(ExcelUtils.transformToString(row.getCell(7))),
							new HashSet<>(Arrays.asList(ExcelUtils.transformToString(row.getCell(8)).split(",")))));

					// posicaoRegra.put(ExcelUtils.getString(row.getCell(1)), posicao++);
				}
			} catch (Exception e) {
				System.out.println(r);
			}
		}

		return regras;
	}

	public Regra findRegra(final Input input) {
		return rows.stream().filter(regra -> regra.getMatching_text().contains(input.getMatchingText())
				&& regra.getText().equals(input.getInput_name())).findAny().orElse(null);

		// for (Regra regra : rows) {
		// if (regra.getMatching_text().contains(inputMatchingText)) {
		// return regra;
		// }
		// }
		// return null;

	}

	// public Integer findPosicaoRegra(final String input) {
	// switch (input) {
	// case "FB":
	// return posicaoRegra.get("COMM");
	// case "TVA/FB":
	// return posicaoRegra.get("TVA");
	// case "TVAFB":
	// return posicaoRegra.get("TVA");
	// default:
	// return null;
	// }
	//
	// }

}
