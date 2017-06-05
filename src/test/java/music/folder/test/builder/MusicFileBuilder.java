package music.folder.test.builder;

import music.folder.bean.impl.MusicFile;

public class MusicFileBuilder {

	String artistName;
	String genre;
	
	public MusicFileBuilder withArtistName(String artistName){
		this.artistName = artistName;
		return this;
	}
	
	public MusicFileBuilder withGenre(String genre){
		this.genre = genre;
		return this;
	}
	
	
	public MusicFile build(){
		return new MusicFile(artistName, genre, null);
	}
	
}
