package Clase3TDD.BlogSoftware;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Clase3TDD.RecentFileList.RecentGenericList;


public class BlogTest {
	@Mock
	RecentGenericList<Entry> mockedEntries;
	Entry mockedEntry;
	
	private Blog blog;
	
	@Before
	public void init() {
		blog = new Blog();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void whenPostNewEntryThenNewEntryIsAddedToTheBlog(){
		blog.postEntry(mockedEntry);
		assertTrue(blog.getEntries().contains(mockedEntry));
	}
	
	@Test
	public void whenDeleteExistingEntryThenTheEntryIsRemovedFromTheBlogAndReturnsTrue(){
		Entry mockedEntry2 = Mockito.mock(Entry.class);
		blog.postEntry(mockedEntry);
		blog.postEntry(mockedEntry2);
		assertTrue(blog.removeEntry(mockedEntry));
		assertFalse(blog.getEntries().contains(mockedEntry));
	}
	
	
	@Test
	public void whenShow10MostRecentEntriesThenThe10LastPostedEntriesAreReturned(){
		
		LinkedList<Entry> list = new LinkedList<Entry>();
		
		blog.postEntry(mockedEntry);
		
		Entry mockedEntry2 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry2.getTitle()).thenReturn("title2");
	    Mockito.when(mockedEntry2.getContent()).thenReturn("content2");
		blog.postEntry(mockedEntry2);
		list.addFirst(mockedEntry2);
		
		Entry mockedEntry3 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry3.getTitle()).thenReturn("title3");
	    Mockito.when(mockedEntry3.getContent()).thenReturn("content3");
		blog.postEntry(mockedEntry3);
		list.addFirst(mockedEntry3);
		
		Entry mockedEntry4 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry4.getTitle()).thenReturn("title4");
	    Mockito.when(mockedEntry4.getContent()).thenReturn("content4");
		blog.postEntry(mockedEntry4);
		list.addFirst(mockedEntry4);
		
		Entry mockedEntry5 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry5.getTitle()).thenReturn("title5");
	    Mockito.when(mockedEntry5.getContent()).thenReturn("content5");
		blog.postEntry(mockedEntry5);
		list.addFirst(mockedEntry5);
	
		Entry mockedEntry6 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry6.getTitle()).thenReturn("title6");
	    Mockito.when(mockedEntry6.getContent()).thenReturn("content6");
		blog.postEntry(mockedEntry6);
		list.addFirst(mockedEntry6);
		
		Entry mockedEntry7 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry7.getTitle()).thenReturn("title7");
	    Mockito.when(mockedEntry7.getContent()).thenReturn("content7");
		blog.postEntry(mockedEntry7);
		list.addFirst(mockedEntry7);
		
		Entry mockedEntry8 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry8.getTitle()).thenReturn("title8");
	    Mockito.when(mockedEntry8.getContent()).thenReturn("content8");
		blog.postEntry(mockedEntry8);
		list.addFirst(mockedEntry8);
		
		Entry mockedEntry9 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry9.getTitle()).thenReturn("title9");
	    Mockito.when(mockedEntry9.getContent()).thenReturn("content9");
		blog.postEntry(mockedEntry9);
		list.addFirst(mockedEntry9);
		
		Entry mockedEntry10 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry10.getTitle()).thenReturn("title10");
	    Mockito.when(mockedEntry10.getContent()).thenReturn("content10");
		blog.postEntry(mockedEntry10);
		list.addFirst(mockedEntry10);
		
		Entry mockedEntry11 = Mockito.mock(Entry.class);
		Mockito.when(mockedEntry11.getTitle()).thenReturn("title11");
	    Mockito.when(mockedEntry11.getContent()).thenReturn("content11");
		blog.postEntry(mockedEntry11);
		list.addFirst(mockedEntry11);
	
		Mockito.when(mockedEntries.getList()).thenReturn(list);
		assertEquals(mockedEntries.getList(),blog.show10MostRecentEntries());
		Mockito.verify(mockedEntries).getList();
		Mockito.verify(mockedEntry2).getTitle();
		Mockito.verify(mockedEntry2).getContent();
		Mockito.verify(mockedEntry3).getTitle();
		Mockito.verify(mockedEntry3).getContent();
		Mockito.verify(mockedEntry4).getTitle();
		Mockito.verify(mockedEntry4).getContent();
		Mockito.verify(mockedEntry5).getTitle();
		Mockito.verify(mockedEntry5).getContent();
		Mockito.verify(mockedEntry6).getTitle();
		Mockito.verify(mockedEntry6).getContent();
		Mockito.verify(mockedEntry7).getTitle();
		Mockito.verify(mockedEntry7).getContent();
		Mockito.verify(mockedEntry8).getTitle();
		Mockito.verify(mockedEntry8).getContent();
		Mockito.verify(mockedEntry9).getTitle();
		Mockito.verify(mockedEntry9).getContent();
		Mockito.verify(mockedEntry10).getTitle();
		Mockito.verify(mockedEntry10).getContent();
		Mockito.verify(mockedEntry11).getTitle();
		Mockito.verify(mockedEntry11).getContent();
	
	}
	
	@Test
	public void whenShow10MostRecentEntriesButBlogIsEmptyThenReturnsAnEmptyListAndShowsAMessage(){
		
		assertTrue(blog.show10MostRecentEntries().isEmpty());
     }
	
	@Test
	public void whenShow10MostRecentEntriesButThereAreLessEntriesThenReturnsExistingEntries(){
		Mockito.when(mockedEntries.getSize()).thenReturn(2);
		blog.postEntry(mockedEntry);
		Entry mockedEntry2 = Mockito.mock(Entry.class);
		blog.postEntry(mockedEntry2);
		assertEquals(mockedEntries.getSize(),blog.getEntries().size());
		Mockito.verify(mockedEntries).getSize();
		
     }
	


}
