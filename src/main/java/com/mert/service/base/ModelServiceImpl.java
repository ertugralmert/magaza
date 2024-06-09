package com.mert.service.base;

import com.mert.dto.request.ModelSaveRequestDto;
import com.mert.dto.response.ModelResponseDto;
import com.mert.entity.Model;
import com.mert.exception.ProductManagementException;
import com.mert.mapper.ModelMapper;
import com.mert.repository.ModelRepository;
import com.mert.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mert.exception.ErrorType.CONFLICT_ERROR;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Override
    public ModelResponseDto save(ModelSaveRequestDto dto) {
        if (modelRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new ProductManagementException(CONFLICT_ERROR);
        }
        Model model = modelMapper.fromModelSaveRequestDto(dto);
        return modelMapper.toModelResponseDto(modelRepository.save(model));
    }

    @Override
    public ModelResponseDto update(Long id, ModelSaveRequestDto dto) {
        Model model = modelRepository.findById(id).orElseThrow();
        model.setName(dto.getName());
        return modelMapper.toModelResponseDto(modelRepository.save(model));
    }

    @Override
    public ModelResponseDto findById(Long id) {
        return modelMapper.toModelResponseDto(modelRepository.findById(id).orElseThrow());
    }

    @Override
    public List<ModelResponseDto> findAll() {
        return modelRepository.findAll().stream().map(modelMapper::toModelResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        modelRepository.deleteById(id);
    }
}
