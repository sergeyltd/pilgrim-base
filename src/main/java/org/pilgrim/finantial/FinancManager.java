package org.pilgrim.finantial;

public class FinancManager {
	public static void main(String[] args) {
	    FMService fmService = FMService.newInstance();
	    fmService.load();
	}
}
