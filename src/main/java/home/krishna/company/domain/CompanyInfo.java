package home.krishna.company.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CompanyInfo {
	
	private String companyId;
	private String companyName;
	private Employee employee;

}
