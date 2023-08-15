package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Vamos definir uma projeção, ou seja, limitar os campos da tabela que serão retornados.
// Somente os campos que eu preciso.
public interface CustomerRepository extends JpaRepository<Customer, Long> { // JpaRepository<Entidade, Tipo da chave primária da entidade>

    @Query(nativeQuery = true, value = "SELECT name FROM customers WHERE UPPER(state) = UPPER(:state)")
    List<CustomerMinProjection> search1(String state);
}
