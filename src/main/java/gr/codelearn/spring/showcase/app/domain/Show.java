package gr.codelearn.spring.showcase.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class represents a Show (Movie or Series)
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="SHOW", indexes = {@Index(columnList = "actor_id")})
@SequenceGenerator(name = "idGenerator", sequenceName = "SHOW_SEQ", initialValue = 1, allocationSize = 1)
public class Show extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Actor actor;

	@NotNull(message = "Name of the show cannot be null")
	@Column(length = 50, unique = true)
	private String name;

	@NotNull(message = "Description of the show cannot be null")
	@Column(length = 250)
	private String desc;

	@NotNull(message = "Release year must be specified")
	private Integer airedAt;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private Genre genre;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private ShowType showType;
}
