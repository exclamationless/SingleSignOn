
public class FlashUSBAdaptor extends  USBMemoryDevice {

	private FlashUSB flashusb;
	
	public FlashUSBAdaptor() {
		// TODO Auto-generated constructor stub
		this.flashusb= new FlashUSB();
	}
	
	public FlashUSBAdaptor(FlashUSB flashusb) {
		
		this.flashusb=flashusb;
	}
	@Override
	public void waitForDevice() {
		// TODO Auto-generated method stub
		flashusb.waitForUSBTokenInsertion();
		
	}

	@Override
	public void write(UserInfo userinfo) {
		// TODO Auto-generated method stub
		flashusb.writeData(userinfo);
	}

	@Override
	public UserInfo read() {
		// TODO Auto-generated method stub
		
		return flashusb.readData();
		
	}

	@Override
	public void decryptData() {
		// TODO Auto-generated method stub
		flashusb.decryptData();
		
	}

	@Override
	public void encryptData() {
		// TODO Auto-generated method stub
		flashusb.encryptData();
		
	}

	@Override
	public void openFile(String url) {
		// TODO Auto-generated method stub
		flashusb.openFile(url);
	}

	@Override
	public void deleteFile(String url) {
		// TODO Auto-generated method stub
		flashusb.deleteFile(url);
		
	}

	@Override
	public boolean verifyPIN(String pin) {
		// TODO Auto-generated method stub
		
		return true; // flashusb has no verification
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		flashusb.closeFile();
		
	}

	
	
	
	
}
