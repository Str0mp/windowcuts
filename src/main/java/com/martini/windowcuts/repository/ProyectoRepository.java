package com.martini.windowcuts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.martini.windowcuts.model.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{

}
