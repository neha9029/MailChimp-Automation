package com.mailchimp.csv;

import static com.mailchimp.testcases.TestNGTestCases.driver;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.mailchimp.webpages.AboutMailChimpPage;

public class CSVFile {


	private static final Pattern removeTags = Pattern.compile("<.+?>");

	//Method to write data into CSV File
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

			String names[] = (AboutMailChimpPage.getMemberName(driver));
			String position[] = (AboutMailChimpPage.getMemberPosition(driver));
			String description[] = (AboutMailChimpPage.getMemberDescription(driver));

			bufferWriter.newLine();

			for (int i = 0; i < 14; i++) {
				bufferWriter.append(removeTags(names[i]));

				bufferWriter.append(separator);
			    bufferWriter.append(removeTags(position[i]));

				bufferWriter.append(separator);
				bufferWriter.append("\"");
				bufferWriter.append(removeTags(description[i]));
				bufferWriter.append("\"");

				bufferWriter.newLine();
			}

			bufferWriter.flush();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static String removeTags(String string) {
		if (string == null || string.length() == 0) {
			return string;
		}

		Matcher m = removeTags.matcher(string);
		return m.replaceAll("").replaceAll("\r", "").replaceAll("\n", "");
	}

}
