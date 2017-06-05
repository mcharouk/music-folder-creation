package music.folder.main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import music.folder.processor.MusicFileProcessor;

public class MusicFolderCreationMain {

	private static final Logger logger = LoggerFactory.getLogger(MusicFolderCreationMain.class);
	
	public static void main(String[] args) {

		Options options = setOptions();
		
		try {
			CommandLineParser parser = new DefaultParser();
			CommandLine cmd = parser.parse(options, args);

			String musicRootFolderPath = cmd.getOptionValue("musicRootFolder");
			String fileLocationPath = cmd.getOptionValue("filesLocation");
			
			validateInputs(musicRootFolderPath, fileLocationPath);

			MusicFileProcessor musicFileProcessor = new MusicFileProcessor();
			musicFileProcessor.moveFiles(musicRootFolderPath, fileLocationPath);

		} catch (ParseException e) {
			logger.error("Error while parsing arguments ", e);
			printUsage(options);
			
		}

	}

	private static Options setOptions() {
		Options options = new Options();

		options.addRequiredOption("m", "musicRootFolder", true, "music folder");
		options.addRequiredOption("f", "filesLocation", true, "files to move folder");
		return options;
	}

	private static void validateInputs(String musicRootFolderPath, String fileLocationPath) {
		
		File musicRootFolder = new File(musicRootFolderPath);
		File fileLocation = new File(fileLocationPath);
		
		if (!musicRootFolder.exists() || !musicRootFolder.isDirectory()) {
			throw new IllegalArgumentException(String.format("%s must be a directory", musicRootFolderPath));
		}

		if (!fileLocation.exists() || !fileLocation.isDirectory()) {
			throw new IllegalArgumentException(String.format("%s must be a directory", fileLocation));
		}
	}

	private static void printUsage(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintWriter logPrintWriter = new PrintWriter(byteArrayOutputStream, true);
		formatter.printUsage(logPrintWriter, 1000, "MusicFolderCreationMain", options);
		logger.info(new String(byteArrayOutputStream.toByteArray()));
	}

}
