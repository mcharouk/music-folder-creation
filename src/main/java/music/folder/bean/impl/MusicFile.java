package music.folder.bean.impl;

import java.io.File;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

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
	public Optional<String> getRelativeTargetPath() {
		
		if(StringUtils.isEmpty(artistName) || StringUtils.isEmpty(kind) ){
			return Optional.empty();
		}
		return Optional.of(String.format("%s/%s", kind, artistName));
	}
	
}
