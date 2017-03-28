package Clase3TDD.RecentFileList;


import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class RecentFileListTest {
	private RecentFileList recentFileList;

	@Before
	public void init(){
		recentFileList = new RecentFileList(15);
	}

	@Test
	public void whenProgramRunFirstTimeThenListIsEmpty() {
		LinkedList<File> list = recentFileList.getList();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void whenFileisOpenededThenisAddedToTheList(){
		File file = new File("a file");
		recentFileList.openFile(file);
		LinkedList<File> list = recentFileList.getList();
		assertTrue(list.contains(file));
	}
	
	@Test
	public void whenListFullThenReturnsTrue(){
		File file1 = new File("a file1");
		recentFileList.openFile(file1);
		File file2 = new File("a file2");
		recentFileList.openFile(file2);
		File file3 = new File("a file3");
		recentFileList.openFile(file3);
		File file4 = new File("a file4");
		recentFileList.openFile(file4);
		File file5 = new File("a file5");
		recentFileList.openFile(file5);
		File file6 = new File("a file6");
		recentFileList.openFile(file6);
		File file7 = new File("a file7");
		recentFileList.openFile(file7);
		File file8 = new File("a file8");
		recentFileList.openFile(file8);
		File file9 = new File("a file9");
		recentFileList.openFile(file9);
		File file10 = new File("a file10");
		recentFileList.openFile(file10);
		File file11 = new File("a file11");
		recentFileList.openFile(file11);
		File file12 = new File("a file12");
		recentFileList.openFile(file12);
		File file13 = new File("a file13");
		recentFileList.openFile(file13);
		File file14 = new File("a file14");
		recentFileList.openFile(file14);
		File file15 = new File("a file15");
		recentFileList.openFile(file15);
		assertTrue(recentFileList.isListFull());
		
	}
	
	@Test
	public void whenListIsNotFullThenReturnsFalse(){
		File file = new File("a file");
		recentFileList.openFile(file);
		assertFalse(recentFileList.isListFull());
	}
	
	@Test
	public void whenOpenedFileExistsInListThenItsBumpedToTheTopAndNotDuplicated(){
		File file1 = new File("a file");
		recentFileList.openFile(file1);
		File file2 = new File("a file");
		recentFileList.openFile(file2);
		recentFileList.openFile(file1);
		assertEquals(file1, recentFileList.getList().getFirst());
		/* indexOf() returns the 1st occurrence of the element
		lastIndexOf() returns the last occurrence of the element
		so if the values are equals that means that there is only one occurrence */
		assertEquals(recentFileList.getList().indexOf(file1), recentFileList.getList().lastIndexOf(file1));
	}
	
	@Test
	public void whenFileisOpenedAndListIsFullThenOldestFileIsRemoved(){
		File file1 = new File("a file1");
		recentFileList.openFile(file1);
		File file2 = new File("a file2");
		recentFileList.openFile(file2);
		File file3 = new File("a file3");
		recentFileList.openFile(file3);
		File file4 = new File("a file4");
		recentFileList.openFile(file4);
		File file5 = new File("a file5");
		recentFileList.openFile(file5);
		File file6 = new File("a file6");
		recentFileList.openFile(file6);
		File file7 = new File("a file7");
		recentFileList.openFile(file7);
		File file8 = new File("a file8");
		recentFileList.openFile(file8);
		File file9 = new File("a file9");
		recentFileList.openFile(file9);
		File file10 = new File("a file10");
		recentFileList.openFile(file10);
		File file11 = new File("a file11");
		recentFileList.openFile(file11);
		File file12 = new File("a file12");
		recentFileList.openFile(file12);
		File file13 = new File("a file13");
		recentFileList.openFile(file13);
		File file14 = new File("a file14");
		recentFileList.openFile(file14);
		File file15 = new File("a file15");
		recentFileList.openFile(file15);
		File file16 = new File("a file16");
		recentFileList.openFile(file16);
		assertFalse(recentFileList.getList().contains(file1));
		
	}

}
