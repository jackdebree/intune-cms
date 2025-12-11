package com.intune.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.intune.cms.model.AudioDTO;
import com.intune.cms.service.AudioService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/audio")
public class AudioController {

    private final AudioService audioService;

    @Autowired
    public AudioController(AudioService audioService) {
        this.audioService = audioService;
    }

    @GetMapping
    public List<AudioDTO> getAllAudioFiles() {
        return audioService.getAllAudioFiles();
    }

    @GetMapping("/{id}")
    public AudioDTO getAudioFileById(@PathVariable Long id) {
        return audioService.getAudioFileById(id);
    }

    @PostMapping("upload/start")
    public void startUploadAudioFile(@RequestBody AudioDTO audioDto) {
        audioService.startUploadAudioFile(audioDto);
    }

    @PostMapping("/upload/complete")
    public void completeUploadAudioFile(@RequestBody AudioDTO audioDto) {
        audioService.startUploadAudioFile(audioDto);
    }
}