import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class HomePage extends JFrame{
    
    private AddContactForm addContactForm;
	private UpdateContactForm updateContactForm;
	private SearchContactForm searchContactForm;
	private DeleteContactForm deleteContactForm;
	private SortContactForm sortContactForm;
    
    private JButton btnAddContact;
    private JButton btnUpdateContact;
    private JButton btnSearchContact;
    private JButton btnDeleteContact;
    private JButton btnViewContact;
    private JButton btnExit;

	private JLabel iFriendLabel;
	private JLabel contactLabel;
	private JLabel homeLabel;
    private JLabel mainImageLabel;

    public HomePage(){
		setSize(900,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
        
        
	
        JPanel westPanel=new JPanel(null);
		westPanel.setPreferredSize(new Dimension(400, 600));
		iFriendLabel=new JLabel("iFRIEND");
		iFriendLabel.setFont(new Font("",1,40));
		iFriendLabel.setBounds(50,0,300,100);
		iFriendLabel.setHorizontalAlignment(SwingConstants.CENTER);
		westPanel.add("Center",iFriendLabel);
		
		contactLabel =new JLabel("Contact Manager");
		contactLabel.setFont(new Font("",1,40));
		contactLabel.setBounds(10,50,380,130);
		contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		westPanel.add("Center",contactLabel);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(10, 150, 400, 5);
        westPanel.add(separator);

       

        ImageIcon mainImageIcon = new ImageIcon("HomeImage.jpg");
        Image scaledImage = mainImageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        mainImageIcon = new ImageIcon(scaledImage);
        mainImageLabel = new JLabel(mainImageIcon);
        mainImageLabel.setBounds(5,180,400,320);
        mainImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        westPanel.add(mainImageLabel);

        
		 add(westPanel, BorderLayout.WEST);

        JPanel eastPanel=new JPanel(null);
			
            eastPanel.setPreferredSize(new Dimension(550, 600));
            eastPanel.setBackground(new Color(95, 119, 222));
            eastPanel.setLayout(null);
            
		homeLabel=new JLabel("Home Page");
		homeLabel.setFont(new Font("",1,40));
		homeLabel.setBounds(120,25,380,70);
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eastPanel.add(homeLabel);

        separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(50, 105, 500, 5);
        eastPanel.add(separator);
		
		btnAddContact=new JButton("Add Contacts");
		btnAddContact.setFont(new Font("",1,21));
		btnAddContact.setBounds(160,140,300,32);
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addContactForm==null){
					addContactForm=new AddContactForm();
				}
				
				addContactForm.setVisible(true);
			}
		});
		eastPanel.add(btnAddContact);
		
			
		btnUpdateContact=new JButton("Update Contacts");
		btnUpdateContact.setFont(new Font("",1,21));
		btnUpdateContact.setBounds(160,200,300,32);
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(updateContactForm==null){
					updateContactForm=new UpdateContactForm();
				}
				
				updateContactForm.setVisible(true);
				
			}
		});
		eastPanel.add(btnUpdateContact);
		
		
		btnDeleteContact=new JButton("Delete Contacts");
		btnDeleteContact.setFont(new Font("",1,21));
		btnDeleteContact.setBounds(160,260,300,32);
		btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(deleteContactForm==null){
					deleteContactForm=new DeleteContactForm();
				}
				
				deleteContactForm.setVisible(true);
				
			}
		});
		eastPanel.add(btnDeleteContact);
		
		
		btnSearchContact=new JButton("Search Contacts");
		btnSearchContact.setFont(new Font("",1,21));
		btnSearchContact.setBounds(160,320,300,32);
		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			if(searchContactForm==null){
					searchContactForm=new SearchContactForm();
				}
				
				searchContactForm.setVisible(true);
				
			}
		});
		eastPanel.add(btnSearchContact);
		
		
		btnViewContact=new JButton("View Contacts");
		btnViewContact.setFont(new Font("",1,21));
		btnViewContact.setBounds(160,380,300,32);
		btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(sortContactForm==null){
					sortContactForm=new SortContactForm();
				}
				
				sortContactForm.setVisible(true);

			}
		});
		eastPanel.add(btnViewContact);
		
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,21));
		btnExit.setBounds(400,480,100,32);
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		eastPanel.add(btnExit);
		
		 add(eastPanel, BorderLayout.EAST);
	
	}
	public static void main(String args[]){
		new HomePage().setVisible(true);
	}	

}

