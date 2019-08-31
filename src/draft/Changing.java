package draft;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Changing {

	private int materialNo = 61;
	int id[] = new int[materialNo];
	int id1[] = new int[materialNo];
	String name[] = new String[materialNo];
	String name1[] = new String[materialNo];
	String unit[] = new String[materialNo];
	String unit1[] = new String[materialNo];
	double price[] = new double[materialNo];
	double price1[] = new double[materialNo];
	double max[] = new double[materialNo];
	double percent[] = new double[materialNo];
	Object material[][] = new Object[materialNo][6];//id, name, unit, price, max, percent
	
	
	public Object[][] MaterialArray() throws Exception {
		
		try {
			String strFile = "src/CIVIL.csv";

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int counter = 0;

			while ((strLine = br.readLine()) != null) {
				st = new StringTokenizer(strLine, ",");

				while (st.hasMoreTokens() && counter < materialNo) {
						id[counter] = counter+1;
						id1[counter] = id[counter];
						material[counter][0] = id[counter];
					
						name[counter] = st.nextToken();
						name1[counter] = name[counter];
						material[counter][1] = name[counter];

						unit[counter] = st.nextToken();
						unit1[counter] = unit[counter];
						material[counter][2] = unit[counter];

						price[counter] = Double.parseDouble(st.nextToken());
						price1[counter] = price[counter];
						material[counter][3] = (Object)price[counter];

						max[counter] = Double.parseDouble(st.nextToken());
						material[counter][4] = null;

						percent[counter] = Double.parseDouble(st.nextToken());
						material[counter][5] = null;


					counter++;
				}

			}
			changeData();

		} catch (Exception e) {
			System.out.println("Exception while reading the file : " + e);
		}

		return material;
	}
	
	public void changeData() {
		try {
			String strFile = "src/CIVIL2.csv";

			@SuppressWarnings("resource")
			PrintWriter pw = new PrintWriter(strFile);
			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;
			int counter = 0;

			
			while ((strLine = br.readLine()) != null) {
				st = new StringTokenizer(strLine, ",");

				while (st.hasMoreTokens() && counter < materialNo) {

					if(price1[counter]<max[counter]) {
						price1[counter] = price1[counter] + (price1[counter])*(percent[counter]/100);
					}
					pw.write(""+id[counter]+","+name[counter]+","+unit[counter]+","+price1[counter]+","+max[counter]+","+percent[counter]);
					counter++;
				}

			}

		} catch (Exception e) {
			System.out.println("Exception while reading the file : " + e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Changing obj = new Changing();
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
