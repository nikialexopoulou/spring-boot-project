package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("sample-runner")
@RequiredArgsConstructor
public class SampleQueryRunner extends AbstractLogComponent implements CommandLineRunner {

	@Override
	public void run(String... args) {

	}
}
