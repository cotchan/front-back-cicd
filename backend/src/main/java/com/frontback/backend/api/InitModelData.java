package com.frontback.backend.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitModelData {

    private final ModelRepository modelRepository;

    @PostConstruct
    void createData() {
        modelRepository.deleteAll();
        modelRepository.save(new Model("Mike"));
        modelRepository.save(new Model("Ole"));
        modelRepository.save(new Model("Seren"));
        modelRepository.save(new Model("Jens"));
    }
}
