package cv1;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Invoice extends JFrame {

	private JTable table;
	private JPanel panel;
	private JScrollPane js;

	


	public Invoice() throws Exception {
		initialize();
	}

	private void initialize() throws Exception {
		setVisible(true);
		setBounds(100, 100, 1044, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblMaterials = new JLabel("Materials & Services Invoice");
		lblMaterials.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblMaterials.setBounds(389, 13, 334, 62);
		getContentPane().add(lblMaterials);
		
		panel = new JPanel();
		panel.setBounds(68, 72, 900, 600);
		getContentPane().add(panel);
		
		table = new JTable();
		js = new JScrollPane(table);
		js.setPreferredSize(new Dimension(900, 600));
		
		js.setVisible(true);
		panel.add(js);

		String columnsName[] = { "ID", "Name", "Unit", "Price", "Quantity", "Total" };

		
		InvoiceData idObj = new InvoiceData();
		Object[][] materialData = idObj.MaterialArray();
		DefaultTableModel dt = new DefaultTableModel(materialData, columnsName);
		
		//Find Total Bill Amount
//		int totalBillAmount=0;
//		for(int i=0; i<idObj.materialNo;i++)
//		{
//			totalBillAmount+=(int)materialData[i][5];
//		}
		

		table.setModel(dt);
		table.setBounds(12, 110, 1002, 476);
		table.setRowHeight(30);
		
		JLabel lblTotalBillAmount = new JLabel("Total Bill Amount");
		lblTotalBillAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalBillAmount.setBounds(205, 698, 164, 26);
		getContentPane().add(lblTotalBillAmount);
		
		JLabel label = new JLabel(""+idObj.totalBillAmount);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(436, 698, 113, 26);
		getContentPane().add(label);
		
		
		
		
		
	}
}
