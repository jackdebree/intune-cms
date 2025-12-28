package com.intune.cms.model;

import java.time.Instant;
import java.util.List;

import com.intune.cms.shared.ReleaseStatus;
import com.intune.cms.shared.ReleaseType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;   

@Entity
@Table(name = "release")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Instant creationDate;
    private ReleaseType releaseType;
    private ReleaseStatus releaseStatus;

    @OneToMany(mappedBy = "project")
    private Project project;

    @OneToMany(mappedBy = "release")
    private List<Track> tracks;

}
