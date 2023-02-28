package utils;

import java.io.File;

import org.ini4j.Wini;

public class ReadiniFile {
	public Wini ini;

	public ReadiniFile(String filepath) {
		try {
			ini = new Wini(new File(filepath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readSection(String msec, String mkey) {
		String value = ini.get(msec, mkey);
		return value;
	}
}
