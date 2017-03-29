package Clase3TDD.RecentFileList;

import java.util.LinkedList;
import java.util.List;

public class RecentGenericList<E>{
	private LinkedList<E> list= new LinkedList<E>();

	public RecentGenericList(){
	}
	
	public LinkedList<E> getList() {
		// TODO Auto-generated method stub
		return list;
	}

	public void bumpElementToTheTop(E element){
		list.remove(element);
		list.addFirst(element);
	}
	
	public boolean containsElement(E element){
		return list.contains(element);
	}
	
	public void removeLastElement(){
		list.removeLast();
	}
	
	public boolean removeElement(E element){
		if (list.contains(element)){
			  list.remove(element);
			  return true;
			}
	    else {
				return false;
			}
	}
	
	public void addFirstElement(E element){
		list.addFirst(element);
	}
	
	public int getSize(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public E getFirstElement(){
		return list.getFirst();
	}
	
	public int indexOfElement(E element){
		return list.indexOf(element);
	}
	
	public int lastIndexOfElement(E element){
		return list.lastIndexOf(element);
	}
	
	public List<E> getSubList(int fromIndex, int toIndex){
		return list.subList(fromIndex, toIndex);
	}
	
	
    


}
