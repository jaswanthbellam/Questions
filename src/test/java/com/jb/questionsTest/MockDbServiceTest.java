package com.jb.questionsTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.jb.model.User;
import com.jb.questions.UserDao;
import com.jb.questions.UserService;

@Ignore
public class MockDbServiceTest {

	// Assuming we have Implementation service and Dao classes
	private static UserDao userDao;
	private static UserService userService;

	@BeforeClass
	public static void beforeClass() {

		userService = new UserService();
		userDao = Mockito.mock(UserDao.class);
		userService.setUserDao(userDao);

		User user = new User();
		user.setId(1);
		user.setName("Einstein");
		user.setPhone(666666666);
		
		//Mocking the necessary methods when called
		Mockito.when(userDao.find(Mockito.anyLong())).thenReturn(user);
		Mockito.doThrow(new RuntimeException("error on client!")).when(userDao).delete((User) Mockito.any());
		Mockito.doNothing().when(userDao).create((User) Mockito.any());
		Mockito.doAnswer(new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();

				User user = (User) args[0];
				user.setName("galileo");
				return user;
			}
		}).when(userDao).update((User) Mockito.any());

	}

	//Test Cases 
	@Test
	public void testFind() {

		User user = userService.find(10);
		Mockito.verify(userDao).find(10);
		assertEquals(user.getName(), "Einstein");

	}

	@Test
	public void testInsert() {

		User user = new User();
		user.setId(3);
		user.setName("Louis");
		user.setPhone(45454545);

		userService.create(user);
		Mockito.verify(userDao).create(user);

	}

	@Test
	public void testUpdate() {

		User user = userService.find(20);
		user.setPhone(33131311);
		userService.update(user);

		Mockito.verify(userDao).update(user);
		assertEquals(user.getName(), "User has changed!");

	}

	@Test(expected = RuntimeException.class)
	public void testRemove() {

		User user = userService.find(2);
		userService.delete(user);

	}

}
