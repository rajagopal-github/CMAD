package cmad.project.simulator;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import cmad.project.simulator.service.SyslogSimulatorService;

/**
 * Hello world!
 *
 */
public class App {
	private static Map<String, String> simulatorConfigurationMap = new HashMap<>();

	private static File syslogFile;

	public static void main(String[] args) {
		try {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***********************************************************************");
		System.out.println(
				"Welcome to the Syslog simulator. This simulator will write syslog messages from the syslog.txt to Database\n");
		System.out.println("***********************************************************************\n");

		System.out.println("Please enter the path to simulator-configuration.properties file in your system: ");
		String line = scanner.nextLine();
		if (line == null || line.isEmpty()) {
			System.out.println("Invalid file path. Existing...");
			return;
		} else {
			File f = new File(line.trim());
			if (f.exists() && f.isFile()) {
				loadPropertyFile(f);
			} else {
				System.out.println("Invalid file path" + line + ".Existing...");
				return;
			}
		}
		System.out.println("Please enter the sample Syslog file (syslog.txt) path in your system: ");
		line = scanner.nextLine();
		if (line == null || line.isEmpty()) {
			System.out.println("Invalid file path. Existing...");
			return;
		} else {
			File f = new File(line.trim());
			if (!(f.exists() && f.isFile())) {
				System.out.println("Invalid file path" + line + ".Existing...");
				return;
			} else {
				syslogFile = f;
			}
		}
		
		SyslogSimulatorService service = new SyslogSimulatorService();
		service.writeSyslogMessagesToDB(simulatorConfigurationMap, syslogFile);
		} catch(Exception exe) {
			System.out.println("Errror encounted");
			exe.printStackTrace();
			
		}

	}

	private static void loadPropertyFile(File propertyFile) throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream(propertyFile));

		for (Object key : prop.keySet()) {
			simulatorConfigurationMap.put((String) key, prop.getProperty((String) key));
		}

	}
}
