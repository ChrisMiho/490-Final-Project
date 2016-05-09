import java.util.Comparator;

public class customComparator implements Comparator<Entry>{

	@Override
	public int compare(Entry o1, Entry o2) {
		if(o1.getCount() < o2.getCount()){
			return 1;
		}
		else if(o1.getCount() > o2.getCount()){
			return -1;
		}
		else{
			return 0;
		}
	}

	
}
