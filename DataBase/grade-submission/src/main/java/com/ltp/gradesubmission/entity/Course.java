package com.ltp.gradesubmission.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Course")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NonNull
    @Column(name = "subject")
    private String subject;
    @NonNull
    @Column(name = "code")
    private String code;
    @NonNull
    @Column(name = "description")
    private String description;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
