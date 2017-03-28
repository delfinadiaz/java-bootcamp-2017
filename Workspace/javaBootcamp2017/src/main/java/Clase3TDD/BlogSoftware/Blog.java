package Clase3TDD.BlogSoftware;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Blog {
	private LinkedList<Entry> entries = new LinkedList<Entry>();
	
	public void postEntry(Entry entry) {
		// TODO Auto-generated method stub
		entries.addFirst(entry);
	}

	public LinkedList<Entry> getEntries() {
		return entries;
	}

	public boolean removeEntry(Entry entry) {
		// TODO Auto-generated method stub
		if (entries.contains(entry)){
		  entries.remove(entry);
		  return true;
		}
		else {
			return false;
		}
		
	}

	public List<Entry> show10MostRecentEntries() {
		// TODO Auto-generated method stub
		List<Entry> subList= entries.subList(0,10);
		Iterator<Entry> it = subList.listIterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			System.out.println("Entry Title: " + entry.getTitle());
			System.out.println("Entry Content: " + entry.getContent());
		}
		
		return subList;
	}

	

}
