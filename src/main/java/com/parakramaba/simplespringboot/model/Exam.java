package com.parakramaba.simplespringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
//@Data
@Table(name = "exams")
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subjectId", referencedColumnName = "id")
    private Subject subject;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Time startTime;

    @Column(nullable = false)
    private Time endTime;

    @OneToMany(mappedBy = "exam")
    @JsonIgnore
    private Set<StudentExam> studentExams;

    public Exam() {
    }

    public Exam(long id, Subject subject, Date date, Time startTime, Time endTime, Set<StudentExam> studentExams) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studentExams = studentExams;
    }

    public long getId() {
        return id;
    }

    public Subject getSubject() throws CloneNotSupportedException {
        return (Subject) subject.clone();
    }

    public Date getDate() {
        return date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Set<StudentExam> getStudentExams() {
        return studentExams;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSubject(Subject subject) throws CloneNotSupportedException {
        this.subject = (Subject) subject.clone();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setStudentExams(Set<StudentExam> studentExams) {
        this.studentExams = studentExams;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", subject=" + subject +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", studentExams=" + studentExams +
                '}';
    }
}
