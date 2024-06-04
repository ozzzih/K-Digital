package edu.pnu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
	private String TRAINST_CST_ID;
	private String SCHOOL_NAME;
	private String ADDRESS_info;
	private String SCHOOL_EMAIL;
	private String SCHOOL_CON;
}
