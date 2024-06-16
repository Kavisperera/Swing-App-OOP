import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateContactForm extends JFrame{
	
	private JLabel titleLabel;

	private JButton updateButton;
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
	private JTextField updateNameText;
	private JTextField updateTpText;
	private JTextField updateCompanyText;
	private JTextField updateSalaryText;
	private JTextField updateBirthDayText;
	
	
	private JTextField searchText;
	
	public UpdateContactForm(){
		setSize(725,735);
		setTitle("Update Contact Form ");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(new  BorderLayout());
		setResizable(false);
		
		JPanel titlePanel=new JPanel();
		titlePanel.setPreferredSize(new Dimension(725, 100));
		titlePanel.setBackground(new Color(95, 119, 222));
		titlePanel.setLayout(new BorderLayout());
		titleLabel=new JLabel("UPDATE CONTACT");
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
					updateNameText.setText(ContactController.getContact(index).getName());
					updateTpText.setText(ContactController.getContact(index).getphoneNumber());
					updateCompanyText.setText(ContactController.getContact(index).getcompanyName());
					updateSalaryText.setText(Double.toString(ContactController.getContact(index).getSalary()));
					updateBirthDayText.setText(ContactController.getContact(index).getbirthDay());
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
					updateNameText.setText(contactList.get(index).getName());
					updateTpText.setText(contactList.get(index).getPhoneNumber());
					updateCompanyText.setText(contactList.get(index).getCompanyName());
					updateSalaryText.setText(""+contactList.get(index).getSalary());
					updateBirthDayText.setText(contactList.get(index).getBirthday());
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
		
		updateNameText=new JTextField(15);
		updateNameText.setFont(new Font("",0,25));
		updateNameText.setBounds(350,135,260,36);
		detailPanel.add(updateNameText);
		
		updateTpText=new JTextField(20);
		updateTpText.setFont(new Font("",0,25));
		updateTpText.setBounds(350,195,260,36);
		
		detailPanel.add(updateTpText);
		
		updateCompanyText=new JTextField(10);
		updateCompanyText.setFont(new Font("",0,25));
		updateCompanyText.setBounds(350,260,260,36);
		detailPanel.add(updateCompanyText);
		
		updateSalaryText=new JTextField(10);
		updateSalaryText.setFont(new Font("",0,25));
		updateSalaryText.setBounds(350,325,260,36);
		
		detailPanel.add(updateSalaryText);
		
		updateBirthDayText=new JTextField(10);
		updateBirthDayText.setFont(new Font("",0,25));
		updateBirthDayText.setBounds(350,390,260,36);
		
		detailPanel.add(updateBirthDayText);
		
		
		updateButton=new JButton("Update");
		updateButton.setFont(new Font("",1,24));
		updateButton.setBounds(350,450,180,36);
		updateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					String id=genIdLabel.getText();
					String name=updateNameText.getText();
					String phoneNumber=updateTpText.getText();
					String companyName=updateCompanyText.getText();
					double salary=Double.parseDouble(updateSalaryText.getText());
					String birthday=updateBirthDayText.getText();
					
					String nameOrPhone=searchText.getText();
					int index=ContactController.searchContacts(nameOrPhone);
					boolean isUpdateContacts=ContactController.updateContacts(id,name,phoneNumber,companyName,salary,birthday,index);
					
					if(isUpdateContacts){
							JOptionPane.showMessageDialog(null,"Update Success");
							int option=JOptionPane.showConfirmDialog(null,"Do you want to update another contact ? ","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if(option==JOptionPane.YES_OPTION){
								searchText.setText("");
								searchText.requestFocus();
								genIdLabel.setText("");
								updateNameText.setText("");
								updateTpText.setText("");
								updateCompanyText.setText("");
								updateSalaryText.setText("");
								updateBirthDayText.setText("");
							}else if(option==JOptionPane.NO_OPTION){
								searchText.setText("");
								genIdLabel.setText("");
								updateNameText.setText("");
								updateTpText.setText("");
								updateCompanyText.setText("");
								updateSalaryText.setText("");
								updateBirthDayText.setText("");
								dispose();
							}
						}else{
							JOptionPane.showMessageDialog(null,"Update Fail");
						}
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null,"Text Field is empty...");
						searchText.requestFocus();
					}
				}
			
		});
		detailPanel.add(updateButton);
		
		cancelButton=new JButton("Cancel");
		cancelButton.setFont(new Font("",1,24));
		cancelButton.setBounds(550,450,130,36);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				searchText.setText("");
				genIdLabel.setText("");
				updateNameText.setText("");
				updateTpText.setText("");
				updateCompanyText.setText("");
				updateSalaryText.setText("");
				updateBirthDayText.setText("");
				return;
			}
		});
		detailPanel.add(cancelButton); 
		
		backToHomeButton=new JButton("Back To HomePage");
		backToHomeButton.setFont(new Font("",1,24));
		backToHomeButton.setBounds(350,500,331,36);
		backToHomeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				searchText.setText("");
				dispose();
				
				genIdLabel.setText("");
				updateNameText.setText("");
				updateTpText.setText("");
				updateCompanyText.setText("");
				updateSalaryText.setText("");
				updateBirthDayText.setText("");
				return;
			}
		});
		detailPanel.add(backToHomeButton);
		
		add(detailPanel);
		
	
	}
	public static void main(String args[]){
		new UpdateContactForm().setVisible(true);
	}	

}

