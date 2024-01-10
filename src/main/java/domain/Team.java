package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {
	private Integer id;
	private String name;
	private String place;
	private Date established;
	private int victory;
	private int win;

}