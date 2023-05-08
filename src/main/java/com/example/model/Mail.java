package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mail {
		private String address;
	    private String title;
	    private String content = "예약이 완료되었습니다.";
}
