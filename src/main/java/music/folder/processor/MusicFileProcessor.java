package music.folder.processor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import music.folder.bean.IMusicFile;
import music.folder.input.FileParser;
import music.folder.output.impl.OutputMusicHandler;
import music.folder.output.impl.OutputMusicHandlerImpl;

public class MusicFileProcessor {
	
	private static final Logger logger = LoggerFactory.getLogger(MusicFileProcessor.class);
	
	public void moveFiles(String musicRootFolder, String filesRootFolder){
		FileParser fileParser = new FileParser(filesRootFolder);
		List<IMusicFile> files = fileParser.getMusicFiles();
		
		if(files.isEmpty()){
			logger.info(String.format("No files found under folder %s", filesRootFolder));
		} else {
			logger.info(String.format("%d files found under folder %s", files.size()));
		}
		
		OutputMusicHandler outputMusicHandler = new OutputMusicHandlerImpl();
		outputMusicHandler.moveFiles(musicRootFolder, files);
	}
	
	

}
