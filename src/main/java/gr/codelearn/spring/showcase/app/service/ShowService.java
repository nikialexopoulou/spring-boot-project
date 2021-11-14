package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Genre;
import gr.codelearn.spring.showcase.app.domain.Show;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;

import java.util.List;

public interface ShowService extends BaseService<Show, Long> {
	Show findByName(String name);

	List<Show> findAllLazy();

	List<Show> findShowsPerGenre(Genre genre);


//	void addItem(Show show, Actor actor);
}
