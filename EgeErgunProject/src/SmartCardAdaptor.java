
public class SmartCardAdaptor extends USBMemoryDevice {

	private SmartCardUSB smartcard;
	
	public SmartCardAdaptor() {
		// TODO Auto-generated constructor stub
		smartcard=new SmartCardUSB();
	}
	
	public SmartCardAdaptor(SmartCardUSB smartcard) {
		// TODO Auto-generated constructor stub
		this.smartcard=smartcard;
	}
	
	@Override
	public void waitForDevice() {
		// TODO Auto-generated method stub
		smartcard.waitForCardInsertion();
		
	}

	@Override
	public void write(UserInfo userinfo) {
		// TODO Auto-generated method stub
		
		smartcard.writeCard(userinfo);
		
	}

	@Override
	public UserInfo read() {
		// TODO Auto-generated method stub
		//return null;
		return smartcard.readCard();
		
		
		
	}

	@Override
	public void decryptData() {
		// TODO Auto-generated method stub
		
		smartcard.decryptData();
		
	}

	@Override
	public void encryptData() {
		// TODO Auto-generated method stub
		smartcard.encryptData();
		
	}

	@Override
	public void openFile(String url) {
		// TODO Auto-generated method stub
		smartcard.selectFile(url);
		
	}

	@Override
	public void deleteFile(String url) {
		// TODO Auto-generated method stub
		smartcard.deleteFile(url);
		
	}

	@Override
	public boolean verifyPIN(String pin) {
		// TODO Auto-generated method stub
		
		return smartcard.verifyPIN(pin);
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println();
		
	}

	
	
}
