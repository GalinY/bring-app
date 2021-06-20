package com.bring.bringParcel.helpers;

import com.bring.bringParcel.entities.Trip;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelHelper {

  static String[] HEADERS = {"ID", "NAME", "ORIGIN", "GATE", "ARRIVAL", "DESTINATION", "PLACES"};
  static String SHEET = "Night report";

  public static void tripsToExcel(List<Trip> trips) {
    try (Workbook workbook = new HSSFWorkbook(); FileOutputStream out = new FileOutputStream(
        createFileName())) {
      Sheet sheet = workbook.createSheet(SHEET);

      Row headerRow = sheet.createRow(0);
      for (int col = 0; col < HEADERS.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERS[col]);
      }

      int rowIndex = 1;
      for (Trip trip : trips) {
        Row row = sheet.createRow(rowIndex++);

        row.createCell(0).setCellValue(trip.getId());
        row.createCell(1).setCellValue(trip.getName());
        row.createCell(2).setCellValue(trip.getOrigin());
        row.createCell(3).setCellValue(trip.getGate());
        row.createCell(4).setCellValue(trip.getArrival());
        row.createCell(5).setCellValue(trip.getDestination());
        row.createCell(6).setCellValue(trip.getPlaces());
//        row.createCell(7).setCellValue(trip.getTimestamp());
      }

      workbook.write(out);
    } catch (IOException e) {
      throw new RuntimeException(
          "Error occurred while updating Excel file! Error message: " + e.getMessage());
    }
  }

  public static String createFileName() {
    return
        "E:\\BringParcelApp\\bringParcel\\bringParcel\\src\\main\\resources\\static\\Night-report-"
            + LocalDate
            .now().minusDays(1) + ".xls";
//    return
//        "F:\\Bring\\Parcels\\PR Production\\PR Jönköping\\PR Hub\\Timestamp arrival\\Traffic-report-"
//            + LocalDate
//            .now().minusDays(1) + ".xls";
  }
}
