package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.ActorShow;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;

import java.util.List;

public interface ActorShowService extends BaseService<ActorShow, Long> {
	ActorShow findByAsId(int as_id);

	List<KeyValue<String, Integer>> findShowsPerActor();

}
