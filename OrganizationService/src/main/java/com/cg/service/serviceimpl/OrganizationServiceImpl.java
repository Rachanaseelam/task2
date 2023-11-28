package com.cg.service.serviceimpl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.cg.dto.OrganizationDto;
import com.cg.mapper.OrganizationMapper;
import com.cg.model.Organization;
import com.cg.repository.OrganizationRepository;
import com.cg.service.OrganizationService;



@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}