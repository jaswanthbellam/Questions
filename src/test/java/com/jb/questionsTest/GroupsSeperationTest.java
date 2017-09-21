package com.jb.questionsTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.jb.questions.GroupsSeperation;

public class GroupsSeperationTest {
	
	@Test
	public void testGroupSeperationForPossibleValues() {
		
		List<Integer> list = Arrays.asList(11, 9, 1, 2, 7, 4, 10);
		assertTrue(GroupsSeperation.checkPartition(list,4));
		
	}
	
	@Test
	public void testGroupSeperationForImPossibleValues() {
		
		List<Integer> list1 = Arrays.asList(120,90,15,25,5,10);
		List<Integer> list2 = Arrays.asList(138,100,20,12);
		assertFalse(GroupsSeperation.checkPartition(list1,2));
		assertFalse(GroupsSeperation.checkPartition(list2,2));
	}
	
	@Test
	public void testGroupSeperationForNullList() {
		
		List<Integer> list = null;
		assertFalse(GroupsSeperation.checkPartition(list, 8));
	}
	
	@Test
	public void testGroupSepeartionForKgtListSize() {
		
		List<Integer> list = Arrays.asList(5,9,4,18);
		assertFalse(GroupsSeperation.checkPartition(list, 4));
	}

}
