package com.springdata.mappings.Repository;

import com.springdata.mappings.Entity.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammerRepository extends JpaRepository<Programmer,Integer> {
}
