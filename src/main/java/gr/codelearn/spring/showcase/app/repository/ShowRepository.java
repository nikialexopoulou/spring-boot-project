package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Genre;
import gr.codelearn.spring.showcase.app.domain.Show;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import gr.codelearn.spring.showcase.app.transfer.PurchasesPerCustomerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{
	@Query("select s from Show s join fetch s.actor where s.name = ?1")
	Show findByName(String name);

	@Query("select distinct s from Show s join fetch s.actor")
	List<Show> findAllLazy();

	@Query("select s from Show s join fetch s.actor where s.genre = ?1")
	List<Show> findShowsPerGenre(Genre genre);

}
