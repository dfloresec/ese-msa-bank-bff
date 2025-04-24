package ec.com.bank.service.dto.charactes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

	private String name;
	private String gender;
	private int age;

	private String identification;
	private String address;
	private String phone;

}
