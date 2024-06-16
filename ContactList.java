class ContactList{
	private Node first;
	
	public Node getFirst(){
		return first;
	}
	private boolean isEmpty(){
		return first==null;
	}
	public int getSize(){
		Node temp=first;
		int count=0;
		while(temp!=null){
			temp=temp.getNext();
			count++;
		}
		return count;
	}
	public void add(Contact contact){
		Node n1=new Node(contact);
		Node lastNode=first;
			if(isEmpty()){
				first=n1;
			}else{
				while(lastNode.getNext()!=null){
					lastNode=lastNode.getNext();
				}
				lastNode.setNext(n1);
			}
	}
	public void remove(int index){
		if(isValidIndex(index)){
			if(index==0){
				first=first.getNext();
			}else{
				Node temp=first;
				for (int i = 0; i < index-1; i++){
					temp=temp.getNext();
				}
					temp.setNext(temp.getNext().getNext());
			}
		}
	}
	public Contact[] toArray(){
		Contact[] contactArray=new Contact[getSize()];
		Node temp=first;
		for (int i = 0; temp!=null; i++){
			contactArray[i]=temp.getContacts();
			temp=temp.getNext();
		}
		return contactArray;
	}
	public Contact get(int index){
		if(isValidIndex(index)){
			if(index==0){
				return first.getContacts();
			}else{
				Node temp=first;
				for(int i=0; i<index; i++){
					temp=temp.getNext();
				}
				return temp.getContacts();
			}
		}
		return null;
	}
	public boolean isValidIndex(int index){
		return index>=0 & index<=getSize();
	}
	
	
	public int searchByNameOrPhone(String nameOrPhone){
		Node temp=first;
		int index=0;
		while(temp!=null){
			if(temp.getContacts().getName().equals(nameOrPhone) || temp.getContacts().getPhoneNumber().equals(nameOrPhone)){
				return index;
			}
			temp=temp.getNext();
			index++;
		}
		return -1;
	}
	
	public void updateName(int index, String name){
		get(index).setName(name);
	}
	public void updatePhoneNumber(int index, String phone){
		get(index).setPhoneNumber(phone);
	}
	public void updateCompanyName(int index, String company){
		get(index).setCompanyName(company);
	}
	public void updateSalary(int index, double salary){
		get(index).setSalary(salary);
	}
    class Node{
        private Contact contact;
        private Node next;
            
        public Node getNext(){
            return next;
        }
        public Contact getContacts(){
            return contact;
        }
        public void setContacts(Contact contact){
            this.contact=contact;
        }
        public void setNext(Node next){
            this.next=next;
        }
            
        Node(Contact contact){
            this.contact=contact;
        }
    }
}


