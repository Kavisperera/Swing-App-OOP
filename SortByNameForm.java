import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
public class SortByNameForm extends JFrame{
	private JLabel titleLabel;
	
	private JTable contactsTable;
	private DefaultTableModel dtm;

	private JButton backToHomePage;
	private JButton btnReload;
	
	public SortByNameForm(){
		setSize(700,500);
		setTitle("List Contacts By Name");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		JPanel tittlePanel=new JPanel();
		tittlePanel.setLayout(null);
		tittlePanel.setBounds(0,0,700,55);
		tittlePanel.setBackground(new Color(95, 119, 222));
		
		titleLabel=new JLabel("LIST CONTACTS BY NAME");
		titleLabel.setFont(new Font("",1,30));
		titleLabel.setBounds(150,10,700,35);
		tittlePanel.add(titleLabel);
		
		JPanel tablePanel=new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBounds(0,55,700,445);
		
		String[] columnNames={"ID","Name","Phone Number","Company Name","Salary","Birthday"};
		dtm=new DefaultTableModel(columnNames,0);
		contactsTable=new JTable(dtm);
		
		JScrollPane tablePane=new JScrollPane(contactsTable);
		tablePane.setBounds(0,30,700,300);
		tablePanel.add(tablePane);
		
		backToHomePage=new JButton("Back To HomePage");
		backToHomePage.setFont(new Font("",1,20));
		backToHomePage.setBounds(480,350,180,28);
		backToHomePage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
			
		});
		tablePanel.add(backToHomePage);
		
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20));
		btnReload.setBounds(330,350,140,28);
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Contact[] contactArray=ContactController.ListByName();
				
				dtm.setRowCount(0);
				for (int i = 0; i < contactArray.length; i++){
					Contact contact=contactArray[i];
					Object[] rowData={contact.getId(),contact.getName(),contact.getPhoneNumber(),contact.getCompanyName(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData);
				}
			}
		});
		tablePanel.add(btnReload);
		
		add(tittlePanel);
		add(tablePanel);
		
	}
}




