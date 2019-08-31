package buySome;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class InvoiceData {

	int materialNo = 67;
	int id[] = new int[materialNo];
	String name[] = new String[materialNo];
	String unit[] = new String[materialNo];
	double price[] = new double[materialNo];
	int qty[] = new int[materialNo];
	double total[] = new double[materialNo];
	double totalBillAmount=0;
	Data dataObject = new Data();
	
	
	
	public Object[][] MaterialArray() throws Exception {
				
		Object dataMaterial[][] = dataObject.MaterialArray();
//		for(int i=0; i<61;i++)
//		{
//			for(int j=0;j<6;j++)
//			{
//				System.out.println(dataMaterial[i][j]);
//			}
//		}
		
		Object material[][] = new Object[materialNo][6];//ID, Name, Unit, Price, Qty, Total
		try {
			String strFile = "src/INVOICE.csv";

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int counter = 0;

			while ((strLine = br.readLine()) != null) {
				st = new StringTokenizer(strLine, ",");

				while (st.hasMoreTokens() && counter < materialNo) {
						id[counter] = Integer.parseInt(st.nextToken());
						material[counter][0] = (Object) id[counter];
					
						name[counter] = (String) dataMaterial[id[counter]-1][1];
						material[counter][1] = (Object) name[counter];

						unit[counter] = (String) dataMaterial[id[counter]-1][2];
						material[counter][2] = (Object) unit[counter];

						price[counter] = (double) dataMaterial[id[counter]-1][3];
						material[counter][3] = (Object)price[counter];
						
						qty[counter] = Integer.parseInt(st.nextToken());
						material[counter][4] = (Object)qty[counter];
						
						total[counter] = Double.parseDouble(st.nextToken());
						material[counter][5] = (Object)total[counter];
						
						totalBillAmount+=total[counter];

					counter++;
				}

			}

		} catch (Exception e) {
			System.out.println("Exception while reading the file : " + e);
		}

		return material;
	}
	
	public static void main(String[] args) throws Exception {
		InvoiceData obj = new InvoiceData();
		Object[][] x = obj.MaterialArray();
		for(int i=0; i<obj.materialNo;i++)
		{
			for(int j=0;j<6;j++)
			{
				System.out.println(x[i][j]);
			}
		}
	}

}
