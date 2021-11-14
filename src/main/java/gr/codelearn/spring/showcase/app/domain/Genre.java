package gr.codelearn.spring.showcase.app.domain;

/**
 * This enumeration class represents all Genres
 */
public enum Genre {
	DRAMA("Drama"), COMEDY("Comedy"), ACTION("Action");

	private final String genre;

	Genre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return this.genre;
	}
}
