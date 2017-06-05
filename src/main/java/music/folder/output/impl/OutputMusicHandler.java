package music.folder.output.impl;

import java.util.List;

import music.folder.bean.IMusicFile;

public interface OutputMusicHandler {
	
	public void moveFiles( String rootFolder, List<IMusicFile> fileList);
	
}
