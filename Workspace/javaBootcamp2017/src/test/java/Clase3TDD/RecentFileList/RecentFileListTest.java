package Clase3TDD.RecentFileList;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class RecentFileListTest {
	private RecentFiles recentFiles;

	@Before
	public void init(){
		recentFiles = new RecentFiles(15);
	}

	@Test
	public void whenProgramRunFirstTimeThenListIsEmpty() {
		assertTrue(recentFiles.getRecentFiles().isEmpty());
	}
	
	@Test
	public void whenFileisOpenededThenisAddedToTheList(){
		File file = new File("a file");
		recentFiles.openFile(file);
		assertTrue(recentFiles.getRecentFiles().containsElement(file));
	}
	
	@Test
	public void whenListFullThenReturnsTrue(){
		File file1 = new File("a file1");
		recentFiles.openFile(file1);
		File file2 = new File("a file2");
		recentFiles.openFile(file2);
		File file3 = new File("a file3");
		recentFiles.openFile(file3);
		File file4 = new File("a file4");
		recentFiles.openFile(file4);
		File file5 = new File("a file5");
		recentFiles.openFile(file5);
		File file6 = new File("a file6");
		recentFiles.openFile(file6);
		File file7 = new File("a file7");
		recentFiles.openFile(file7);
		File file8 = new File("a file8");
		recentFiles.openFile(file8);
		File file9 = new File("a file9");
		recentFiles.openFile(file9);
		File file10 = new File("a file10");
		recentFiles.openFile(file10);
		File file11 = new File("a file11");
		recentFiles.openFile(file11);
		File file12 = new File("a file12");
		recentFiles.openFile(file12);
		File file13 = new File("a file13");
		recentFiles.openFile(file13);
		File file14 = new File("a file14");
		recentFiles.openFile(file14);
		File file15 = new File("a file15");
		recentFiles.openFile(file15);
		assertTrue(recentFiles.isListFull());
		
	}
	
	@Test
	public void whenListIsNotFullThenReturnsFalse(){
		File file = new File("a file");
		recentFiles.openFile(file);
		assertFalse(recentFiles.isListFull());
	}
	
	@Test
	public void whenOpenedFileExistsInListThenItsBumpedToTheTopAndNotDuplicated(){
		File file1 = new File("a file1");
		recentFiles.openFile(file1);
		File file2 = new File("a file2");
		recentFiles.openFile(file2);
		recentFiles.openFile(file1);
		assertEquals(file1, recentFiles.getRecentFiles().getFirstElement());
		/* indexOf() returns the 1st occurrence of the element
		lastIndexOf() returns the last occurrence of the element
		so if the values are equals that means that there is only one occurrence */
		assertEquals(recentFiles.getRecentFiles().indexOfElement(file1), recentFiles.getRecentFiles().lastIndexOfElement(file1));
	}
	
	@Test
	public void whenFileisOpenedAndListIsFullThenOldestFileIsRemoved(){
		File file1 = new File("a file1");
		recentFiles.openFile(file1);
		File file2 = new File("a file2");
		recentFiles.openFile(file2);
		File file3 = new File("a file3");
		recentFiles.openFile(file3);
		File file4 = new File("a file4");
		recentFiles.openFile(file4);
		File file5 = new File("a file5");
		recentFiles.openFile(file5);
		File file6 = new File("a file6");
		recentFiles.openFile(file6);
		File file7 = new File("a file7");
		recentFiles.openFile(file7);
		File file8 = new File("a file8");
		recentFiles.openFile(file8);
		File file9 = new File("a file9");
		recentFiles.openFile(file9);
		File file10 = new File("a file10");
		recentFiles.openFile(file10);
		File file11 = new File("a file11");
		recentFiles.openFile(file11);
		File file12 = new File("a file12");
		recentFiles.openFile(file12);
		File file13 = new File("a file13");
		recentFiles.openFile(file13);
		File file14 = new File("a file14");
		recentFiles.openFile(file14);
		File file15 = new File("a file15");
		recentFiles.openFile(file15);
		File file16 = new File("a file16");
		recentFiles.openFile(file16);
		assertFalse(recentFiles.getRecentFiles().containsElement(file1));
		
	}

}
