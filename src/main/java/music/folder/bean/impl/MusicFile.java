package music.folder.bean.impl;

import java.io.File;

import music.folder.bean.IMusicFile;

public class MusicFile implements IMusicFile {
	
	String artistName;
	String kind;
	File file;

	public MusicFile(String artistName, String kind, File file) {
		super();
		this.artistName = artistName;
		this.kind = kind;
		this.file = file;
	}

	@Override
	public File getFile() {
		return file;
	}

	@Override
	public String getArtistName() {
		return this.artistName;
	}

	@Override
	public String getKind() {
		return kind;
	}

	
}
