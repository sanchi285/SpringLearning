package com.ltp.gradesubmission.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "Grade",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id","course_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "score", nullable = false)
    private String score;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student student;


    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;

}
