package com.smarttechnow.patrick;

import java.util.Comparator;

public class IgnoreCaseComparator implements Comparator<String> {

	public int compare(String string1, String string2) {
	    return string1.compareToIgnoreCase(string2);
	  }

}
