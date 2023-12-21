package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {

	private String loginId;
	private String loginPass;
	private int point;
	private int drink;
	private int dope;

	
}
