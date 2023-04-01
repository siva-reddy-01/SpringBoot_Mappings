package com.springdata.mappings.Repository;

import com.springdata.mappings.Entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License,Long> {
}
