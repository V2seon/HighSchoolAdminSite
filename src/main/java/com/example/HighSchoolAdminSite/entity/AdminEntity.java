package com.example.HighSchoolAdminSite.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Setter
@Table(name = "admin")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_pk")
    private Long apk;

    @Column(name = "a_id")
    private String aid;

    @Column(name = "a_pw")
    private String apw;

    @Column(name = "a_signupdatetime")
    private String asignupdatetime;

    @Column(name = "a_logindatetime")
    private String alogindatetime;

    @Builder
    public AdminEntity(Long a_PK, String a_ID, String a_PW, String a_SIGNUPDATETIME, String a_LOGINDATETIME) {
        apk = a_PK;
        aid = a_ID;
        apw = a_PW;
        asignupdatetime = a_SIGNUPDATETIME;
        alogindatetime = a_LOGINDATETIME;
    }
}
