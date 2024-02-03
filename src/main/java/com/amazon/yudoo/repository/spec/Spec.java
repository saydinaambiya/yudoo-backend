package com.amazon.yudoo.repository.spec;

import com.amazon.yudoo.model.Category;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class Spec<T> {
    public Specification<T> categoryId(String categoryId) {
        return ((root, query, criteriaBuilder) -> {
            Join<T, Category> categoryJoin = root.join("category");
            return criteriaBuilder.equal(categoryJoin.get("categoryId"), categoryId);
        });
    }

    public Specification<T> findBy(SearchCriteria searchCriteria) {
        switch (searchCriteria.getOperator()) {
            case LIKE:
                return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%"));
            case EQUAL:
                return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue()));
            case NOT_EQUAL:
                return ((root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get(searchCriteria.getKey()), searchCriteria.getValue()));
            default:
                throw new RuntimeException("Operator not supported");
        }
    }
}
