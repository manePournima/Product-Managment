package com.example.demo.exportImportModule;

	

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/api/excel")
	public class ExcelFileReadController {

	    @Autowired
	    private ExcelFileReadService excelFileReadService;

	    @GetMapping("/process")
	    public String processExcelFiles() {
	        String folderPath = "src/data";
	        String outputPath = "src/data/combined_output.xlsx";
	        excelFileReadService.processExcelFiles(folderPath, outputPath);
	        return "Excel files processed successfully.";
	    }
	

}
