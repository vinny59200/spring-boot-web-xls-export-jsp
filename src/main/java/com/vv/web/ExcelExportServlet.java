package com.vv.web;

import com.vv.domain.TdoVV;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
import java.io.OutputStream;

public class ExcelExportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        List<TdoVV> pageList = (List<TdoVV>) session.getAttribute("pageList");

        if (pageList == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No data to export");
            return;
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=export.xlsx");

        try (
                XSSFWorkbook workbook = new XSSFWorkbook();
                OutputStream out = response.getOutputStream()
        ) {
            XSSFSheet sheet = workbook.createSheet("VV Data");
            XSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Codification");
            headerRow.createCell(1).setCellValue("Model");
            headerRow.createCell(2).setCellValue("Quantity");
            headerRow.createCell(3).setCellValue("Measure Unit");

            int rowNum = 1;
            for (TdoVV vv : pageList) {
                XSSFRow row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(vv.getCodification());
                row.createCell(1).setCellValue(vv.getModel());
                row.createCell(2).setCellValue(vv.getQuantity());
                row.createCell(3).setCellValue(vv.getMeasureUnit());
            }

            workbook.write(out);
        }
    }
}

