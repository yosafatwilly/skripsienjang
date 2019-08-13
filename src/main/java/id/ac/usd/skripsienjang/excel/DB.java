package id.ac.usd.skripsienjang.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import id.ac.usd.skripsienjang.model.DataMentah;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DB {

    public List<DataMentah> bacaData;

    public DB() {
        this.bacaData = new ArrayList<>();
//        this.bacaData.addAll(readExcel("F:\\Enjang\\data mentah\\margin penj jan 2017.xlsx"));
//        this.bacaData.addAll(readExcel("F:\\Enjang\\data mentah\\margin penj pebr 2017.xlsx"));
//        this.bacaData.addAll(readExcel("F:\\Enjang\\data mentah\\margin penj maret 2017.xlsx"));
//        this.bacaData.addAll(readExcel("F:\\Enjang\\data mentah\\margin penj april 2017.xlsx"));
        this.bacaData.addAll(readExcel("D:\\a.xlsx"));

    }

    public List<DataMentah> readExcel(String excelPath) {
        List<DataMentah> bacaData = new ArrayList<>();
        try {
            InputStream input = new FileInputStream(excelPath);
            Workbook workbook = WorkbookFactory.create(input);
            Sheet sheet = workbook.getSheetAt(0);
            int baris = 1, kolom = 1;
            for (Row row : sheet) {
                DataMentah dataMentah = new DataMentah();
                for (Cell cell : row) {
                    if (row.getRowNum() > 3) {
                        if (cell.getColumnIndex() == 1) {
                            dataMentah.setNamaBarang(cell.getStringCellValue());
                        } else if (cell.getColumnIndex() == 3) {
                            dataMentah.setNoStruk(cell.getStringCellValue());
                        } else if (cell.getColumnIndex() == 4) {
                            dataMentah.setTanggal(cell.getStringCellValue());
                        }
                        kolom++;
                    }
                }
                if (dataMentah.getNoStruk() != null || dataMentah.getNamaBarang() != null) {
                    bacaData.add(dataMentah);
                }
                baris++;
            }
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return bacaData;
    }
}
