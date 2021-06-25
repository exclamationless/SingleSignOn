import java.util.ArrayList;
import java.util.Iterator;

public class FlashUSB  implements Iterable<UserInfo> {

	
	private ArrayList<UserInfo> userinfos;
	private String file;
	
	
	
	public FlashUSB() {
		super();
		this.userinfos = userinfos;
	}

	//Waits until a USB stick is inserted.
	public void waitForUSBTokenInsertion()
	{
		System.out.println("waiting for usb token insertion!");
		System.out.println("usb token has been inserted!");
	}
	
	//Open file for reading and writing.
	public void openFile(String file)
	{
		this.file=file;
		System.out.println("file has been opened");
	}
	
	//Close file.
	public void closeFile()
	{
		System.out.println("file has been closed");
		this.file=null;
	}
	
	//Reads data from the card.
	public UserInfo readData()
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
	public void writeData(UserInfo info)
	{
		System.out.println("file has been written!");
		userinfos.add(info);
	}
	
	//Decrypts data.
	public void decryptData()
	{
		//???
		System.out.println("file has been decrypted");
	}
	
	//Encrypts data.
	public void encryptData()
	{
		//???
		System.out.println("file has been encrypted");
	}

	//Deletes a file on the USB sticks
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

	// 0 1 2 3 4 5
	// 4 5 6 7 8 9
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
