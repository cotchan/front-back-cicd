package com.frontback.backend.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/values")
@RestController
@RequiredArgsConstructor
public class ModelApiController {

    private final ModelRepository modelRepository;

    @GetMapping
    public List<Model> getModels() {
        return modelRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ModelResponse> func2(@RequestBody ModelRequest value) {
        Model savedModel = modelRepository.save(new Model(value.getValue()));
        return ResponseEntity.ok(new ModelResponse(true, savedModel.getValue()));
    }

    @Data
    static class ModelRequest {
        private String value;
    }

    @AllArgsConstructor
    @Data
    static class ModelResponse {
        private boolean success;
        private String value;
    }
}
