package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="member") //순환참조문제해결
@Entity
public class Board {
	@Id
	@GeneratedValue
	private Long seq;
	private String title;
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date createDate = new Date();
	
	@Column(updatable=false)
	private Long cnt = 0L;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false, updatable=false) //inner join
	private Member member;
	
	public void setMember(Member member) {
		this.member=member;
		member.getBoardList().add(this);
	}
}
