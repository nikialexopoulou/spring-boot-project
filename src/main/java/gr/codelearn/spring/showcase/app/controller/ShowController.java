package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.domain.Genre;
import gr.codelearn.spring.showcase.app.domain.Show;
import gr.codelearn.spring.showcase.app.service.ActorShowService;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.ShowService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class represents a controller responsible of accepting requests targeting {@link Show}.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/shows")
public class ShowController extends AbstractController<Show> {
	private final ShowService showService;
	private final ActorShowService actorShowService;

	@Override
	public BaseService<Show, Long> getBaseService() {
		return showService;
	}

	@GetMapping(params = {"name"})
	public ResponseEntity<ApiResponse<Show>> findByName(@RequestParam String name) {
		return ResponseEntity.ok(ApiResponse.<Show>builder().data(showService.findByName(name)).build());
	}

	@Override
	@GetMapping
	public ResponseEntity<ApiResponse<List<Show>>> findAll() {
		return ResponseEntity.ok(ApiResponse.<List<Show>>builder().data(showService.findAllLazy()).build());
	}

	@GetMapping(params = {"genre"})
	public ResponseEntity<ApiResponse<List<Show>>> findShowsPerGenre(@RequestParam Genre genre) {
		return ResponseEntity.ok(ApiResponse.<List<Show>>builder().data(showService.findShowsPerGenre(genre)).build());
	}

	@GetMapping("/findShowsPerActor")
	public ResponseEntity<ApiResponse<List<KeyValue<String, Integer>>>> findShowsPerActor() {
		final List<KeyValue<String, Integer>> results = actorShowService.findShowsPerActor();
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, Integer>>>builder().data(results).build());
	}
}
