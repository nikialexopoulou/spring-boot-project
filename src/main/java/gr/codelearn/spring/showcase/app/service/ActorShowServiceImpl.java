package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.ActorShow;
import gr.codelearn.spring.showcase.app.repository.ActorShowRepository;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorShowServiceImpl extends AbstractService<ActorShow> implements ActorShowService {
	private final ActorShowRepository actorShowRepository;

	@Override
	public ActorShow findByAsId(int asId) {
		return actorShowRepository.findByAsId(asId);
	}

	@Override
	public JpaRepository<ActorShow, Long> getRepository() {
		return actorShowRepository;
	}

	@Override
	public ActorShow create(ActorShow actorShow) {
		ActorShow actorExists = actorShowRepository.findByAsId(actorShow.getAsId());

		if (actorExists == null) {
			return actorShowRepository.save(actorShow);
		}

		return actorExists;
	}

	@Override
	public List<KeyValue<String, Integer>> findShowsPerActor() {
		return actorShowRepository.findShowsPerActor();
	}

}
