package edu.pnu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NcsDTO {
	private Long ncsid;
	private String large;
	private String mid;
	private String small;
	private String ssmall;
}
