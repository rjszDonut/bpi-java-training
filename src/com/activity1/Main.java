package com.activity1;

public class Main {

	public static void main(String[] args) {
		// tree object
		Tree tree = new Tree();
	    tree.name = "Puno";
	    tree.getTreeName();
	    
	    // House object   
	    House bahay = new House();
	    bahay.address = "bpi address";
	    bahay.getAddress();
	    
	    // Book object	    
	    Book book = new Book();
	    book.currentPage = 2;
	    book.getCurrentPage();
	}

}
