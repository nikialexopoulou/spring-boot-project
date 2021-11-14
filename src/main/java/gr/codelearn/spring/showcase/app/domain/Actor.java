package gr.codelearn.spring.showcase.app.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class represents an Actor or Actress of a Movie or Series
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="ACTOR")
@SequenceGenerator(name = "idGenerator", sequenceName = "ACTOR_SEQ", initialValue = 1, allocationSize = 1)
public class Actor extends BaseEntity {
	@NotNull(message = "Name of the Actor cannot be null")
	@Column(length = 50, unique = true)
	private String name;

//	@ToString.Exclude
//	@EqualsAndHashCode.Exclude
//	@ManyToMany(fetch = FetchType.LAZY)
//	@Column(name = "actor_id", nullable = true)
//	@JoinTable(
//			name = "SHOWSAPPEARED",
//			joinColumns = @JoinColumn(name = "actor_id"),
//			inverseJoinColumns = @JoinColumn (name = "show_id")
//	)
//	@JsonIgnore
//	private List<Show> showsAppeared;
}
