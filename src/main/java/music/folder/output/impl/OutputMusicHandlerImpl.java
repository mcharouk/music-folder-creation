package music.folder.output.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import music.folder.bean.IMusicFile;

public class OutputMusicHandlerImpl implements OutputMusicHandler {

	@Override
	public void moveFiles(String rootFolder, List<IMusicFile> fileList) {

		fileList.stream().forEach(file -> {
			File targetFolder = new File(String.format("%s/%s/%s", rootFolder, file.getKind(), file.getArtistName()));
			try {
				System.out.println(String.format("Moving file %s to %s", file.getFile(), targetFolder));
				FileUtils.moveFileToDirectory(file.getFile(), targetFolder, true);
			} catch (IOException e) {
				System.out.println(String.format("cannot move file %s to %s", file.getFile().getAbsolutePath(),
						targetFolder.getAbsolutePath()));
			}
		});

	}

}
