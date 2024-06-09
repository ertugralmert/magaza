package com.mert.controller;

import com.mert.controller.base.BaseController;
import com.mert.dto.request.ModelSaveRequestDto;
import com.mert.dto.response.ModelResponseDto;
import com.mert.service.ModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.mert.config.RestApis.*;


import java.util.List;

@RestController
@RequestMapping(MODEL)
@RequiredArgsConstructor
public class ModelController implements BaseController<ModelSaveRequestDto, ModelResponseDto, Long> {
    private final ModelService modelService;

    @PostMapping(SAVE)
    @Override
    public ResponseEntity<ModelResponseDto> save(@Valid @RequestBody ModelSaveRequestDto dto) {
        ModelResponseDto createdModel = modelService.save(dto);
        return new ResponseEntity<>(createdModel, HttpStatus.CREATED);
    }

    @PutMapping(UPDATE)
    @Override
    public ResponseEntity<ModelResponseDto> update(@PathVariable Long id, @Valid @RequestBody ModelSaveRequestDto dto) {
        ModelResponseDto updatedModel = modelService.update(id, dto);
        return ResponseEntity.ok(updatedModel);
    }

    @GetMapping(GET_BY_ID)
    @Override
    public ResponseEntity<ModelResponseDto> findById(@PathVariable Long id) {
        ModelResponseDto model = modelService.findById(id);
        return ResponseEntity.ok(model);
    }

    @GetMapping(GET_ALL)
    @Override
    public ResponseEntity<List<ModelResponseDto>> findAll() {
        List<ModelResponseDto> models = modelService.findAll();
        return ResponseEntity.ok(models);
    }

    @DeleteMapping(DELETE)
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        modelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
