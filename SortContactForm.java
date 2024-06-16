import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SortContactForm extends JFrame{
	private JLabel titleLabel;

	private JButton btnlistByNameForm;
	private JButton btnlistBySalaryForm;
	private JButton btnlistByBirthDayForm;
	private JButton btnCancel;

	private SortByNameForm sortByNameForm;
	private SortBySalaryForm sortBySalaryForm;
	private SortByBirthDayForm sortByBirthDayForm;

	public SortContactForm(){
		setSize(900,700);
		setTitle("iFriend");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel titlePanel=new JPanel();
		titlePanel.setPreferredSize(new Dimension(900, 100));
		titlePanel.setBackground(new Color(95, 119, 222));
		titlePanel.setLayout(new BorderLayout());
		titleLabel=new JLabel("CONTACTS LIST");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);
		add(titlePanel, BorderLayout.NORTH);
		
		
		JPanel buttonPanel=new JPanel(new GridLayout(4,1));
		buttonPanel.setLayout(null);
		btnlistByNameForm=new JButton("List By Name");
		btnlistByNameForm.setFont(new Font("",1,23));
		btnlistByNameForm.setBounds(255,50,400,55);
		btnlistByNameForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(sortByNameForm==null){
					sortByNameForm=new SortByNameForm();
				}
				sortByNameForm.setVisible(true);
			}
			
		});
	
		
		btnlistBySalaryForm=new JButton("List By Salary");
		btnlistBySalaryForm.setFont(new Font("",1,23));
		btnlistBySalaryForm.setBounds(255,150,400,55);
		btnlistBySalaryForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(sortBySalaryForm==null){
					sortBySalaryForm=new SortBySalaryForm();
				}
				sortBySalaryForm.setVisible(true);
			}
			
		});
		
		
		btnlistByBirthDayForm=new JButton("List By Birthday");
		btnlistByBirthDayForm.setFont(new Font("",1,23));
		btnlistByBirthDayForm.setBounds(255,250,400,55);
		btnlistByBirthDayForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(sortByBirthDayForm==null){
					sortByBirthDayForm=new SortByBirthDayForm();
				}
				sortByBirthDayForm.setVisible(true);
			}
		});
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,25));
		btnCancel.setBounds(600,420,180,45);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		
		buttonPanel.add(btnlistByNameForm);
		buttonPanel.add(btnlistBySalaryForm);
		buttonPanel.add(btnlistByBirthDayForm);
		buttonPanel.add("Center",btnCancel);
		
		 add(buttonPanel);
	}
}

