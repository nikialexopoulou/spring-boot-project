package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.ActorShow;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorShowRepository extends JpaRepository<ActorShow, Long> {
	ActorShow findByAsId(int asId);

	@Query("select new gr.codelearn.spring.showcase.app.transfer.KeyValue(s.actor.name, count(s.id)) from " +
			"ActorShow s" +
			" group by s.actor.id")
	List<KeyValue<String, Integer>> findShowsPerActor();

}
