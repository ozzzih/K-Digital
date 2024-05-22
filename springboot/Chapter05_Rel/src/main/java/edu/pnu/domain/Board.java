package edu.pnu.domain;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	public void update(Board board) {
		if (board.getTitle()!=null) title=board.getTitle();
		if (board.getWriter()!=null) writer=board.getWriter();
		if (board.getContent()!=null) content=board.getContent();
	}
	@ManyToOne //default: eager
	@JoinColumn(name="MEMBER_ID") //이거 안하면 클래스명_ID필드명으로 외래키 생성
	private Member member;	
}
