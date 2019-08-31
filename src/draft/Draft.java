package draft;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Draft {

	JFrame frame;
	private JTable table;
	private JPanel panel;
	private JScrollPane js;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Draft window = new Draft();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Draft() throws Exception {
		initialize();
	}

	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 1044, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMaterials = new JLabel("Materials");
		lblMaterials.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblMaterials.setBounds(472, 13, 130, 62);
		frame.getContentPane().add(lblMaterials);
		
		panel = new JPanel();
		panel.setBounds(68, 72, 900, 600);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		js = new JScrollPane(table);
		js.setPreferredSize(new Dimension(900, 600));
		
		js.setVisible(true);
		panel.add(js);

		String columnsName[] = { "Name", "Price", "Unit", "Quantity", "Total" };

		
		Object[][] materialData = new Changing().MaterialArray();
		DefaultTableModel dt = new DefaultTableModel(materialData, columnsName);

		table.setModel(dt);
		table.setBounds(12, 110, 1002, 476);
		table.setRowHeight(30);
		
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTotal.setBounds(444, 685, 130, 25);
		frame.getContentPane().add(btnTotal);
				
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		btnGenerateBill.setBounds(800, 685, 130, 25);
		frame.getContentPane().add(btnGenerateBill);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		btnReset.setBounds(91, 685, 130, 25);
		frame.getContentPane().add(btnReset);
		
		
	}
}
