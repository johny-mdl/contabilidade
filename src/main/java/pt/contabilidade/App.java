package pt.contabilidade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pt.contabilidade.excels.input.InputComm;
import pt.contabilidade.excels.input.InputCommCaution;
import pt.contabilidade.excels.input.InputCommCautionExcel;
import pt.contabilidade.excels.input.InputCommExcel;
import pt.contabilidade.excels.motorRegras.MotorRegras;
import pt.contabilidade.excels.motorRegras.Regra;
import pt.contabilidade.excels.output.Output;
import pt.contabilidade.excels.output.Transaction;
import pt.contabilidade.util.ContabilidadeException;

public class App {

	private static final String FILE_NAME_REGRAS = "regras.xlsx";
	private static final String FILE_NAME_INPUT_COMM = "COMM.xlsx";
	private static final String FILE_NAME_INPUT_COMM_CAUTION = "COMM_CAUTION.xlsx";
	private static final String FILE_NAME_OUTPUT = "output_empty.xls";

	public static void main(String[] args) {

		try {
			FileInputStream excelFileRegras = new FileInputStream(new File(FILE_NAME_REGRAS));
			Workbook workbookRegras = new XSSFWorkbook(excelFileRegras);
			Sheet sheetRegras = workbookRegras.getSheetAt(0);

			FileInputStream excelFileComm = new FileInputStream(new File(FILE_NAME_INPUT_COMM));
			Workbook workbookOrigemComm = new XSSFWorkbook(excelFileComm);
			Sheet sheetOrigemComm = workbookOrigemComm.getSheetAt(0);

			FileInputStream excelFileCommCaution = new FileInputStream(new File(FILE_NAME_INPUT_COMM_CAUTION));
			Workbook workbookOrigemCommCaution = new XSSFWorkbook(excelFileCommCaution);
			Sheet sheetOrigemCommCaution = workbookOrigemCommCaution.getSheetAt(0);

			Workbook workbookOutput = WorkbookFactory.create(new File(FILE_NAME_OUTPUT));
			Sheet sheetOutput = workbookOutput.getSheetAt(0);

			try {
				MotorRegras motorRegras = new MotorRegras(sheetRegras);
				List<Output> outputs = new ArrayList<>();

				if (false) {
					List<InputComm> inputs = new InputCommExcel(sheetOrigemComm).getRows();
					List<InputComm> inputsFalhados = new ArrayList<>();

					for (InputComm input : inputs) {
						Regra regra = motorRegras.findRegra(input);
						if (regra == null) {
							inputsFalhados.add(input);
							continue;
						}
						Transaction transaction = new Transaction(input, regra);
						outputs.addAll(
								Arrays.asList(transaction.getCreditTransaction(), transaction.getDebitTransaction()));
					}

					System.out.println("Inputs totais: " + inputs.size());
					System.out.println("Inputs falhados: " + inputsFalhados.size());
					System.out.println("Inputs processados: " + outputs.size() / 2);
				}

				List<InputCommCaution> inputs = new InputCommCautionExcel(sheetOrigemCommCaution).getRows();
				List<InputCommCaution> inputsFalhados = new ArrayList<>();

				for (InputCommCaution input : inputs) {
					Regra regra = motorRegras.findRegra(input);
					if (regra == null) {
						inputsFalhados.add(input);
						continue;
					}
					Transaction transaction = new Transaction(input, regra);
					outputs.addAll(
							Arrays.asList(transaction.getCreditTransaction(), transaction.getDebitTransaction()));
				}

				System.out.println("Inputs totais: " + inputs.size());
				System.out.println("Inputs falhados: " + inputsFalhados.size());
				System.out.println("Inputs processados: " + outputs.size() / 2);

				int rowCount = sheetOutput.getLastRowNum();

				for (Output out : outputs) {
					Row row = sheetOutput.createRow(++rowCount);
					out.populateRow(row);
				}

				FileOutputStream fileOut = new FileOutputStream("output.xls");
				workbookOutput.write(fileOut);
				fileOut.close();

			} catch (ContabilidadeException e) {
				System.out.println(e);
			} finally {
				// Closing the workbook
				workbookOrigemComm.close();
				workbookOrigemCommCaution.close();
				workbookRegras.close();
				workbookOutput.close();
			}
		} catch (IOException | EncryptedDocumentException | InvalidFormatException e) {
			e.printStackTrace();
		}
	}
}
