package edu.pnu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//edu_info table 만들기
@Entity
@Table(name="edu_info1")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Edu_info {
	@Id
	@Column(name="TRAINST_CST_ID")
	private String ID;
	private String SCHOOL_NAME;
	private String ADDRESS_info;
	private String SCHOOL_EMAIL;
	private String SCHOOL_CON;
}
