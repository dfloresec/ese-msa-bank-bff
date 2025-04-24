package ec.com.bank.service.dto.charactes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GaleryDto {

	private Integer id;

	private String name;

	private String gender;

	private String ki;

	private String image;
	
	private boolean favorite = false;

}
