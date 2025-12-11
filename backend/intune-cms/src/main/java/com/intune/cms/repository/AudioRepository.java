package com.intune.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intune.cms.model.Audio;

@Repository
public interface AudioRepository extends JpaRepository<Audio, Long> {

}


