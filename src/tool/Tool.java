package tool;

import java.util.Random;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 3:30:56 PM 
 * @version 1.0 
 * @param 
 */

public class Tool {

	/**
	 * Generate ID Randomly
	 * @return long
	 */
	public static long generateID() {
		Random random = new Random(System.currentTimeMillis());
		long tmp;
		do {
			tmp = random.nextLong();
		} while (tmp < Integer.MAX_VALUE);
		return tmp;
	}
	
}
