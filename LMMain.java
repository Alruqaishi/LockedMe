import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.io.File;


public class LMMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        BufferedReader fromUser = null;  //BufferReader and Reader in general is Char stream classes
		
		fromUser = new BufferedReader(new InputStreamReader(System.in));	  //InputStreamReader used for reading line in console
		
		String ActiveStatus;     // ActiveStatus is used in the while loop to check if we still need to use the main menu and don't want to exit the program
		ActiveStatus = "Yes";
		
		String ActiveStatus2;
		ActiveStatus2 = "Yes";   // ActiveStatus2 is used in the while loop to check if we still need to use the sub menu and don't want to navigate to main menu
		
		String selection = null;  // selection is used to listen to user input of main options
		String selection2 = null; // selection2 is used to listen to user input of sub options
		int number = 0;
		char char2 = 0;
		int pickedFId = 0;
		String pickedFName = null;
		
		
		
		Map<Integer, String> fileSet = new TreeMap<>(); // Need to use Tree map in order to display in ascending order
		
		
	while (ActiveStatus == "Yes") {
		
	
		
		
		System.out.println("\n|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<|");	
	System.out.println("\n Welcome to LockedMe.com");
	System.out.println("\n This application is developed by Sulaiman Al Ruqaishi from Company Lockers Pvt. Ltd");
	System.out.println("\n This application helps clients to manage their files");
	System.out.println("\n Please choose one of the following options: ");
	System.out.println(" 1> Display the list of files currently saved in the system ");
	System.out.println(" 2> Manage files in the system ");
	System.out.println(" 3> Close the application ");
	
	
	
	
	
	
	try {
		selection = fromUser.readLine();
		
		number = Integer.parseInt(selection);
		
		if (number == 1) {
			System.out.println(" Your selection is option "+ selection);
			System.out.println(" In this option you will see all files currently saved in the system ");
			System.out.println(fileSet);
			
		}else if (number == 2) {
			ActiveStatus2 = "Yes";
			while (ActiveStatus2 == "Yes") {
				
			
			
			System.out.println("\n|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<|");
			
			
			System.out.println(" Please choose which manage option you would like to do: ");
			System.out.println(" A> Add a file ");
			System.out.println(" B> Delete a file ");
			System.out.println(" C> Search for a spacific file ");
			System.out.println(" D> Navigate to main screen ");
			
			selection2 = fromUser.readLine();
			char2 = selection2.charAt(0); 
			
			if (char2 == 'A') {
				
				System.out.println(" Please specify the new file ID ");
				
				selection = fromUser.readLine();
				
				pickedFId = Integer.parseInt(selection);
				
				System.out.println(" Please Insert the name of the file you want to add ");
				
				pickedFName = fromUser.readLine();
				
				
				fileSet.put(pickedFId, pickedFName);  //Storing file id and file name in the map
				
				FileOutputStream stream = null;
				try {
					
					stream = new FileOutputStream(pickedFName); // Creating a new file with the picked file name by the user
					
					File f = new File(System.getProperty("user.dir"),pickedFName);
					
					
					
			        
			    
				}catch(IOException e) {
					e.printStackTrace();
					
					System.out.println("File not found!");
					
				}finally {
					if(stream!=null) {
						try {
							stream.close();
							}
						catch (IOException e){
							
							e.printStackTrace();
					
					}
					}
				}
				
				
				
				
				System.out.println("\nFile ID "+pickedFId+" is now added \n");
				
				System.out.println(fileSet);
				
                
			}else if (char2 == 'B') {
				
				try {
				
                System.out.println(" Please specify the ID of the file you want to delete ");
                
                
				
				selection = fromUser.readLine();
				
				
				
				
				pickedFId = Integer.parseInt(selection);
				
				Set<Map.Entry<Integer, String>> mapEntry = fileSet.entrySet();
				
				String TValue;
				TValue = null;
				
				for (Entry<Integer, String> entry: mapEntry) {
		        	Integer key = entry.getKey();
		        	String value = entry.getValue();
		        	
		        	if (key == pickedFId) {		        		
		        		TValue = value;		        		
		        	}	        	
		        }
				
				fileSet.remove(pickedFId);
				
				
				
				FileOutputStream stream = null;
				try {
					stream = new FileOutputStream(TValue); 
					File f = new File(System.getProperty("user.dir"),TValue);
					stream.close();  // Deleting both stream and file specified by suer
			        f.delete();
					
				
			        			    
				}catch(IOException e) {
					e.printStackTrace();
					
					System.out.println("File not found!");
					
				}finally {
					if(stream!=null) {
						try {
							stream.close();
							}
						catch (IOException e){
							
							e.printStackTrace();
					
					}
					}
				
				}
				
				}catch(NumberFormatException e) {
					
					System.out.println("\n Youve not entered a valid fileID \n");
					
				}catch(NullPointerException e) {
					
					System.out.println("\n The File ID you specified is not stored in the sytem \n");
					
				}
				
				
				}else if (char2 == 'C') {
				
				System.out.println(" Please specify the file name that you want to search: ");
				selection = fromUser.readLine();
				
				boolean isFileThere = fileSet.containsValue(selection);
		        
		        // This will search for the file and respond if the file name is there or not
		        
		        if (isFileThere) {
		        	
		        	System.out.println("The File "+selection+" is saved in the system");
		        }else {
		        	System.out.println("The File "+selection+" is not saved in the system");
		        }
				
			}else if (char2 == 'D') {
				
				ActiveStatus2 ="No";
				
			}
			
			} 
			
			
		}else if (number == 3) {
			System.out.println(" Your selection is option "+ selection);
			System.out.println(" The system will now close, Thank you for using lockedMe.com ");
			System.out.println("|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<|");
			ActiveStatus = "No"; // While loop condition for termination
			System.exit(0); // Terminate current running JVM
			
			
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
		System.out.println("The option you entered is not correct, please select an integer option between 1 and 3");
		
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		
		
	}
	
	
	
	System.out.println("\n|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<|");	
	
	}
		
		

	}

}
