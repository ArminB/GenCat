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
		String mfileMask = null;
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
			
			if (java.util.regex.Pattern.matches("-f:.+",args[i])) {
				java.util.regex.Pattern p = Pattern.compile("-f:");
				String[] result = p.split(args[i]);
				mfileMask= result[1];
				p = Pattern.compile(result[1]);
				//TODO: loop over files
				java.util.regex.Matcher m = p.matcher(""); // TODO: match fielname
				if (m.matches())
				{
				
				}
			}
		}
		GenCat gc = null;
		if ((mDirectory != null) && (mfileMask != null)) {
			 gc = new GenCat(mDirectory,mfileMask);
		}
		else return;
	}

}
