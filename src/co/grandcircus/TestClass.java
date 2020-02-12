package co.grandcircus;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestClass {
	
	
	
	
	@Test
	void theGodfatherIsPopular() {
		
		ArrayList<Media> list = new ArrayList<>();
		
		list = Methods.filterByAuthor("Coppola", DVDs.mediaFromFiles());
		
		assertTrue(list.size() == 2);	
		
	}

	
	@Test
	void narniaDidntMakeTheCut() {
		
		ArrayList<Media> list = new ArrayList<>();
		
		list = Methods.filterByAuthor("Lewis", DVDs.mediaFromFiles());
		
		assertTrue(list.size() == 0);	
		
	}
	
	@Test
	void doOtherAuthorsIncludecop() {
		
		ArrayList<Media> list = new ArrayList<>();
		
		list = Methods.filterByAuthor("cop", DVDs.mediaFromFiles());
		
		assertTrue(list.size() == 2);	
		
	}
	
	@Test
	void howManyAs() {
		
		ArrayList<Media> list = new ArrayList<>();
		
		list = Methods.filterByAuthor("a", DVDs.mediaFromFiles());
		
		assertTrue(list.size() == 27);	
		
	}
	
	@Test
	void nums() {
		
		ArrayList<Media> list = new ArrayList<>();
		
		list = Methods.filterByAuthor("12312", DVDs.mediaFromFiles());
		
		assertTrue(list.size() == 0);	
		
	}
	
	@Test
	void symbols() {
		
		ArrayList<Media> list = new ArrayList<>();
		
		list = Methods.filterByAuthor("!@#$A%", DVDs.mediaFromFiles());
		
		assertTrue(list.size() == 0);	
		
	}
}
