package com.ssg.people92.jpa_postgresql.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Member {

    private String mbrId; //회원ID

    private String name; //회원명
}
