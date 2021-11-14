package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.domain.Actor;
import gr.codelearn.spring.showcase.app.service.ActorService;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents a controller responsible of accepting requests targeting {@link Actor}.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController extends AbstractController<Actor> {
	private final ActorService actorService;

	@Override
	public BaseService<Actor, Long> getBaseService() {
		return actorService;
	}

	@GetMapping(params = {"name"})
	public ResponseEntity<ApiResponse<Actor>> findByName(@RequestParam String name) {
		return ResponseEntity.ok(ApiResponse.<Actor>builder().data(actorService.findByName(name)).build());
	}
}
