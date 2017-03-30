package Clase3TDD.RecentFileList;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class RecentFilesTest {
	
	@Mock
	RecentGenericList<File> mockedFiles;
	File mockedFile;
	
	private RecentFiles recentFiles;

	@Before
	public void init(){
		recentFiles = new RecentFiles(4);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenProgramRunFirstTimeThenListIsEmpty() {
		assertTrue(recentFiles.getRecentFiles().isEmpty());
	}
	
	@Test
	public void whenFileisOpenededThenisAddedToTheList(){
		recentFiles.openFile(mockedFile);
		assertTrue(recentFiles.getRecentFiles().containsElement(mockedFile));
	}
	
	@Test
	public void whenListFullThenReturnsTrue(){
		
		File mockedFile1 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile1);
		
		File mockedFile2 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile2);
		
		File mockedFile3 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile3);
		
		File mockedFile4 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile4);
		
		assertTrue(recentFiles.isListFull());
		
	}
	
	@Test
	public void whenListIsNotFullThenReturnsFalse(){
		recentFiles.openFile(mockedFile);
		assertFalse(recentFiles.isListFull());
	}
	
	@Test
	public void whenOpenedFileExistsInListThenItsBumpedToTheTopAndNotDuplicated(){
		
		File mockedFile1 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile1);
		
		File mockedFile2 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile2);
		recentFiles.openFile(mockedFile1);
		
		assertEquals(mockedFile1, recentFiles.getRecentFiles().getFirstElement());
		/* indexOf() returns the 1st occurrence of the element
		lastIndexOf() returns the last occurrence of the element
		so if the values are equals that means that there is only one occurrence */
		assertEquals(recentFiles.getRecentFiles().indexOfElement(mockedFile1), recentFiles.getRecentFiles().lastIndexOfElement(mockedFile1));
	}
	
	@Test
	public void whenFileisOpenedAndListIsFullThenOldestFileIsRemoved(){
		File mockedFile1 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile1);
		
		File mockedFile2 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile2);
		
		File mockedFile3 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile3);
		
		File mockedFile4 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile4);
		
		File mockedFile5 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile5);
		
		assertFalse(recentFiles.getRecentFiles().containsElement(mockedFile1));
		
	}
	
	@Test
	public void whenFileisOpenedAndListIsFullThenRecentsFilesKeepsTheSameSize(){
		
		Mockito.when(mockedFiles.getSize()).thenReturn(4);
		File mockedFile1 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile1);
		
		File mockedFile2 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile2);
		
		File mockedFile3 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile3);
		
		File mockedFile4 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile4);
		
		File mockedFile5 = Mockito.mock(File.class);
		recentFiles.openFile(mockedFile5);
		
		assertEquals(mockedFiles.getSize(),recentFiles.getRecentFiles().getSize());
		Mockito.verify(mockedFiles).getSize();
		
	}
	

}
