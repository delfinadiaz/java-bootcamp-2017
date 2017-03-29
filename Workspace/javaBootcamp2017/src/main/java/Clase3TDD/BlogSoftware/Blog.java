package Clase3TDD.BlogSoftware;

import java.util.LinkedList;
import java.util.List;

import Clase3TDD.RecentFileList.RecentGenericList;

import java.util.Iterator;

public class Blog {
	private RecentGenericList<Entry> entries = new RecentGenericList<Entry>();
	
	public void postEntry(Entry entry) {
		// TODO Auto-generated method stub
		entries.addFirstElement(entry);
	}

	public LinkedList<Entry> getEntries() {
		return entries.getList();
	}

	public boolean removeEntry(Entry entry) {
		// TODO Auto-generated method stub
		  return entries.removeElement(entry);
		
	}

	public List<Entry> show10MostRecentEntries() {
		// TODO Auto-generated method stub
		List<Entry> subList;
		if (entries.isEmpty()){
			System.out.println("The blog doesn't have any entries yet");
			return entries.getList();
		}
		else {
			if (entries.getSize()>= 10){
				subList= entries.getSubList(0,10);
			}
			else {
				subList= entries.getSubList(0,entries.getSize());
			}
			Iterator<Entry> it = subList.listIterator();
			while (it.hasNext()) {
				Entry entry = it.next();
				System.out.println("Entry Title: " + entry.getTitle());
				System.out.println("Entry Content: " + entry.getContent());
			}
			
			return subList;
		}
	}

	

}
