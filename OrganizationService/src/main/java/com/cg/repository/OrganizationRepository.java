package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Organization;



public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}