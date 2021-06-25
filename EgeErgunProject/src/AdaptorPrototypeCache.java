import java.util.Hashtable;

public class AdaptorPrototypeCache {

	
	 private static Hashtable<String, USBMemoryDevice> adaptorMap  = new Hashtable<String, USBMemoryDevice>();

	   public static USBMemoryDevice getAdaptor(String adaptorId) {
		   USBMemoryDevice cachedAdaptor = adaptorMap.get(adaptorId);
	      return (USBMemoryDevice) cachedAdaptor.clone();
	   }

	   // for each shape run database query and create shape
	   // shapeMap.put(shapeKey, shape);
	   // for example, we are adding three shapes
	   
	   public static void loadCache() {
	      
	      FlashUSBAdaptor flashUSBAdaptor= new FlashUSBAdaptor();
	      adaptorMap.put("Flash",flashUSBAdaptor);


	      SmartCardAdaptor smartCardAdaptor = new SmartCardAdaptor();
	      adaptorMap.put("SmartCard",smartCardAdaptor);
	      

	      SmartCardAdaptor smartCardAdaptor2 = new SmartCardAdaptor();
	      
	      adaptorMap.put("SmartCard2",smartCardAdaptor2);


	   }
	
	
}
