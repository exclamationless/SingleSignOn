
public abstract class USBMemoryDevice implements Cloneable {

	public abstract void waitForDevice();
	
	public abstract void write(UserInfo userinfo);
	public abstract UserInfo read();
	public abstract void decryptData();
	public abstract void encryptData();
	public abstract void openFile(String url);
	public abstract void deleteFile(String url);
	
	public abstract boolean verifyPIN(String pin);

	public abstract void close();

	public Object clone() {
	      Object clone = null;
	      
	      try {
	         clone = super.clone();
	         
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clone;
	   }

	
	
	
	
}
