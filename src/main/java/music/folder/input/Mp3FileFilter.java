package music.folder.input;

import java.io.File;

import org.apache.commons.io.filefilter.IOFileFilter;

public class Mp3FileFilter implements IOFileFilter {

	@Override
	public boolean accept(File folder, String fileName) {
		return fileName.toLowerCase().endsWith(".mp3");
	}

	@Override
	public boolean accept(File file) {
		return file.getName().toLowerCase().endsWith(".mp3");
	}

}
