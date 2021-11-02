package reto3.service;

import reto3.entities.Category;
import reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
    private CategoryRepository categoryRepository;
  
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> mot = categoryRepository.findById(category.getId());
            if (mot.isPresent()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> categ = categoryRepository.findById(category.getId());
            if (!categ.isPresent()) {
                if (category.getName() != null) {
                    categ.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    categ.get().setDescription(category.getDescription());
                }

                categoryRepository.save(categ.get());
                return categ.get();
            } else {
                return category;
            }
        } else {
            return category;
        }

    }
}
