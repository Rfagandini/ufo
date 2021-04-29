package it.polito.tdp.ufo.db;

import java.util.*;

public class testdb {
 
	public static void main(String[] args) {
		
	
		List<String> ArrayShape = new ArrayList<String>();
		
		SightingDAO dado = new SightingDAO();
		ArrayShape = dado.ExistingShapes();
		
		for(String s: ArrayShape) {
			System.out.println("The figure "+s+" contains : "+dado.CountByShape(s)+ " cases" );
		}
		
	}
}
