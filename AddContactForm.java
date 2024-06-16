import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddContactForm extends JFrame{
	
	private JLabel titleLabel;
	private JButton addButton;
	private JButton cancelButton;
	private JButton backToHomeButton;
	
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel phoneNumberLabel;
	private JLabel companyNameLabel;
	private JLabel salaryLabel;
	private JLabel birthDayLabel;
	
	//private JLabel genIdLabel;
	
    private JTextField txtId;
	private JTextField txtName;
    private JTextField txtPhoneNumber;
    private JTextField txtCompany;
    private JTextField txtSalary;
    private JTextField txtBirthday;
	
	public AddContactForm(){
		setSize(725,735);
		setTitle("Add Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new  BorderLayout());
		
		JPanel titlePanel=new JPanel();
		titlePanel.setPreferredSize(new Dimension(700, 100));
		titlePanel.setBackground(new Color(95, 119, 222));
		titlePanel.setLayout(new BorderLayout());
		titleLabel=new JLabel("ADD CONTACT");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);
		add(titlePanel, BorderLayout.NORTH);
		
		JPanel detailPanel=new JPanel(new GridLayout(8,1));
		detailPanel.setPreferredSize(new Dimension(700,635));
		detailPanel.setLayout(null);
		
		idLabel=new JLabel("Contact ID -");
		idLabel.setFont(new Font("",1,26));
		idLabel.setBounds(24,18,200,45);
		detailPanel.add(idLabel);
		
		nameLabel=new JLabel("Name");
		nameLabel.setFont(new Font("",1,25));
		nameLabel.setBounds(37,80,250,55);
		detailPanel.add(nameLabel);
		
		phoneNumberLabel=new JLabel("Contact Number");
		phoneNumberLabel.setFont(new Font("",1,25));
		phoneNumberLabel.setBounds(37,145,250,55);
		detailPanel.add(phoneNumberLabel);
		
		companyNameLabel=new JLabel("Company Name");
		companyNameLabel.setFont(new Font("",1,25));
		companyNameLabel.setBounds(37,210,250,55);
		detailPanel.add(companyNameLabel);
		
		salaryLabel=new JLabel("Salary");
		salaryLabel.setFont(new Font("",1,25));
		salaryLabel.setBounds(37,275,250,55);
		detailPanel.add(salaryLabel);
		
		birthDayLabel=new JLabel("BirthDay");
		birthDayLabel.setFont(new Font("",1,25));
		birthDayLabel.setBounds(37,340,250,55);
		detailPanel.add(birthDayLabel);
		
		
		txtId=new JTextField(15);
		txtId.setFont(new Font("",1,26));
		txtId.setBounds(180,18,200,45);
		txtId.setEditable(false);
		txtId.setText(ContactController.generateId());
		detailPanel.add(txtId);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",0,25));
		txtName.setBounds(350,95,260,36);
		detailPanel.add(txtName);
		
		txtPhoneNumber=new JTextField(20);
		txtPhoneNumber.setFont(new Font("",0,25));
		txtPhoneNumber.setBounds(350,155,260,36);
		txtPhoneNumber.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String phoneNumber=txtPhoneNumber.getText();
				boolean isValidPhoneNumber=ContactController.isValidPhoneNumber(phoneNumber);
				if(!isValidPhoneNumber){
					int option=JOptionPane.showConfirmDialog(null,"Invalid Phone Number.. Do you want to input number again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(option==JOptionPane.YES_OPTION){
						txtPhoneNumber.setText("");
						txtPhoneNumber.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactController.count();
						txtId.setText(ContactController.generateId());
						txtName.setText("");
						txtPhoneNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
				}
			}
		});
		detailPanel.add(txtPhoneNumber);
		
		txtCompany=new JTextField(10);
		txtCompany.setFont(new Font("",0,25));
		txtCompany.setBounds(350,220,260,36);
		detailPanel.add(txtCompany);
		
		txtSalary=new JTextField(10);
		txtSalary.setFont(new Font("",0,25));
		txtSalary.setBounds(350,285,260,36);
		txtSalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				double salary=Double.parseDouble(txtSalary.getText());
				boolean isValidSalary=ContactController.isValidSalary(salary);
				if(!isValidSalary){
					int option=JOptionPane.showConfirmDialog(null,"Invalid Phone Number.. Do you want to input salary again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(option==JOptionPane.YES_OPTION){
						txtSalary.setText("");
						txtSalary.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactController.count();
						txtId.setText(ContactController.generateId());
						txtName.setText("");
						txtPhoneNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
				}
			}
		});
		detailPanel.add(txtSalary);
		
		txtBirthday=new JTextField(10);
		txtBirthday.setFont(new Font("",0,25));
		txtBirthday.setBounds(350,350,260,36);
		txtBirthday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String birthday=txtBirthday.getText();
				boolean isValidBirthday=ContactController.isValidBirthday(birthday);
				if(!isValidBirthday){
					int option=JOptionPane.showConfirmDialog(null,"Invalid Phone Number.. Do you want to input birthday again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(option==JOptionPane.YES_OPTION){
						txtBirthday.setText("");
						txtBirthday.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactController.count();
						txtId.setText(ContactController.generateId());
						txtName.setText("");
						txtPhoneNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
				}
			}
		});
		detailPanel.add(txtBirthday);
		
		
		addButton=new JButton("Add Contact");
		addButton.setFont(new Font("",1,24));
		addButton.setBounds(350,425,180,36);
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					String id=txtId.getText();
					String name=txtName.getText();
					String phoneNumber=txtPhoneNumber.getText();
					String companyName=txtCompany.getText();
					double salary=Double.parseDouble(txtSalary.getText());
					String birthday=txtBirthday.getText();
					Contact contacts=new Contact(id,name,phoneNumber,companyName,salary,birthday);
					
					boolean isValidPhoneNumber=ContactController.isValidPhoneNumber(phoneNumber);
					boolean isValidSalary=ContactController.isValidSalary(salary);
					boolean isValidBirthday=ContactController.isValidBirthday(birthday);
					
					
					if(!isValidPhoneNumber){
						int option=JOptionPane.showConfirmDialog(null,"Invalid phone number...Do you want to enter phone number again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(option==JOptionPane.YES_OPTION){
							txtPhoneNumber.setText("");
							txtPhoneNumber.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							ContactController.count();
							txtId.setText(ContactController.generateId());
							txtName.setText("");
							txtPhoneNumber.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							dispose();
						}
					}else if(!isValidSalary){
						int option=JOptionPane.showConfirmDialog(null,"Invalid salary...Do you want to enter salary again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(option==JOptionPane.YES_OPTION){
							txtSalary.setText("");
							txtSalary.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							ContactController.count();
							txtId.setText(ContactController.generateId());
							txtName.setText("");
							txtPhoneNumber.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							dispose();
						}
					}else if(!isValidBirthday){
						int option=JOptionPane.showConfirmDialog(null,"Invalid birthday...Do you want to enter birthday again ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(option==JOptionPane.YES_OPTION){
							txtBirthday.setText("");
							txtBirthday.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							ContactController.count();
							txtId.setText(ContactController.generateId());
							txtName.setText("");
							txtPhoneNumber.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							dispose();
						}
					}else{
						ContactController.addContacts(contacts);
						int option=JOptionPane.showConfirmDialog(null,"Added Successfull..Do you want to add another contact ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(option==JOptionPane.YES_OPTION){
							txtId.setText(ContactController.generateId());
							txtName.setText("");
							txtPhoneNumber.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							txtName.requestFocus();
							
						}else if(option==JOptionPane.NO_OPTION){
							txtId.setText(ContactController.generateId());
							txtName.setText("");
							txtPhoneNumber.setText("");
							txtCompany.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
							dispose();
						}
					}
						
						
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null,"No Contact added...");
				}
				
			}
		
		});
		detailPanel.add(addButton);
		
		cancelButton=new JButton("Cancel");
		cancelButton.setFont(new Font("",1,24));
		cancelButton.setBounds(550,425,130,36);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtName.setText("");
				txtPhoneNumber.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBirthday.setText("");
			}
		});
		detailPanel.add(cancelButton); 
		
		backToHomeButton=new JButton("Back To HomePage");
		backToHomeButton.setFont(new Font("",1,24));
		backToHomeButton.setBounds(350,480,331,36);
		backToHomeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtName.setText("");
				txtPhoneNumber.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBirthday.setText("");
				dispose();
			}
		});
		detailPanel.add(backToHomeButton);
		
		add(detailPanel);
		
	
	}

}

