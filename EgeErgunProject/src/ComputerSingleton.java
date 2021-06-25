import java.util.Scanner;

// Computer Class is a singleton pattern class
public class ComputerSingleton {

	private USBMemoryDevice[] devices;

	private static ComputerSingleton instance = null; // for singleton pattern

	private ComputerSingleton() {
		devices = new USBMemoryDevice[4];
	}

	public static ComputerSingleton createSingletonComputer() {

		// if not exist computer it will be created
		if (instance == null) {
			instance = new ComputerSingleton();
			return instance;
		} // if exist the same instance will be returned
		else {
			return instance;
		}
	}

	public void useComputer()
	{
		String choice;
		Scanner input= new Scanner(System.in);
		USBAdaptorFactory factory= new USBAdaptorFactory();
		String url="www";
		String pin="";
		String username;
		String password;
		while(true) {
			System.out.println("what type of device do you want to plug in?");
			System.out.println("1-SmartCard");
			System.out.println("2-Flash");
			System.out.println("9-Shutdown");
			System.out.print("Choice : ");
			choice=input.nextLine();
			
			if( choice.equals("1")) {
				devices[0]=factory.createAdaptor("SmartCard");	
				System.out.print("Enter your pin : ");
				pin = input.nextLine();
			}
			else if (choice.equals("2")) {
				devices[0]=factory.createAdaptor("Flash");
			}
			else if (choice.equals("9")) {

				break;
			}
			else {
				System.out.println("Invalid choice!");
				continue;
			}
		
			
			this.devices[0].waitForDevice();
			if ( this.devices[0].verifyPIN(pin) )
			{
				while(true) {
					System.out.println("Enter the url you want to visit: ");
					url=input.nextLine();
					if( !url.equals("exit")) {
						devices[0].openFile(url);
						UserInfo info = devices[0].read();
						if ( info!=null) {
							System.out.println("You have visited this site before. You logged into the web site!");
							devices[0].close();
							devices[0].decryptData();	
						}
						else {
							System.out.println("You have been logging into this URL for the first time ");
							System.out.print("Enter username: ");
							username= input.nextLine();
							System.out.print("Enter password: ");
							password= input.nextLine();
							
							UserInfo newinfo= new UserInfo(url, username,password);
							devices[0].encryptData();
							devices[0].write(newinfo);				
							
						}
					}
					else {
						break;
					}
				
				}
				
				
				
			}
			
		}
		System.out.println("Done!");
		

//		
//		1. wait for USB Token insertion
//		2. open file
//		3. read data
//		4. close file
//		5. decrypt data
	}


}
