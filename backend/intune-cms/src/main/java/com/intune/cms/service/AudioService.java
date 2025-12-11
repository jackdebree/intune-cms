package com.intune.cms.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intune.cms.model.Audio;
import com.intune.cms.model.AudioDTO;
import com.intune.cms.repository.AudioRepository;
import io.minio.*;

@Service
public class AudioService {

    private final MinioClient minioClient;
    private final AudioRepository audioRepository;

    @Autowired
    public AudioService(AudioRepository audioRepository, MinioClient minioClient) {
        this.audioRepository = audioRepository;
        this.minioClient = minioClient;
    }
    
    public List<AudioDTO> getAllAudioFiles(){
        return audioRepository.findAll()
            .stream()
                .map(audio -> new AudioDTO(
                        audio.getId(),
                        audio.getFileName(),
                        audio.getPath(),
                        "/minio/test",
                        audio.getBitRate(),
                        audio.getSampleRate(),
                        audio.getDuration()
                ))
                .toList();
    }

    public void startUploadAudioFile(AudioDTO audioDto){
        
        Audio audio = new Audio();
        audio.setStatus("pending");
        audio.setFileName(audioDto.fileName());
        audio.setPath(audioDto.path());
        audio.setBitRate(audioDto.bitRate());
        audio.setDuration(audioDto.duration());
        audio.setUploadedAt(Instant.now());

        audioRepository.save(audio);
    }

    public void completeUploadAudioFile(AudioDTO audioDto){

        Audio audio = new Audio();
        audio.setStatus("complete");
        audio.setFileName(audioDto.fileName());
        audio.setPath(audioDto.path());
        audio.setBitRate(audioDto.bitRate());
        audio.setDuration(audioDto.duration());
        audio.setUploadedAt(Instant.now());

        audioRepository.save(audio);
    }

    public AudioDTO getAudioFileById(Long id) {
        return audioRepository.findById(id)
            .map(audio -> new AudioDTO(
                audio.getId(),
                audio.getFileName(),
                audio.getPath(),
                "/minio/test",
                audio.getBitRate(),
                audio.getSampleRate(),
                audio.getDuration()
            ))
            .orElseThrow(() -> new RuntimeException("Audio not found with ID " + id));
    }   

}
