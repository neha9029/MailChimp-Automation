package com.mailchimp.csv;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import static com.mailchimp.testcases.TestNGTestCases.driver;

import com.mailchimp.webpages.AboutMailChimpPage;


public class CSVFile {
	
	public static void writeToCSVFile(String filePath, String separator) throws IOException {
		FileOutputStream ft = null;
		OutputStream fileOutStream = null;
		Writer outStreamWriter = null;
		BufferedWriter bufferWriter = null;
		try {
			ft = new FileOutputStream(filePath);
			fileOutStream = new BufferedOutputStream((ft));
			outStreamWriter = new OutputStreamWriter(fileOutStream, StandardCharsets.UTF_8);
			bufferWriter = new BufferedWriter(outStreamWriter);
			
			bufferWriter.append("Name");
			bufferWriter.append(separator);
			bufferWriter.append("Position");
			bufferWriter.append(separator);
			bufferWriter.append("Description");
			bufferWriter.flush();
			
		

		
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}

	}

}
