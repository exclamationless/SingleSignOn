
// Factory Method PAttern

public class USBAdaptorFactory {


	public USBAdaptorFactory() {
		AdaptorPrototypeCache.loadCache();
	}

	public USBMemoryDevice createAdaptor(String DeviceType) {
		// TODO Auto-generated constructor stub
		if (DeviceType.contentEquals("SmartCard")) {
			
			return AdaptorPrototypeCache.getAdaptor("SmartCard");
			
		} else if (DeviceType.contentEquals("Flash")) {
			
			return AdaptorPrototypeCache.getAdaptor("Flash");
		}
		return null;
	}

}


