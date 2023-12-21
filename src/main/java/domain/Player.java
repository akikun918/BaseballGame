package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Player {

	private int id;
	private String name;
	private Integer teamId;
	private Team team;
	private Date birthday;
	private String position;
	private int battingAverage;
	private Integer stamina ;
	private Integer salary;
	private String feel;
	private int defense;

	
	

	
}
