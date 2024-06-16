class DBConnection{
	private  ContactList contactList;
	private static DBConnection  dBConnection;
	
	private DBConnection(){
		contactList=new ContactList();
	}
	
	public static DBConnection getInstance(){
		if(dBConnection==null){
			dBConnection=new DBConnection();
		}
		return dBConnection;
	}
	public  ContactList getContactList(){
		return contactList;
	}
}
