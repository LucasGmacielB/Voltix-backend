package com.voltix.backend.service;

import com.voltix.backend.dto.auth.CategoryDTO;
import com.voltix.backend.model.Category;
import com.voltix.backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService{

    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> findAll(){
        return categoryRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public CategoryDTO findById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        return toDTO(category);
    }

    public CategoryDTO create(CategoryDTO categoryDTO){
        if (categoryRepository.existsByName(categoryDTO.getName())){
            throw new RuntimeException("Já existe uma categoria com esse nome");
        }

        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        Category savedCategory = categoryRepository.save(category);

        return toDTO(savedCategory);
    }

    public CategoryDTO update(Long id, CategoryDTO categoryDTO){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        Category updatedCategory = categoryRepository.save(category);

        return toDTO(updatedCategory);
    }

    public void delete(Long id){
        if (!categoryRepository.existsById(id)){
            throw new RuntimeException("Categoria não encontrada");
        }

        categoryRepository.deleteById(id);
    }

    private CategoryDTO toDTO(Category category){
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}