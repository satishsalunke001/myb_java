package com.rts.myb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

public class CommonUtils {

	public static String reNameImage(MultipartFile file, String fileName) {
		String imageName = fileName+"_"+System.currentTimeMillis() + "."
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		
		return imageName;
	}
	
	public static Date formatDate(String strDate, String format) {
		if (null != strDate && !strDate.isEmpty()) {
			try {
				return new SimpleDateFormat(format).parse(strDate);
			} catch (ParseException ex) {
				// logger.debug("Error while parsing date: " + strDate, ex);
				System.out.println("Error while parsing date: " + strDate + ex.getMessage());
			}
		}
		return null;
	}

	public static String formatDate(Date date, String format) {
		if (null != date) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				String sqlDate = dateFormat.format(date);
				return sqlDate;
			} catch (Exception ex) {
				// logger.debug("Error while parsing date: " + date, ex);
				System.out.println("Error while parsing date: " + date + ex.getMessage());
			}
		}
		return null;
	}
	
	public String getUniqueReferId() {
		Random random = new Random();
		return String.format("%09d", random.nextInt(1000000000));
	}
}
