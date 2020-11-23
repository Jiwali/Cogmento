package com.cogmento.testautomation.web.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil extends TestBase {
	public Object[][] get_testdata(String sheetName) throws InvalidFormatException, IOException {
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + props.getProperty("excelpath"));
		Workbook wk = WorkbookFactory.create(file);
		Sheet sheet2 = wk.getSheet(sheetName);
		int tot_row = sheet2.getLastRowNum();
		int tot_col = sheet2.getRow(0).getLastCellNum();
		Object[][] obj = new Object[tot_row][tot_col];
		for (int i = 0; i < tot_row; i++) {
			for (int j = 0; j < tot_col; j++) {
				obj[i][j] = sheet2.getRow(i + 1).getCell(j).toString();
			}
		}
		return obj;
	}

}
