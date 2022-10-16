package com.sda.remoteRo39.demoApp.mapper;

public interface Mapper<E, D>{

    D convertToDto(E entity);
    E convertToEntity(D dto);
}
