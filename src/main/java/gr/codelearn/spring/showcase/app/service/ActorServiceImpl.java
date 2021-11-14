package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Actor;
import gr.codelearn.spring.showcase.app.repository.ActorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl extends AbstractService<Actor> implements ActorService {
	private final ActorRepository actorRepository;

	@Override
	public Actor findByName(String name) {
		return actorRepository.findByName(name);
	}

	@Override
	public JpaRepository<Actor, Long> getRepository() {
		return actorRepository;
	}

	@Override
	public Actor create(Actor actor) {
		Actor actorExists = actorRepository.findByName(actor.getName());

		if (actorExists == null) {
			return actorRepository.save(actor);
		}

		return actorExists;
	}
}
