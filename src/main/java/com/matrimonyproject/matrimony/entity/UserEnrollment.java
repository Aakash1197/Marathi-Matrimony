package com.matrimonyproject.matrimony.entity;

import com.matrimonyproject.matrimony.customEnum.*;
import com.matrimonyproject.matrimony.dto.UserEnrollmentDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Entity
@Table(name = "UserEnrollment")
@Data
@NoArgsConstructor
public class UserEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserEnrollmentId;
    @Column( nullable = false,length = 50)
    private String FirstName;
    @Column( nullable = true,length = 50)
    private String MiddleName;
    @Column( nullable = false,length = 50)
    private String LastName;
    @Column( nullable = false,length = 100,columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column( nullable = false,length = 50)
    private String subCast;
    @Column( nullable = false,length = 30)
    private String martialStatus;
    @Column( nullable = true)
    private int child;
    @Column( nullable = false)
    private Double height;
    @Column( nullable = false)
    private Long weight;
    @Column( nullable = false,length = 3)
    private String bloodGroup;
    @Column( nullable = false,length = 15)
    private String complexion;

    private boolean physical_Disablities;
    private String if_Yes_Please_Specify;
    @Column( nullable = false,length = 15)
    private String diet;
    private Boolean Spectacles;
    private Boolean lens;
    @Column( nullable = false,length = 255)
    private  String personality;
    @Column( nullable = true,length = 15)
    private String rashi;
    @Column(nullable = true, length = 20)
    private String  nakshatra;
    @Column(nullable = true, length = 10)
    private String charan;
    @Column(nullable = true, length = 10)
    private String nadi;
    @Column(nullable = true, length = 15)
    private String gan;
    @Column(nullable = true, length = 10)
    private String mangal;
    @Column(nullable = true)
    private LocalDateTime Birth_Time;
    @Column(nullable = true, length = 20)
    private String BornState;
    @Column(nullable = true, length = 50)
    private String BornCiti;
    private Boolean isAbroadBorn;
    @Column(nullable = true, length = 50)
    private String BornCountry;
    @Column(nullable = true, length = 50)
    private String educationArea;
    @Column(nullable = true, length = 100)
    private String educationName;
    @Column(nullable = true, length = 50)
    private String occupationType;
    @Column(nullable = true, length = 255)
    private String occupationDetails;
    @Column(nullable = false)
    private double incomePerMonth;
    @Column(nullable = true, length = 50)
    private String educationCountry;
    @Column(nullable = true, length = 20)
    private String educationState;
    @Column(nullable = true, length = 50)
    private String educationCity;
    @Column(nullable = true, length = 10)
    private String pan;
    @Column(nullable = true, length = 12)
    private String aadhaarId;
    @Column(nullable = true, length = 20)
    private String  passportNo;
    @Column(nullable = true, length = 255)
    private String  ResidenceAddressWithCity;
    @Column(nullable = true, length = 100)
    private String  email;
    @Column(nullable = true, length = 15)
    private String  mobileNo;
    @Column(nullable = true, length = 15)
    private String  mobileNo2;
    @Column(nullable = true, length = 15)
    private String  phoneNo;
    @Column(nullable = true, length = 15)
    private String  phoneNo2;
    @Column(nullable = true)
    private Boolean hasFather;
    @Column(nullable = true)
    private Boolean hasMother;
    @Column(nullable = true)
    private int brothersCount;
    @Column(nullable = true)
    private int marriedBrothersCount;
    @Column(nullable = true)
    private int sistersCount;
    @Column(nullable = true)
    private int marriedSistersCount;
    @Column(nullable = true, length = 255)
    private String parentsFullName;
    @Column(nullable = true, length = 100)
    private String parentsOccupation;
    @Column(nullable = true, length = 100)
    private String parentsOccupationCity;
    @Column(nullable = true, length = 100)
    private String parentsResidentCity;
    @Column(nullable = true, length = 100)
    private String surnameOfRelatives;
    @Column(nullable = true, length = 50)
    private String family_Wealth;
    @Column(nullable = true, length = 50)
    private String maternalUncleSurname;
    @Column(nullable = true, length = 100)
    private String maternalUncleSurnamePlace;
    @Column(nullable = true, length = 100)
    private String nativeCity;
    @Column(nullable = true, length = 100)
    private String nativeTaluka;
    @Column(nullable = true)
    private Boolean AnyIntercastMarriageInCoreFamily;
    @Column(nullable = true, length = 100)
    private String IntercastMarriageInCorefamilyCast;
    @Column(nullable = true, length =   255)
    private String preferredCities;
    @Column(nullable = true)
    private Boolean hasMangal;
    @Column(nullable = true, length = 50)
    private String expectedCast;
    @Column(nullable = true)
    private Integer maxAgeDifference;
    @Column(nullable = true)
    private Double expectedHeight;
    @Column(nullable = true, length = 100)
    private String expectedEducationArea;
    @Column(nullable = true, length = 100)
    private String expectedOccupationType;
    @Column(nullable = true)
    private  Long incomePerAnnum;
    @Column(nullable = false)
    private boolean divorcee;
/*    @Column(nullable = true)
    private Long profileId;*/
    @Column(nullable = true, length = 255)
    private String imageUrl;

    @Column(name="ADD_TIME")
    private String ADD_TIME;
    @Column(name="ADD_DATE")
    private String     ADD_DATE;
    @Column(name="ADD_BY_USER")
    private String        ADD_BY_USER;
    @Column(name="MDF_TIME")
    private String MDF_TIME;
    @Column(name="MDF_DATE")
    private String     MDF_DATE;
    @Column(name="MDF_BY_USER")
    private String        MDF_BY_USER;
    @Column(name="DEL_TIME")
    private String DEL_TIME;
    @Column(name="DEL_DATE")
    private String     DEL_DATE;
    @Column(name="DEL_BY_USER")
    private String        DEL_BY_USER;
    @Column(name="DEL_FLG")
    private Integer       DEL_FLG;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userRegisterId", referencedColumnName = "userRegisterId",nullable = false)
    private UserRegister userRegister;


   public static  UserEnrollment convertDTOtoEntity(UserEnrollmentDTO userEnrollmentDTO) {
       UserEnrollment user = new UserEnrollment();
        if (userEnrollmentDTO.getAddress() != null) {
            user.setMobileNo(userEnrollmentDTO.getAddress().getMobileNo());
            user.setMobileNo2(userEnrollmentDTO.getAddress().getMobileNo2());
            user.setPhoneNo(userEnrollmentDTO.getAddress().getPhoneNo());
            user.setPhoneNo2(userEnrollmentDTO.getAddress().getPhoneNo2());
            user.setEmail(userEnrollmentDTO.getAddress().getEmail());
            user.setPan(userEnrollmentDTO.getAddress().getPan());
            user.setAadhaarId(userEnrollmentDTO.getAddress().getAadhaarId());
            user.setPassportNo(userEnrollmentDTO.getAddress().getPassportNo());
            user.setResidenceAddressWithCity(userEnrollmentDTO.getAddress().getResidenceAddressWithCity());
        }

        // --- PersonalDetailsuserEnrollmentDTO ---
        if (userEnrollmentDTO.getPersonalDetailsDTO() != null) {
            user.setFirstName(userEnrollmentDTO.getPersonalDetailsDTO().getFirstName());
            user.setMiddleName(userEnrollmentDTO.getPersonalDetailsDTO().getMiddleName());
            user.setLastName(userEnrollmentDTO.getPersonalDetailsDTO().getLastName());
            user.setBirthDate(userEnrollmentDTO.getPersonalDetailsDTO().getBirthDate());

            user.setSubCast(userEnrollmentDTO.getPersonalDetailsDTO().getSubCast().getEnglishName());
            user.setMartialStatus(userEnrollmentDTO.getPersonalDetailsDTO().getMartialStatus().getLabel());                    user.setChild(userEnrollmentDTO.getPersonalDetailsDTO().getChild());
            user.setHeight(userEnrollmentDTO.getPersonalDetailsDTO().getHeight());
            user.setWeight(userEnrollmentDTO.getPersonalDetailsDTO().getWeight());
            user.setBloodGroup(userEnrollmentDTO.getPersonalDetailsDTO().getBloodGroup().getBloodGroup());
            user.setComplexion(userEnrollmentDTO.getPersonalDetailsDTO().getComplexion().getEnglishLabel());

            user.setPhysical_Disablities(userEnrollmentDTO.getPersonalDetailsDTO().isPhysicalDisablities());
            user.setIf_Yes_Please_Specify(userEnrollmentDTO.getPersonalDetailsDTO().getIf_Yes_Please_Specify());
            user.setDiet(userEnrollmentDTO.getPersonalDetailsDTO().getDiet().getLabel());
            user.setSpectacles(userEnrollmentDTO.getPersonalDetailsDTO().getSpectacles());
            user.setLens(userEnrollmentDTO.getPersonalDetailsDTO().getLens());
            user.setPersonality(userEnrollmentDTO.getPersonalDetailsDTO().getPersonality());
        }

        // --- EducationalDetailsDTO ---
        if (userEnrollmentDTO.getEducationalDetailsDTO() != null) {
            user.setEducationArea(userEnrollmentDTO.getEducationalDetailsDTO().getEducationArea().getValue());
            user.setEducationName(userEnrollmentDTO.getEducationalDetailsDTO().getEducationName());
            user.setOccupationType(userEnrollmentDTO.getEducationalDetailsDTO().getOccupationType().getEnglishLabel());
            user.setOccupationDetails(userEnrollmentDTO.getEducationalDetailsDTO().getOccupationDetails());
            user.setIncomePerMonth(userEnrollmentDTO.getEducationalDetailsDTO().getIncomePerMonth());
        }

        // --- ExpectationDTO ---
        if (userEnrollmentDTO.getExpectationDTO() != null) {
            user.setPreferredCities(userEnrollmentDTO.getExpectationDTO().getPreferredCities().toString());
            user.setHasMangal(userEnrollmentDTO.getExpectationDTO().getHasMangal());
            String expectedCastList = userEnrollmentDTO.getExpectationDTO().getExpectedCast()
                    .stream()
                    .map(Cast::getEnglishName)
                    .collect(Collectors.joining(","));
            user.setExpectedCast(expectedCastList);
            user.setMaxAgeDifference(userEnrollmentDTO.getExpectationDTO().getMaxAgeDifference().getValue());

            user.setExpectedHeight(userEnrollmentDTO.getExpectationDTO().getExpectedHeight().toDouble());
            String educationAreaList = userEnrollmentDTO.getExpectationDTO().getExpectedEducationArea()
                    .stream()
                    .map(EducationArea::getValue)
                    .collect(Collectors.joining(","));
            user.setExpectedEducationArea(educationAreaList);
            String occupations = userEnrollmentDTO.getExpectationDTO().getExpectedOccupationType()
                    .stream()
                    .map(OccupationType::getEnglishLabel)
                    .collect(Collectors.joining(","));
            user.setExpectedOccupationType(occupations);
            user.setIncomePerAnnum(userEnrollmentDTO.getExpectationDTO().getIncomePerAnnum());
            user.setDivorcee(userEnrollmentDTO.getExpectationDTO().isDivorcee());
        }

        // --- FamilyBackgroundDTO ---
        if (userEnrollmentDTO.getFamilyBackgroundDTO() != null) {

            user.setHasFather(userEnrollmentDTO.getFamilyBackgroundDTO().getHasFather());
            user.setHasMother(userEnrollmentDTO.getFamilyBackgroundDTO().getHasMother());
            user.setBrothersCount(userEnrollmentDTO.getFamilyBackgroundDTO().getBrothersCount());
            user.setMarriedBrothersCount(userEnrollmentDTO.getFamilyBackgroundDTO().getMarriedBrothersCount());
            user.setSistersCount(userEnrollmentDTO.getFamilyBackgroundDTO().getSistersCount());
            user.setMarriedSistersCount(userEnrollmentDTO.getFamilyBackgroundDTO().getMarriedSistersCount());
            user.setParentsFullName(userEnrollmentDTO.getFamilyBackgroundDTO().getParentsFullName());
            user.setParentsOccupation(userEnrollmentDTO.getFamilyBackgroundDTO().getParentsOccupation());
            user.setParentsOccupationCity(userEnrollmentDTO.getFamilyBackgroundDTO().getParentsOccupationCity());
            user.setParentsResidentCity(userEnrollmentDTO.getFamilyBackgroundDTO().getParentsResidentCity());

            user.setSurnameOfRelatives(userEnrollmentDTO.getFamilyBackgroundDTO().getSurnameOfRelatives().toString());
            user.setFamily_Wealth(userEnrollmentDTO.getFamilyBackgroundDTO().getFamily_Wealth().toString());
            user.setMaternalUncleSurname(userEnrollmentDTO.getFamilyBackgroundDTO().getMaternalUncleSurname());
            user.setMaternalUncleSurnamePlace(userEnrollmentDTO.getFamilyBackgroundDTO().getMaternalUncleSurnamePlace());
            user.setNativeCity(userEnrollmentDTO.getFamilyBackgroundDTO().getNativeCity().toString());
            user.setNativeTaluka(userEnrollmentDTO.getFamilyBackgroundDTO().getNativeTaluka().toString());
            user.setAnyIntercastMarriageInCoreFamily(userEnrollmentDTO.getFamilyBackgroundDTO().getAnyIntercastMarriageInCoreFamily());
            user.setIntercastMarriageInCorefamilyCast(userEnrollmentDTO.getFamilyBackgroundDTO().getIntercastMarriageInCorefamilyCast());
        }

        // --- HeroScopeDetailsDTO ---
        if (userEnrollmentDTO.getHeroScopeDetailsDTO() != null) {
            String rashi = userEnrollmentDTO.getHeroScopeDetailsDTO().getRashi()
                    .stream()
                    .map(Rashi::getEnglishName)
                    .collect(Collectors.joining(","));
            user.setRashi(rashi);
            String nakshatra = userEnrollmentDTO.getHeroScopeDetailsDTO().getNakshatra()
                    .stream()
                    .map(Nakshatra::getEnglishLabel)
                    .collect(Collectors.joining(","));
            user.setNakshatra(nakshatra);

            user.setCharan(userEnrollmentDTO.getHeroScopeDetailsDTO().getCharan().toString());
            String nadi = userEnrollmentDTO.getHeroScopeDetailsDTO().getNadi()
                    .stream()
                    .map(Nadi::getEnglishLabel)
                    .collect(Collectors.joining(","));
            user.setNadi(nadi);

            String gan = userEnrollmentDTO.getHeroScopeDetailsDTO().getGan()
                    .stream()
                    .map(Gan::getEnglishName)
                    .collect(Collectors.joining(","));
            user.setGan(gan);
            String managal = userEnrollmentDTO.getHeroScopeDetailsDTO().getMangal()
                    .stream()
                    .map(Mangal::getEnglishLabel)
                    .collect(Collectors.joining(","));
            user.setMangal(managal);
            user.setBirth_Time(userEnrollmentDTO.getHeroScopeDetailsDTO().getBirth_Time());
            user.setBornState(userEnrollmentDTO.getHeroScopeDetailsDTO().getBornState().toString());
            user.setBornCiti(userEnrollmentDTO.getHeroScopeDetailsDTO().getBornCiti().toString());
            user.setIsAbroadBorn(userEnrollmentDTO.getHeroScopeDetailsDTO().getIsAbroadBorn());
            user.setBornCountry(userEnrollmentDTO.getHeroScopeDetailsDTO().getBornCountry().toString());
        }

        // --- PhotosuserEnrollmentDTO ---
        if (userEnrollmentDTO.getPhotosDTO() != null) {
            user.setImageUrl(userEnrollmentDTO.getPhotosDTO().getImageUrl());
        }
        return user;
    }


}
