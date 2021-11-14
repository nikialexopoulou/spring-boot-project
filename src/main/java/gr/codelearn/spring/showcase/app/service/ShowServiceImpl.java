package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Genre;
import gr.codelearn.spring.showcase.app.domain.Show;
import gr.codelearn.spring.showcase.app.repository.ShowRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl extends AbstractService<Show> implements ShowService {
	private final ShowRepository showRepository;

	@Override
	public Show findByName(String name) {
		return showRepository.findByName(name);
	}

	@Override
	public JpaRepository<Show, Long> getRepository() {
		return showRepository;
	}

	@Override
	public Show create(Show show) {
		Show showExists = showRepository.findByName(show.getName());

		if (showExists == null) {
			return showRepository.save(show);
		}

		return showExists;
	}

	@Override
	public List<Show> findAllLazy() {
		return showRepository.findAllLazy();
	}

	@Override
	public List<Show> findShowsPerGenre(Genre genre) {
		return showRepository.findShowsPerGenre(genre);
	}


//	@Override
//	public void addItem(Show show, Actor actor) {
//		if (checkNullability(show, actor)) {
//			return;
//		}
//
//		boolean found = false;
//
//		// If product is already contained in the order, don't add it again, just increase the quantity accordingly
//		for (ActorShow as : show.getActorShow()) {
//			if (as.getActor().equals(actor)) {
//				found = true;
//				break;
//			}
//		}
//
//		if (!found) {
//			show.getActorShow().add(newActorShow(show, actor));
//		}
//	}
//
//	private ActorShow newActorShow(Show show, Actor actor) {
//		return ActorShow.builder().actor(actor).show(show).build();
//	}
//
//	private boolean checkNullability(Show show, Actor actor) {
//		if (show == null) {
//			logger.warn("show is null.");
//			return true;
//		}
//		if (actor == null) {
//			logger.warn("actor is null.");
//			return true;
//		}
//		return false;
//	}

}
