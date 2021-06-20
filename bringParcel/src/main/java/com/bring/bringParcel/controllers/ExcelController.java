package com.bring.bringParcel.controllers;

import com.bring.bringParcel.services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/excel")
public class ExcelController {

  @Autowired
  ExcelService excelService;

  @PostMapping("/night-report")
  public ResponseEntity<Void> getFile() {
    excelService.write();

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

//@GetMapping("/download")
//  public ResponseEntity<Resource> getFile() {
//    String filename = "trips" + LocalDate.now() + ".xls";
//    InputStreamResource file = new InputStreamResource(excelService.load());
//    return ResponseEntity.ok()
//        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
//        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
//        .body(file);
//  }
}
