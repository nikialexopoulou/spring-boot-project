package gr.codelearn.spring.showcase.app.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ACTORSHOW", indexes = {@Index(columnList = "actor_id")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACTOR_SHOW_SEQ", initialValue = 1, allocationSize = 1)
public class ActorShow extends BaseEntity{
//	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Actor actor;

//	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Show show;

	@Column(unique = true)
	private int asId;

}
