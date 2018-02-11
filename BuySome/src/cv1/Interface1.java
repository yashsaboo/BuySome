package cv1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Interface1 {

	private JFrame frame;
	private JTable table;
	private JPanel panel;
	private JScrollPane js;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface1 window = new Interface1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interface1() throws Exception {
		initialize();
	}

	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 1044, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMaterials = new JLabel("Materials & Services");
		lblMaterials.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblMaterials.setBounds(431, 13, 226, 62);
		frame.getContentPane().add(lblMaterials);
		
		panel = new JPanel();
		panel.setBounds(68, 72, 900, 600);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		js = new JScrollPane(table);
		js.setBounds(100, 5, 700, 500);
		js.setPreferredSize(new Dimension(700, 500));
		js.setVisible(true);
		panel.setLayout(null);
		panel.add(js);

		String columnsName[] = {  "ID", "Name", "Unit", "Price"};

		Object[][] materialData = new data1().MaterialArray();
		DefaultTableModel dt = new DefaultTableModel(materialData, columnsName);

		table.setModel(dt);
		table.setBounds(12, 110, 1002, 476);
		table.setRowHeight(30);
		
		JLabel lblName = new JLabel("ID:");
		lblName.setBounds(12, 518, 44, 40);
		panel.add(lblName);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(285, 518, 63, 40);
		panel.add(lblQuantity);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(588, 518, 44, 40);
		panel.add(lblTotal);
		
		textField = new JTextField();
		textField.setBounds(49, 518, 121, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(362, 518, 121, 40);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(644, 518, 121, 40);
		panel.add(textField_2);
				
		
		JButton btnGenerateBill = new JButton("Add To Cart And Generate Bill");
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				int Id = Integer.parseInt(textField.getText());  
				int Qty = Integer.parseInt(textField_1.getText());
				double total = Double.parseDouble(textField_2.getText());
				
				Writer output;
				output = new BufferedWriter(new FileWriter("src/INVOICE.csv", true)); //clears file every time
				output.append(""+Id+","+Qty+","+total+'\n');
				output.close();
				
				//frame.dispose();
				new Invoice();
				}
				catch(Exception e2)
				{
					
				}
				
			}
		});
		btnGenerateBill.setBounds(714, 685, 216, 55);
		frame.getContentPane().add(btnGenerateBill);
		
		JButton btnReset = new JButton("Total");
		btnReset.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		
		//Loads into INVOICE.csv File

		int selId = Integer.parseInt(textField.getText());
		int selQty = Integer.parseInt(textField_1.getText());

		int i;
		for (i = 0; i < materialData.length; i++) {
			if (selId == (int) materialData[i][0]) {
				break;
			}
		}
		textField_2.setText("" + selQty * (double) materialData[i][3]);

	}
});btnReset.setBounds(91,685,209,55);frame.getContentPane().add(btnReset);

}}
