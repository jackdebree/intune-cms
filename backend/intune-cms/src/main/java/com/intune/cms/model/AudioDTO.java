package com.intune.cms.model;

public record AudioDTO (
    Long id,
    String fileName,
    String path,
    String url,
    int bitRate,
    int sampleRate,
    int duration
){}
