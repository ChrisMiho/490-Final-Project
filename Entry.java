public class Entry {
	String name;
	int count;
	
	public Entry(){
		
	}
	
	public Entry(String name1, int count1){
		name = name1;
		count = count1;		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getCount(){
		return count;
	}
	
	public void setCount(int Count){
		this.count = count;
	}
}
