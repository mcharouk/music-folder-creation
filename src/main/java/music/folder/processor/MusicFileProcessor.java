package music.folder.processor;

import java.util.List;

import music.folder.bean.IMusicFile;
import music.folder.input.FileParser;
import music.folder.output.impl.OutputMusicHandler;
import music.folder.output.impl.OutputMusicHandlerImpl;

public class MusicFileProcessor {
	
	public void createFolders(String musicRootFolder, String filesRootFolder){
		FileParser fileParser = new FileParser(filesRootFolder);
		List<IMusicFile> files = fileParser.getMusicFiles();
		
		OutputMusicHandler outputMusicHandler = new OutputMusicHandlerImpl();
		outputMusicHandler.moveFiles(musicRootFolder, files);
	}
	
	

}
