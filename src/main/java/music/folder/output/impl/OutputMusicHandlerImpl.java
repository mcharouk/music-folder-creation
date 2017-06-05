package music.folder.output.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import music.folder.bean.IMusicFile;

public class OutputMusicHandlerImpl implements OutputMusicHandler {

	
	private static final Logger logger = LoggerFactory.getLogger(OutputMusicHandlerImpl.class);
			
	@Override
	public void moveFiles(String rootFolder, List<IMusicFile> fileList) {

		fileList.stream().forEach(file -> {
			Optional<String> relativePath = file.getRelativeTargetPath(); 
			if(relativePath.isPresent()){
				File targetFolder = new File(String.format("%s/%s", rootFolder, file.getRelativeTargetPath()));
				try {
					logger.info(String.format("Moving file %s to %s", file.getFile(), targetFolder));
					FileUtils.moveFileToDirectory(file.getFile(), targetFolder, true);
				} catch (IOException e) {
					logger.error(String.format("cannot move file %s to %s", file.getFile().getAbsolutePath(),
							targetFolder.getAbsolutePath()), e);
				}
			} else {
				logger.warn(String.format("Missing genre or artist on file %s . Cannot move it.", file.getFile().getAbsolutePath()));
			}
			
		});

	}

}
