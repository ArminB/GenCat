/**
 * 
 */
package GenCat;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Armin
 * GenCat shall scan a given directory (and subdirectoriesI for
 * given filenames.
 * A record is generated for each file, from the filename
 * a set of configurable record fields is filled.
 *   
 */
public class GenCat {
	File directory;
	String filemask;
	public GenCat(File directory, String filemask) {
		super();
		this.directory = directory;
		this.filemask = filemask;
	}
	

}
