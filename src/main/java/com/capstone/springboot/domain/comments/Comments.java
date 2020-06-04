package com.capstone.springboot.domain.comments;

import com.capstone.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250, nullable=false)
    private String content;

    @Column
    private String author;

    @Column
    private Long pid;

    @Column
    private Long tag;

    @Column
    private Long report;

    @Builder
    public Comments(String content, String author, Long pid, Long tag, Long report){
        this.content = content;
        this.author = author;
        this.pid = pid;
        this.tag = tag;
        this.report = report;
    }

    public void incrementReport(){
        if(this.report == null)
            this.report = 0l;
        this.report = this.report + 1;
    }
}