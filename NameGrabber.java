import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NameGrabber {
	
	
	public static void main(String[] args){
		
		List<Entry> maleArray = new ArrayList<Entry>();
		List<Entry> femaleArray = new ArrayList<Entry>();
		
		String fn = "NationalNamesFinal.txt";
		File file = new File(fn);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()){
				String data = scanner.next();
			//	System.out.println(data);
				//System.out.println("Before Male.");
				if(data.equals("M")){
					//System.out.println("Male List.");
					String babyName = scanner.next();
					int nameCount = scanner.nextInt();
					Entry newEntry = new Entry(babyName, nameCount);
					if(maleArray.isEmpty()){
						maleArray.add(newEntry);
					}
					else{
						int updateIndex = 0;
						boolean exists = false;
						for(int i = 0; i < maleArray.size(); i++){
							String check = maleArray.get(i).getName();
							if(babyName.equals(check)){
								exists = true;
								updateIndex = i;
								break;
							} 
						}
						if(exists == true){
							//System.out.println("Duplicate found");
							int oldCount = maleArray.get(updateIndex).getCount();
							int newCount = oldCount + nameCount;
							maleArray.remove(updateIndex);
							Entry updateEntry = new Entry(babyName, newCount);
							maleArray.add(updateEntry);
						}
						else{
							maleArray.add(newEntry);
						}
					}
				}
				//System.out.println("Before Female.");
				else if(data.equals("F")){
					//System.out.println("Female List.");
					String babyName = scanner.next();
					int nameCount = scanner.nextInt();
					Entry newEntry = new Entry(babyName, nameCount);
					if(femaleArray.isEmpty()){
						femaleArray.add(newEntry);
					}
					else{
						int updateIndex = 0;
						boolean exists = false;
						for(int i = 0; i < femaleArray.size(); i++){
							String check = femaleArray.get(i).getName();
							if(babyName.equals(check)){
								exists = true;
								updateIndex = i;
								break;
							}
						}
						if(exists == true){
							//System.out.println("Duplicate found");
							int oldCount = femaleArray.get(updateIndex).getCount();
							int newCount = oldCount + nameCount;
							femaleArray.remove(updateIndex);
							Entry updateEntry = new Entry(babyName, newCount);
							femaleArray.add(updateEntry);
						}
						else{
							femaleArray.add(newEntry);
						}
					}
				}
				else{
					System.out.println("Error.");
				}
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //Incase file can not be found
		}
		
		
		Collections.sort(femaleArray, new customComparator());
		Collections.sort(maleArray, new customComparator());
		System.out.println("Female Top 25 Names:");
		for(int i = 0; i < 25; i++){
			System.out.println(femaleArray.get(i).getName() + " - " + femaleArray.get(i).getCount());
			System.out.println("");
		}
		
		System.out.println("Male Top 25 Names:");
		for(int i = 0; i < 25; i++){
			System.out.println(maleArray.get(i).getName() + " - " + maleArray.get(i).getCount());
			System.out.println("");
		}
	}
}
