package com.activity4;

public class MyApp {

	 public static void main(String[] args) {
	        Executable excel = new MsExcel();
	        Executable word = new MsWord();

	        runProgram(excel);
	        runProgram(word);

	        stopProgram(excel);
	        stopProgram(word);
	    }

	    private static void runProgram(Executable executableProgram) {
	        executableProgram.run();
	    }

	     private static void stopProgram(Executable executableProgram) {
	        executableProgram.stop();
	    }

}
