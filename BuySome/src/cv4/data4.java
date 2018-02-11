package cv4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class data4 {

	private int materialNo = 67;
	int id[] = new int[materialNo];
	String name[] = new String[materialNo];
	String unit[] = new String[materialNo];
	double price[] = new double[materialNo];
	double max[] = new double[materialNo];
	double percent[] = new double[materialNo];
	Object material[][] = new Object[materialNo][6];//id, name, unit, price, max, percent
	
	
	public Object[][] MaterialArray() throws Exception {
		
		try {
			String strFile = "src/CIVIL4.csv";

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int counter = 0;

			while ((strLine = br.readLine()) != null) {
				st = new StringTokenizer(strLine, ",");

				while (st.hasMoreTokens() && counter < materialNo) {
						id[counter] = counter+1;
						material[counter][0] = id[counter];
					
						name[counter] = st.nextToken();
						material[counter][1] = name[counter];

						unit[counter] = st.nextToken();
						material[counter][2] = unit[counter];

						price[counter] = Double.parseDouble(st.nextToken());
						material[counter][3] = (Object)price[counter];

						max[counter] = Double.parseDouble(st.nextToken());
						material[counter][4] = null;

						percent[counter] = Double.parseDouble(st.nextToken());
						material[counter][5] = null;


					counter++;
				}

			}

		} catch (Exception e) {
			System.out.println("Exception while reading the file : " + e);
		}

		return material;
	}
	
	public static void main(String[] args) throws Exception {
		data4 obj = new data4();
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
