package com.lpr;

public class JniTestAndroid {
   public native byte[]  recognition(byte arr[]);
   
	static {
		System.loadLibrary("AndroidCallsoDemo");//
		//	System.out.println(System.getProperty("java.library.path"));
		//	System.setProperty("java.library.path", ".");
	}
}