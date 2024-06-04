package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//edu_list table 만들기
@Entity
@Table(name="edu_list1")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Edu_list {
	@Id
	private String TRPR_ID;
	private String ADDRESS;
	private String COURSE_MAN;
	private String INST_CD;
	private String NCS_CD;
	private String REAL_MAN;
	private String TITLE;
	private String TITLE_LINK;
	private String SUBTITLE_LINK;
	private Date TRA_START_DATE;
	private String TRAIN_TARGET;
	@ManyToOne
	@JoinColumn(name="TRAINST_CST_ID", nullable=false)
	private Edu_info edu_info;
	private String TRNG_AREA_CD;	
}
