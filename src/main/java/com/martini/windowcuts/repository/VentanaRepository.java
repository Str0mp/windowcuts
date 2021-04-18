package com.martini.windowcuts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.martini.windowcuts.model.Ventana;

@Repository
public interface VentanaRepository extends JpaRepository<Ventana, Long> {

}
