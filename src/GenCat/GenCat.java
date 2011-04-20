/**
 * 
 */
package GenCat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
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
	File configFile;
	public String filemask;
 
	public GenCat(File directory, File configFile) throws SecurityException, NoSuchFieldException {
		super();
		this.directory = directory;
		this.configFile = configFile;
		readConfigFile();
		
	}
	private void readConfigFile() throws SecurityException {
		// TODO: if not given configFile to be searched in this.directory
		try {
		    BufferedReader configReader = new BufferedReader(new FileReader(this.configFile));
		    String line;
		    Class c = null; 
		    try {
				c = Class.forName("GenCat.GenCat");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    while ((line = configReader.readLine()) != null) {
		    	if (! java.util.regex.Pattern.matches("(//).*",line)) {
		    		java.util.regex.Pattern p = Pattern.compile(":=");
		    		String[] result = p.split(line);
		    		String key = result[0].trim();
		    		String value = result[1].trim();
		    		try {
						Field f = c.getField(key);
						f.set(this, value);
					} catch (NoSuchFieldException e) {
						// ignore
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
			}
		    configReader.close();
		} catch (IOException e) {
		}

	}

}
