package com.project.youtube.extension.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "video")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name="url")
    String url;
    @Lob
    @Column(name="subtitle")
    String subtitle;
}