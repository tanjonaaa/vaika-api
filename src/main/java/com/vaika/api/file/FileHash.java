package com.vaika.api.file;

import com.vaika.api.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
