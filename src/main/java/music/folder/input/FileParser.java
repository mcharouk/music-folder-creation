package music.folder.input;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import music.folder.bean.IMusicFile;
import music.folder.bean.impl.MusicFile;

public class FileParser {

	private String rootFolder;

	Mp3FileFilter mp3FileFilter = new Mp3FileFilter();

	public FileParser(String rootFolder) {
		super();
		this.rootFolder = rootFolder;
	}

	public List<IMusicFile> getMusicFiles() {
		return FileUtils.listFiles(FileUtils.getFile(rootFolder), mp3FileFilter, null).stream().map(file -> {
			try {
				
				ID3v2 mp3Tags = new Mp3File(file.getAbsolutePath()).getId3v2Tag();
				return Optional.of(new MusicFile(mp3Tags.getArtist(), mp3Tags.getGenreDescription(), file));
			} catch (UnsupportedTagException | InvalidDataException | IOException e) {
				System.out.println(String.format("unable to read %s", file.getAbsolutePath()));
				e.printStackTrace();
				return Optional.empty();
			}
		}).filter(Optional::isPresent).map(optional -> (MusicFile)optional.get()).collect(Collectors.toList());
	}

}
