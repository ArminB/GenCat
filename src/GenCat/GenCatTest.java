/**
 * 
 */
package GenCat;

import static org.junit.Assert.*;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

/**
 * @author Armin
 *
 */
public class GenCatTest {

	/**
	 * Test method for {@link GenCat.GenCat#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
//		String[] args = {"-d:\"D:\\Dokumente und Einstellungen\\Armin\\Eigene Dateien\\Eigene Musik\\PDF\\\""};
		String[] args = {"-d:D:\\Dokumente und Einstellungen\\Armin\\Eigene Dateien\\Eigene Musik\\PDF\\"};
		try {
			Shell.main(args);
		} catch (Exception e) {
			
			StringWriter sw = new StringWriter();
			PrintWriter ps  = new PrintWriter(sw);
			e.printStackTrace(ps);
			fail(sw.toString());
		}
		
	}
	/**
	 * Test method for {@link GenCat.GenCatTest#testMain()}.
	 */
	@Test
	public void testTestMain() {
		String[] args = {"-d:bin",
				         "-c:config.txt"};
		try {
			Shell.main(args);
		} catch (Exception e) {
			
			StringWriter sw = new StringWriter();
			PrintWriter ps  = new PrintWriter(sw);
			e.printStackTrace(ps);
			fail(sw.toString());
		}
	}


}
