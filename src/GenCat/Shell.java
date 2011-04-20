/**
 * 
 */
package GenCat;

import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
	
/**
 * @author Armin
 *
 */
public class Shell {
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		if (args.length==0) {
			System.out.println("no arguments given");
			System.out.println("usage: GenCat -d:[\"]directory[\"]");
			return;
		}
		File mDirectory = null;
		File mConfig = null;
		// System.out.println("usage: GenCat -d:[\"]directory[\"]");
		for(int i = 0; i < args.length; i++) {
			
			if (java.util.regex.Pattern.matches("-d:.+",args[i])) {
				java.util.regex.Pattern p = Pattern.compile("-d:");
				String[] result = p.split(args[i]);
				mDirectory = new File(result[1]);
				if (! mDirectory.exists()) 
				{
					System.out.println(" does not exist!");
					throw (new Exception("no valid directory argument"));
				}
				if (! mDirectory.isDirectory()) { // workaround for isDirectory returns incorrect false
					System.out.println(" is no directory");
					throw (new Exception("no valid directory argument"));
				}
				System.out.print("Directory: ");
				System.out.println(result[1]);
			}
			
			
			if (java.util.regex.Pattern.matches("-c:.+",args[i])) {
				java.util.regex.Pattern p = Pattern.compile("-c:");
				String[] result = p.split(args[i]);
				mConfig= new File(result[1]);
				if (!mConfig.isAbsolute()) {
					mConfig = new File(mDirectory.getAbsolutePath()+ File.separatorChar + mConfig.getName());
				}

				if (! mConfig.exists()) 
				{
					System.out.println(mConfig.getAbsoluteFile());
					System.out.println(" does not exist!");
					throw (new Exception("no config file argument"));
				}
				if (mConfig.isDirectory()) { // workaround for isDirectory returns incorrect false
					System.out.println(" is a directory");
					throw (new Exception("no valid config file argument"));
				}
				System.out.print("Configuration: ");
				System.out.println(mConfig.getPath());
			}

		}
		GenCat gc = null;
		if ((mDirectory != null)  && (mConfig != null)) {
			 gc = new GenCat(mDirectory, mConfig);
		}
		else return;
	}

}
