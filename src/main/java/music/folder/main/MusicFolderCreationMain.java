package music.folder.main;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import music.folder.processor.MusicFileProcessor;

public class MusicFolderCreationMain {

	public static void main(String[] args) {

		Options options = new Options();

		options.addRequiredOption("m", "musicRootFolder", true, "music folder");
		options.addRequiredOption("f", "filesLocation", true, "files to move folder");

		HelpFormatter formatter = new HelpFormatter();

		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);

			String musicRootFolderPath = cmd.getOptionValue("musicRootFolder");
			String fileLocationPath = cmd.getOptionValue("filesLocation");

			File musicRootFolder = new File(musicRootFolderPath);
			File fileLocation = new File(fileLocationPath);

			if (!musicRootFolder.exists() || !musicRootFolder.isDirectory()) {
				throw new IllegalArgumentException(String.format("%s must be a directory", musicRootFolderPath));
			}

			if (!fileLocation.exists() || !fileLocation.isDirectory()) {
				throw new IllegalArgumentException(String.format("%s must be a directory", fileLocation));
			}

			MusicFileProcessor musicFileProcessor = new MusicFileProcessor();
			musicFileProcessor.moveFiles(musicRootFolderPath, fileLocationPath);

		} catch (ParseException e) {
			e.printStackTrace();
			formatter.printHelp("MusicFolderCreationMain", options);
		}

	}

}
