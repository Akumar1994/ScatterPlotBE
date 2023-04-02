package com.scatter.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scatter.demo.model.Cordinate;

@Repository
public interface CoordinatesRepository extends JpaRepository<Cordinate, Long> {

}
