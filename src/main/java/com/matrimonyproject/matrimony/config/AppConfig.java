package com.matrimonyproject.matrimony.config;

import com.matrimonyproject.matrimony.dto.UserEnrollmentDTO;
import com.matrimonyproject.matrimony.entity.UserEnrollment;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class AppConfig {
/*
    @Bean
    public ModelMapper modelMapper() {

    ModelMapper modelMapper = new ModelMapper();
        // Global null check
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
    TypeMap<UserEnrollmentDTO, UserEnrollment> typeMap =modelMapper
            .createTypeMap(UserEnrollmentDTO.class, UserEnrollment.class);

        typeMap.addMappings(mapper->{

            // Safe AddressDTO mappings
            mapper.map(src -> src.getAddress() != null ? src.getAddress().getEmail() : null, UserEnrollment::setEmail);
            mapper.map(src -> src.getAddress() != null ? src.getAddress().getMobileNo() : null, UserEnrollment::setMobileNo);
            mapper.map(src -> src.getAddress() != null ? src.getAddress().getMobileNo2() : null, UserEnrollment::setMobileNo2);
            mapper.map(src -> src.getAddress() != null ? src.getAddress().getPhoneNo() : null, UserEnrollment::setPhoneNo);
            mapper.map(src -> src.getAddress() != null ? src.getAddress().getPhoneNo2() : null, UserEnrollment::setPhoneNo2);
            mapper.map(src -> src.getAddress() != null ? src.getAddress().getAdharId() : null, UserEnrollment::setAdharId);
            mapper.map(src -> src.getAddress() != null ? src.getAddress().getPan() : null, UserEnrollment::setPan);
            mapper.map(src -> src.getAddress() != null ? src.getAddress().getPassportNo() : null, UserEnrollment::setPassportNo);
            mapper.map(src -> src.getAddress() != null ? src.getAddress().getResidenceAddressWithCity() : null, UserEnrollment::setResidenceAddressWithCity);

            // Safe PersonalDetailsDTO mappings
            mapper.map(src -> src.getPersonalDetailsDTO() != null ? src.getPersonalDetailsDTO().getFirstName() : null, UserEnrollment::setFirstName);
            mapper.map(src -> src.getPersonalDetailsDTO() != null ? src.getPersonalDetailsDTO().getMiddleName() : null, UserEnrollment::setMiddleName);
            mapper.map(src -> src.getPersonalDetailsDTO() != null ? src.getPersonalDetailsDTO().getLastName() : null, UserEnrollment::setLastName);
            mapper.map(src -> src.getPersonalDetailsDTO() != null ? src.getPersonalDetailsDTO().getBirthDate() : null, UserEnrollment::setBirthDate);
            mapper.map(src -> src.getPersonalDetailsDTO() != null ? src.getPersonalDetailsDTO().getChild() : 0, UserEnrollment::setChild);
            mapper.map(src -> src.getPersonalDetailsDTO() != null ? src.getPersonalDetailsDTO().getHeight() : null, UserEnrollment::setHeight);
            mapper.map(src -> src.getPersonalDetailsDTO() != null ? src.getPersonalDetailsDTO().getWeight() : null, UserEnrollment::setWeight);
            mapper.map(src -> src.getPersonalDetailsDTO() != null ? src.getPersonalDetailsDTO().getIf_Yes_Please_Specify() : null, UserEnrollment::setIf_Yes_Please_Specify);
            mapper.map(src -> src.getPersonalDetailsDTO() != null && src.getPersonalDetailsDTO().getSpectacles() != null ? src.getPersonalDetailsDTO().getSpectacles() : null, UserEnrollment::setSpectacles);
            mapper.map(src -> src.getPersonalDetailsDTO() != null && src.getPersonalDetailsDTO().getLens() != null ? src.getPersonalDetailsDTO().getLens() : null, UserEnrollment::setLens);
            mapper.map(src -> src.getPersonalDetailsDTO() != null ? src.getPersonalDetailsDTO().getPersonality() : null, UserEnrollment::setPersonality);

            // Safe HeroScopeDetailsDTO
            mapper.map(src -> src.getHeroScopeDetailsDTO() != null ? src.getHeroScopeDetailsDTO().getBirth_Time() : null, UserEnrollment::setBirth_Time);
            mapper.map(src -> src.getHeroScopeDetailsDTO() != null ? src.getHeroScopeDetailsDTO().getIsAbroadBorn() : null, UserEnrollment::setIsAbroadBorn);
            mapper.map(src -> src.getHeroScopeDetailsDTO() != null && src.getHeroScopeDetailsDTO().getBornCountry() != null && !src.getHeroScopeDetailsDTO().getBornCountry().isEmpty()
                    ? src.getHeroScopeDetailsDTO().getBornCountry().get(0)
                    : null, UserEnrollment::setBornCountry);
            mapper.map(src -> src.getHeroScopeDetailsDTO() != null && src.getHeroScopeDetailsDTO().getCities() != null && !src.getHeroScopeDetailsDTO().getCities().isEmpty()
                    ? src.getHeroScopeDetailsDTO().getCities().get(0)
                    : null, UserEnrollment::setCities);
            mapper.map(src -> src.getHeroScopeDetailsDTO() != null && src.getHeroScopeDetailsDTO().getStates() != null && !src.getHeroScopeDetailsDTO().getStates().isEmpty()
                    ? src.getHeroScopeDetailsDTO().getStates().get(0)
                    : null, UserEnrollment::setStates);

            // EducationDTO (simplified)
            mapper.map(src -> src.getEducationalDetailsDTO() != null ? src.getEducationalDetailsDTO().getEducationName() : null, UserEnrollment::setEducationName);
            mapper.map(src -> src.getEducationalDetailsDTO() != null ? src.getEducationalDetailsDTO().getOccupationDetails() : null, UserEnrollment::setOccupationDetails);
            mapper.map(src -> src.getEducationalDetailsDTO() != null ? src.getEducationalDetailsDTO().getIncomePerMonth() : 0, UserEnrollment::setIncomePerMonth);

            // ExpectationDTO (simplified)
            mapper.map(src -> src.getExpectationDTO() != null ? src.getExpectationDTO().getExpectedCast() : null, UserEnrollment::setExpectedCast);
            mapper.map(src -> src.getExpectationDTO() != null ? src.getExpectationDTO().getIncomePerAnnum() : 0L, UserEnrollment::setIncomePerAnnum);
            mapper.map(src -> src.getExpectationDTO() != null && src.getExpectationDTO().isDivorcee(), UserEnrollment::setDivorcee);

            // PhotoDTO
            mapper.map(src -> src.getPhotosDTO() != null ? src.getPhotosDTO().getProfileId() : null, UserEnrollment::setProfileId);
            mapper.map(src -> src.getPhotosDTO() != null ? src.getPhotosDTO().getPhoto() : null, UserEnrollment::setPhoto);
            // Handle `MultipartFile` to string or byte[] as needed
        });
        return  modelMapper;
    }
*/

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
