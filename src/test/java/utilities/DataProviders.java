package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
public String[][] getData() throws IOException{
	String path = ".\\testData\\LoginData.xlsx";
	
	ExcelUtility xlutility = new ExcelUtility(path);
	
	int totalrows =xlutility.getRowCount("Sheet1");
	int totalcols=xlutility.getCellCount("Sheet1", 1);
	String loginData[][] = new String[totalrows][totalcols];
	
	for(int i=1; i<=totalrows;i++) {
		for(int j=0;j<totalcols;j++){
			loginData[i-1][j]= xlutility.getCellData("sheet1", i, j);
					}
	}
	return loginData;
	
	
}

}

//Dataprovider 2
//Dataprovider 3
//datprovider 4
// so we can add the data provider with different data sheets
