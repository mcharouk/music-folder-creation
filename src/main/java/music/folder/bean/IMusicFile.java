package music.folder.bean;

import java.io.File;
import java.util.Optional;

public interface IMusicFile {
	
	File getFile();
	Optional<String> getRelativeTargetPath();
}
