package Clase3TDD.RecentFileList;

import java.io.File;
import java.util.LinkedList;

public class RecentFileList {
	private LinkedList<File> list= new LinkedList<File>();
	private int maxSizeList;

	public RecentFileList(int aMaxSizeList){
		maxSizeList= aMaxSizeList;
	}
	
	public LinkedList<File> getList() {
		// TODO Auto-generated method stub
		return list;
	}

	public void openFile(File file) {
		// TODO Auto-generated method stub
		if (list.contains(file)){
			bumpFileToTheTop(file);
		}
		else {
			if(isListFull()){
				list.removeLast();
			}
			list.addFirst(file);
		}
		
	}

	protected boolean isListFull() {
		// TODO Auto-generated method stub
		return (list.size() == getMaxSizeList());
	}

	protected void bumpFileToTheTop(File file) {
		// TODO Auto-generated method stub
		list.remove(file);
		list.addFirst(file);
		
	}

	public int getMaxSizeList() {
		return maxSizeList;
	}

	public void setMaxSizeList(int maxSizeList) {
		this.maxSizeList = maxSizeList;
	}
    


}
