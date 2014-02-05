package com.smarttechnow.patrick;

import java.util.Comparator;

/**
 * This class is a helper class for ignoring cases of strings when placing the recipes in order
 * @author Patrick
 *
 */
public class IgnoreCaseComparator implements Comparator<String> {

	public int compare(String string1, String string2) {
	    return string1.compareToIgnoreCase(string2);
	  }

}
