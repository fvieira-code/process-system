package com.justica.processo.repository;

import com.justica.processo.model.AbstractEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T, I> extends PagingAndSortingRepository<T, I> {
}
