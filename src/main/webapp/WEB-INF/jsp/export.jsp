<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*, javax.servlet.*, org.apache.poi.xssf.usermodel.*, java.util.*, java.util.stream.*" %>
<%@ page import="com.vv.domain.TdoVV" %>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
<h1>Welcome to Spring Boot JSP!</h1>


<form name="form-export" id="form-export" method="POST">
	<input type="hidden" name="exportExcel" id="exportExcel" value="false">
	<div id="export">
		<%
			// Create dummy data for pageList
			// Create dummy data using traditional List approach
			List<TdoVV> pageList = new ArrayList<>();
			pageList.add(new TdoVV("ABC123", "Model X", 10, "Units"));
			pageList.add(new TdoVV("DEF456", "Model Y", 20, "Pieces"));
			pageList.add(new TdoVV("GHI789", "Model Z", 30, "Kilograms"));


		// Store dummy data in request attribute
			request.setAttribute("pageList", pageList);

			// Check if the request is for export
			String exportFlag = request.getParameter("exportExcel");
			if ("true".equals(exportFlag)) {
				// Retrieve pageList from request
				pageList = (List<TdoVV>) request.getAttribute("pageList");

				// Create an Excel workbook
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("VV Data");

				// Add header row
				XSSFRow headerRow = sheet.createRow(0);
				headerRow.createCell(0).setCellValue("Codification");
				headerRow.createCell(1).setCellValue("Model");
				headerRow.createCell(2).setCellValue("Quantity");
				headerRow.createCell(3).setCellValue("Measure Unit");

				// Populate rows from pageList
				int rowNum = 1;
				for (TdoVV vvData : pageList) {
					XSSFRow row = sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(vvData.getCodification());
					row.createCell(1).setCellValue(vvData.getModel());
					row.createCell(2).setCellValue(vvData.getQuantity());
					row.createCell(3).setCellValue(vvData.getMeasureUnit());
				}

				// Set response headers for file download
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=export.xlsx");

				OutputStream out2 = response.getOutputStream();
				workbook.write(out2);
				workbook.close();
				out2.close();
				return; // Prevent further JSP rendering
			}
		%>

		<button onclick="document.getElementById('exportExcel').value='true'; document.forms['form-export'].submit();">Export to Excel</button>
	</div>
</form>
</body>
</html>

