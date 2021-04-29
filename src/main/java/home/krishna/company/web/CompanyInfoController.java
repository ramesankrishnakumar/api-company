package home.krishna.company.web;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import home.krishna.company.domain.CompanyInfo;
import home.krishna.company.domain.Employee;

@RestController
@RequestMapping("/v1/company/{companyId}/info")
public class CompanyInfoController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public ResponseEntity<CompanyInfo> getCompanyInfo(@PathVariable String companyId) throws URISyntaxException {
		CompanyInfo info = new CompanyInfo();
		info.setCompanyId(companyId);
		info.setCompanyName("TriNet PEO");
		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("companyId", companyId);
		java.net.URI uri = UriComponentsBuilder.fromUriString("http://api-employee/v1/company/{companyId}/employee-detail")
								.buildAndExpand(companyId)
								.toUri();
		Employee employee = restTemplate.getForEntity(uri, Employee.class).getBody();
		info.setEmployee(employee);
		return ResponseEntity.ok(info);
	}

}
