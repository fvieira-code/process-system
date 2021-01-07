package com.justica.processo.service;

import com.justica.processo.model.AbstractEntity;
import com.justica.processo.model.Lancamento;
import com.justica.processo.model.Pessoa;
import com.justica.processo.repository.GenericRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Log4j2
public abstract class GenericService<R extends GenericRepository<T, I>, T extends AbstractEntity, I> {
    R repository;

    public GenericService(R repository) {
        this.repository = repository;
    }

    public T processarMensagem(@Valid @NotNull(message = "genericService.objeto.notnull.message") final T entity) {
        return this.save(entity);
    }

    @Transactional
    public T save(@NotNull(message = "genericService.objeto.notnull.message") final T entity) {
        return repository.save(entity);
    }

    public Optional<T> findById(@NotNull(message = "genericService.id.notnull.message") I id) {
        return repository.findById(id);
    }

    //public List<Pessoa> findAll(Example example) {
      //  return repository.findAll(example);
    //}

    //abstract List<Pessoa> buscar(Pessoa pessoaFiltro);

    protected ModelMapper instanceModelMapper(PropertyMap propertyMap) {
        ModelMapper modelMapper = new ModelMapper();
        if (propertyMap != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.addMappings(propertyMap);
        }
        return modelMapper;
    }

}
