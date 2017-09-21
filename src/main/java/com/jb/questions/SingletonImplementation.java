package com.jb.questions;

public class SingletonImplementation {

	private SingletonImplementation() {

	}

	private static class SingletonHelper {
		private static final SingletonImplementation Instance = new SingletonImplementation();
	}

	public static SingletonImplementation getInstance() {
		return SingletonHelper.Instance;
	}

}
