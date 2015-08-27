/**
 * @author Girdhari
 * Entity class will contain all the Entity related information, a entity is a account
 */

package socialnetwork;


public class Entity extends Node implements Record
{

	private String name;
	private String emailId;
	private String phoneNumber;
	
	public Entity(int id, String emailId, String name, String phoneNumber)
	{
		super(id);
		this.emailId = emailId;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	

	public String getName()
	{
		return this.name;
	}
	

	public String getEmailId()
	{
		return this.emailId;
	}
	

	public String getphoneNumber()
	{
		return this.phoneNumber;
	}

	
	@Override
	public void getRecord() {
		
		System.out.println("Entity name is "+name);
		System.out.println("Entity Email Id is emailId"+emailId);
		System.out.println("Entity PhoneNumber is"+phoneNumber);
		
	}
	@Override
	public void display() {
		super.display();
		getRecord();
	}
	@Override
	public boolean equals(Object object) {
		
		if(!super.equals(object))
			return false;
		Entity entityObject = (Entity)object;
		if(this.name.equals(entityObject.name) && this.emailId.equals(entityObject.emailId) 
				&& this.phoneNumber.equals(entityObject.phoneNumber) )
			return true;
		return false;
	}
}
