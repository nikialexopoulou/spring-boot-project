package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Actor;

public interface ActorService extends BaseService<Actor, Long> {
	Actor findByName(String name);
}
