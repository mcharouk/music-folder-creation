package music.folder.test;

import org.junit.Assert;

import cucumber.api.java8.En;
import music.folder.bean.impl.MusicFile;
import music.folder.test.builder.MusicFileBuilder;

public class MusicFolderStepDefs implements En {	
	
	MusicFileBuilder musicFileBuilder;
	MusicFile musicFile;
	
	public MusicFolderStepDefs() {		
		Before(() -> {
			musicFileBuilder = new MusicFileBuilder();
			musicFile = null;
		});

		

		Given("^some file with a tag artist as \"([^\"]*)\"$", (String artistName) -> {
			musicFileBuilder.withArtistName(artistName);
		});

		Given("^tag genre as \"([^\"]*)\"$", (String genre) -> {
			musicFileBuilder.withGenre(genre);
		});

		When("^i create a file$", () -> {
			musicFile = musicFileBuilder.build();
		});

		Then("^relative path folder should be \"([^\"]*)\"$", (String relativePath) -> {
			Assert.assertTrue(String.format("relativeTargetPath is %s", musicFile.getRelativeTargetPath()),
					relativePath.equals(musicFile.getRelativeTargetPath().get()));
		});
	}

}
