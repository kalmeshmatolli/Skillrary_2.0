package generic_Library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * this method contains reusable java methods
 * @author yashu
 *
 */
public class JavaUtility {
	
	/**
	 * this method generate random number within the limit
	 * @param limit
	 */
	public void genaraterandomnumber(int limit) {
		Random random=new Random();
		int randowmnum=random.nextInt(limit);
	}
	
	/**
	 * this method is return time in specific formate
	 * @return
	 */
	public String getcurrentdatetime() {
		Date formate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		String currentTime=sdf.format(formate);
		return currentTime;

		
	}

}

