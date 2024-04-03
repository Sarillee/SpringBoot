package com.test.mbb;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

public class Util 
{
	static public void writeLog(String function,String msg,boolean type)
	{
		System.out.println(function);
		try 
		{
			String time = new SimpleDateFormat("YYYYMMDDHHmmss").format(Calendar.getInstance().getTime());
			String filename = time.substring(0,8) + "ApiLog.txt";
			File file = new File(filename);
			FileWriter fr = new FileWriter(file, true);
			if(type) {fr.write(time + "::" + function + "-->" + msg + "\n");}
			else {fr.write(time + "::" + function + "<--" + msg + "\n");}
			fr.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
