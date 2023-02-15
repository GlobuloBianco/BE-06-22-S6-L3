package it.S5L5WP.BE0622WJH.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Postazione")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Postazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CodiceUnivoco")
	private int id;
	
	@Column(name="Description")
	private String desc;
	
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	
	@Column(name="MaxOccupanti")
	private int max;
	
    @ManyToOne
    private Edificio edificio;
}