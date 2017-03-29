package Clase3TDD.RecentFileList;

import java.io.File;

public class RecentFiles {
	private RecentGenericList<File> list = new RecentGenericList<File>();
	private int maxSizeList;
	
	public RecentFiles(int aMaxSizeList){
		maxSizeList = aMaxSizeList;
	}
	
	public RecentGenericList<File> getRecentFiles(){
		return list;
	}
	public void openFile(File file) {
		// TODO Auto-generated method stub
		if (list.containsElement(file)){
			list.bumpElementToTheTop(file);
		}
		else {
			if(isListFull()){
				list.removeLastElement();
			}
			list.addFirstElement(file);
		}
		
	}
	
	protected boolean isListFull() {
		// TODO Auto-generated method stub
		return (list.getSize() == getMaxSizeList());
	}

	public int getMaxSizeList() {
		return maxSizeList;
	}

	public void setMaxSizeList(int maxSizeList) {
		this.maxSizeList = maxSizeList;
	}
}
