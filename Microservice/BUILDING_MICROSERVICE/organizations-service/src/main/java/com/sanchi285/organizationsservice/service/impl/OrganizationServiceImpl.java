package com.sanchi285.organizationsservice.service.impl;

import com.sanchi285.organizationsservice.dto.OrganizationDto;
import com.sanchi285.organizationsservice.entity.Organization;
import com.sanchi285.organizationsservice.mapper.OrganizationMapper;
import com.sanchi285.organizationsservice.repository.OrganizationRepository;
import com.sanchi285.organizationsservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization =  organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }
    //convert dto into entity


}
