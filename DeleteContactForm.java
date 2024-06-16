import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteContactForm extends JFrame{
	
	private JLabel titleLabel;
	private JButton deleteButton;
	private JButton cancelButton;
	private JButton backToHomeButton;
	private JButton searchButton;
	
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel phoneNumberLabel;
	private JLabel companyNameLabel;
	private JLabel salaryLabel;
	private JLabel birthDayLabel;
	
	private JLabel genIdLabel;
	private JLabel searchNameLabel;
	private JLabel searchTpLabel;
	private JLabel searchCompanyLabel;
	private JLabel searchSalaryLabel;
	private JLabel searchBirthDayLabel;
	
	private JTextField searchText;
	
	public DeleteContactForm(){
		setSize(725,735);
		setTitle("Delete Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new  BorderLayout());
		
		JPanel titlePanel=new JPanel();
		titlePanel.setPreferredSize(new Dimension(725, 100));
		titlePanel.setBackground(new Color(95, 119, 222));
		titlePanel.setLayout(new BorderLayout());
		titleLabel=new JLabel("DELETE CONTACTS");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);
		add(titlePanel, BorderLayout.NORTH);
		
		JPanel detailPanel=new JPanel(new GridLayout(9,1));
		detailPanel.setPreferredSize(new Dimension(725,635));
		detailPanel.setLayout(null);
		
		searchText=new JTextField(15);
		searchText.setFont(new Font("",0,25));
		searchText.setBounds(37,18,380,38);
		/*searchText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String search=searchText.getText();
				int index=ContactController.searchContact(search);
				if(index!=-1){
					genIdLabel.setText(ContactController.getContact(index).getID());
					searchNameLabel.setText(ContactController.getContact(index).getName());
					searchTpLabel.setText(ContactController.getContact(index).getphoneNumber());
					searchCompanyLabel.setText(ContactController.getContact(index).getcompanyName());
					searchSalaryLabel.setText(Double.toString(ContactController.getContact(index).getSalary()));
					searchBirthDayLabel.setText(ContactController.getContact(index).getbirthDay());
				}else{
					JOptionPane.showMessageDialog(null,"No Contact found for "+"\""+search+"\".....");
					searchText.setText("");
					return;
				}
			}
		});*/
		detailPanel.add(searchText);
		
		searchButton=new JButton("Search");
		searchButton.setFont(new Font("",1,25));
		searchButton.setBounds(450,18,150,38);
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ContactList contactList=DBConnection.getInstance().getContactList();
				String nameOrPhone=searchText.getText();
				int index=ContactController.searchContacts(nameOrPhone);
				if(searchText.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Text field is Empty... Search Contact again");
					searchText.requestFocus();
				}else if(index!=-1){
					genIdLabel.setText(contactList.get(index).getId());
					searchNameLabel.setText(contactList.get(index).getName());
					searchTpLabel.setText(contactList.get(index).getPhoneNumber());
					searchCompanyLabel.setText(contactList.get(index).getCompanyName());
					searchSalaryLabel.setText(""+contactList.get(index).getSalary());
					searchBirthDayLabel.setText(contactList.get(index).getBirthday());
				}else{
					JOptionPane.showMessageDialog(null,"No contact found for "+nameOrPhone);
					searchText.setText("");
					searchText.requestFocus();
				}
			}
		});
		detailPanel.add(searchButton);
		
		idLabel=new JLabel("Contact ID ");
		idLabel.setFont(new Font("",1,25));
		idLabel.setBounds(37,70,250,55);
		detailPanel.add(idLabel);
		
		nameLabel=new JLabel("Name");
		nameLabel.setFont(new Font("",1,25));
		nameLabel.setBounds(37,120,250,55);
		detailPanel.add(nameLabel);
		
		phoneNumberLabel=new JLabel("Phone Number");
		phoneNumberLabel.setFont(new Font("",1,25));
		phoneNumberLabel.setBounds(37,180,250,55);
		detailPanel.add(phoneNumberLabel);
		
		companyNameLabel=new JLabel("Company Name");
		companyNameLabel.setFont(new Font("",1,25));
		companyNameLabel.setBounds(37,250,250,55);
		detailPanel.add(companyNameLabel);
		
		salaryLabel=new JLabel("Salary");
		salaryLabel.setFont(new Font("",1,25));
		salaryLabel.setBounds(37,315,250,55);
		detailPanel.add(salaryLabel);
		
		birthDayLabel=new JLabel("B'Day(YYYY-MM-DD)");
		birthDayLabel.setFont(new Font("",1,25));
		birthDayLabel.setBounds(37,380,250,55);
		detailPanel.add(birthDayLabel);
		
		genIdLabel=new JLabel("");
		genIdLabel.setFont(new Font("",1,26));
		genIdLabel.setBounds(347,75,250,55);
		detailPanel.add(genIdLabel);
		
		searchNameLabel=new JLabel();
		searchNameLabel.setFont(new Font("",0,25));
		searchNameLabel.setBounds(350,135,260,36);
		detailPanel.add(searchNameLabel);
		
		searchTpLabel=new JLabel();
		searchTpLabel.setFont(new Font("",0,25));
		searchTpLabel.setBounds(350,195,260,36);
		detailPanel.add(searchTpLabel);
		
		searchCompanyLabel=new JLabel();
		searchCompanyLabel.setFont(new Font("",0,25));
		searchCompanyLabel.setBounds(350,260,260,36);
		detailPanel.add(searchCompanyLabel);
		
		searchSalaryLabel=new JLabel();
		searchSalaryLabel.setFont(new Font("",0,25));
		searchSalaryLabel.setBounds(350,325,260,36);
		detailPanel.add(searchSalaryLabel);
		
		searchBirthDayLabel=new JLabel();
		searchBirthDayLabel.setFont(new Font("",0,25));
		searchBirthDayLabel.setBounds(350,390,260,36);
		detailPanel.add(searchBirthDayLabel);
		
		
		deleteButton=new JButton("Delete");
		deleteButton.setFont(new Font("",1,24));
		deleteButton.setBounds(350,450,180,36);
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String nameOrPhone=searchText.getText();
				int index=ContactController.searchContacts(nameOrPhone);
				ContactController.remove(index);
				if(searchText.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Text Field is empty...");
				}else if(index==-1){
					JOptionPane.showMessageDialog(null,"Deleted Fail...");
				}else{
					JOptionPane.showMessageDialog(null,"Deleted Successfull...");
				}
				int option=JOptionPane.showConfirmDialog(null,"Do you want to delete contact again ?","Comfirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(option==JOptionPane.YES_OPTION){
					searchText.setText("");
					searchText.requestFocus();
					genIdLabel.setText("");
					searchNameLabel.setText("");
					searchTpLabel.setText("");
					searchCompanyLabel.setText("");
					searchSalaryLabel.setText("");
					searchBirthDayLabel.setText("");
				}else if(option==JOptionPane.NO_OPTION){
					searchText.setText("");
					genIdLabel.setText("");
					searchNameLabel.setText("");
					searchTpLabel.setText("");
					searchCompanyLabel.setText("");
					searchSalaryLabel.setText("");
					searchBirthDayLabel.setText("");
					dispose();
				}
			}
		});
		detailPanel.add(deleteButton);
		
		cancelButton=new JButton("Cancel");
		cancelButton.setFont(new Font("",1,24));
		cancelButton.setBounds(550,450,130,36);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				searchText.setText("");
				genIdLabel.setText("");
				searchNameLabel.setText("");
				searchTpLabel.setText("");
				searchCompanyLabel.setText("");
				searchSalaryLabel.setText("");
				searchBirthDayLabel.setText("");
			}
		});
		detailPanel.add(cancelButton); 
		
		backToHomeButton=new JButton("Back To HomePage");
		backToHomeButton.setFont(new Font("",1,24));
		backToHomeButton.setBounds(350,500,331,36);
		backToHomeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				searchText.setText("");
				genIdLabel.setText("");
				searchNameLabel.setText("");
				searchTpLabel.setText("");
				searchCompanyLabel.setText("");
				searchSalaryLabel.setText("");
				searchBirthDayLabel.setText("");
				dispose();
			}
		});
		detailPanel.add(backToHomeButton);
		
		add(detailPanel);
		
	
	}
	public static void main(String args[]){
		new DeleteContactForm().setVisible(true);
	}	

}

