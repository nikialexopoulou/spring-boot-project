package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.domain.*;
import gr.codelearn.spring.showcase.app.service.ActorService;
import gr.codelearn.spring.showcase.app.service.ActorShowService;
import gr.codelearn.spring.showcase.app.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class GenerateContentRunner extends AbstractLogComponent implements CommandLineRunner {
	private final ActorService actorService;
	private final ShowService showService;
	private final ActorShowService actorShowService;

	@Override
	public void run(String... args) {
		generateActors();
		logger.info("Runner finished");
	}

	private void generateActors() {
		//@formatter:off
		Actor actor = actorService.create(Actor.builder().name("Jennifer Aniston").build());
		Actor actor2 = actorService.create(Actor.builder().name("Courteney Cox").build());

		Show show = showService.create(Show.builder().actor(actor).name(
				"Friends").desc("TV most viewed sitcom").showType(ShowType.SERIES).genre(Genre.COMEDY).airedAt(1).build());
		Show show2 = showService.create(Show.builder().actor(actor).name(
				"We're the Millers").desc("").showType(ShowType.MOVIE).genre(Genre.COMEDY).airedAt(1).build());
		Show show3 = showService.create(Show.builder().actor(actor).name(
				"The Bounty Hunter").desc("").showType(ShowType.MOVIE).genre(Genre.ACTION).airedAt(1).build());

		Show show4 = showService.create(Show.builder().actor(actor2).name(
				"Friends").desc("TV most viewed sitcom").showType(ShowType.SERIES).genre(Genre.COMEDY).airedAt(1).build());

		actorShowService.create(ActorShow.builder().actor(actor).show(show).asId(1).build());
		actorShowService.create(ActorShow.builder().actor(actor).show(show2).asId(2).build());
		actorShowService.create(ActorShow.builder().actor(actor).show(show3).asId(3).build());
		actorShowService.create(ActorShow.builder().actor(actor2).show(show4).asId(4).build());
	}

}
