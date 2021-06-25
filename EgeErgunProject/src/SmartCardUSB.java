import java.util.ArrayList;
import java.util.Iterator;


public class SmartCardUSB implements Iterable<UserInfo> {

	private ArrayList<UserInfo> userinfos;
	private String file;
	private String pin="1234";
	
	public SmartCardUSB()
	{
		userinfos= new ArrayList<UserInfo>();
	}
	
	//Selects a file on the card.
	public void selectFile(String file)
	{
		this.file=file;
		System.out.println("file has been selected");
	}
	
	//Waits until the card is inserted.
	public void waitForCardInsertion()
	{
		System.out.println("smartcard inserted!");
	}
	
	//Reads data from the card.
	public UserInfo readCard()
	{
		Iterator<UserInfo> itr= iterator();
		UserInfo info;
		System.out.println("file has been read!");
		while(itr.hasNext()) {
			
			info= itr.next();
			if( info.getUrl().equalsIgnoreCase(file)) {
				return info;
			}
		}
		return null;
	}
	
	//Writes data from the card.
	public void writeCard(UserInfo info)
	{
		System.out.println("file has been written!");
		userinfos.add(info);
	}
	
	//Decrypts data.
	public void decryptData()
	{
		System.out.println("file has been decrypted");
	}
	
	//Encrypts data.
	public void encryptData()
	{
		System.out.println("file has been encrypted");
	}
	
	//Verify PIN.
	public boolean verifyPIN(String pin)
	{
		System.out.println("pin has been verified!");
		return this.pin.equals(pin);
	}
	
	//Deletes a file on the smart card.
	public void deleteFile(String url)
	{
		Iterator<UserInfo> itr= iterator();
		UserInfo info=null;
		while(itr.hasNext()) {
			
			info= itr.next();
			if( info.getUrl().equalsIgnoreCase(url)) {
				break;
			}
		}
		
		if( info!=null)
		{
			System.out.println("file has been deleted!");
			userinfos.remove(info);
		}
	}
	
	

	@Override
	public Iterator<UserInfo> iterator() {
		// TODO Auto-generated method stub
		return new WebInfoIterator();
	}

	public class WebInfoIterator implements Iterator<UserInfo> {

		private int  current=0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if( current<userinfos.size()) {
				return true;
			}
			else {
				return false;	
			}
			
		}

		@Override
		public UserInfo next() {
			// TODO Auto-generated method stub
			UserInfo info = userinfos.get(current);
			current++;
			return info;
		}
		
	}
	
	
}
