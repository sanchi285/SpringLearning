package com.sanchi285.organizationsservice.mapper;

import com.sanchi285.organizationsservice.dto.OrganizationDto;
import com.sanchi285.organizationsservice.entity.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {
    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setId(organization.getId());
        organizationDto.setOrganizationName(organization.getOrganizationName());
        organizationDto.setOrganizationDescription(organization.getGetOrganizationDescription());
        organizationDto.setOrganizationCode(organization.getOrganizationCode());
        organizationDto.setCreateDate(organization.getCreateDate());
        return organizationDto;
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization();
        organization.setId(organizationDto.getId());
        organization.setOrganizationName(organizationDto.getOrganizationName());
        organization.setGetOrganizationDescription(organizationDto.getOrganizationDescription());
        organization.setOrganizationCode(organizationDto.getOrganizationCode());
        organization.setCreateDate(organizationDto.getCreateDate());
        return organization;
    }
}
