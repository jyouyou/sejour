package fr.minint.sief.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.minint.sief.domain.enumeration.ActivityType;
import fr.minint.sief.domain.enumeration.MaritalStatus;
import fr.minint.sief.domain.enumeration.PersonType;
import fr.minint.sief.domain.enumeration.SexType;
import fr.minint.sief.domain.util.CustomDateTimeDeserializer;
import fr.minint.sief.domain.util.CustomDateTimeSerializer;

/**
 * A Identity.
 */
public class Identity implements Serializable {
	
	@Field("foreigner_number")
	private String foreignerNumber;

	@NotNull        
    @Field("last_name")
    private String lastName;
    
    @Field("used_last_name")
    private String usedLastName;
    
    @Field("first_name")
    private String firstName;

    @NotNull        
    @Field("sex")
    private SexType sex;

    @NotNull        
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Field("birth_date")
    private DateTime birthDate;

    @NotNull        
    @Field("birth_city")
    private String birthCity;

    @NotNull        
    @Field("birth_country")
    private String birthCountry;

    @NotNull        
    @Field("nationality")
    private String nationality;

    @NotNull        
    @Field("passport_number")
    private String passportNumber;

    @NotNull        
    @Field("residency_country")
    private String residencyCountry;

    @NotNull        
    @Field("marital_status")
    private MaritalStatus maritalStatus;

    @Field("childs_number")
    private int childsNumber;

    @Field("brothers_number")
    private int brothersNumber;

    @NotNull        
    @Field("activity")
    private ActivityType activity;
    
    @Field("documents")
    private List<Document> documents = new ArrayList<>();
    
    @Field("family")
    private Map<PersonType, List<Person>> family = new HashMap<>();
    
    @Field("changed")
    private boolean changed = false;
    
    @Field("admissible")
    private Boolean admissible;
    
    @Field("valid")
    private boolean valid = false;

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Field("validate_on")
    private DateTime validateOn;
    
    @Field("family_admissible")
    private Boolean familyAdmissible;

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Field("family_validate_on")
    private DateTime familyValidateOn;

    public String getForeignerNumber() {
		return foreignerNumber;
	}

	public void setForeignerNumber(String foreignerNumber) {
		this.foreignerNumber = foreignerNumber;
	}

	public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getUsedLastName() {
        return usedLastName;
    }

    public void setUsedLastName(String usedLastName) {
        this.usedLastName = usedLastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getResidencyCountry() {
		return residencyCountry;
	}

	public void setResidencyCountry(String residencyCountry) {
		this.residencyCountry = residencyCountry;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public int getChildsNumber() {
		return childsNumber;
	}

	public void setChildsNumber(int childsNumber) {
		this.childsNumber = childsNumber;
	}

	public int getBrothersNumber() {
		return brothersNumber;
	}

	public void setBrothersNumber(int brothersNumber) {
		this.brothersNumber = brothersNumber;
	}

	public ActivityType getActivity() {
		return activity;
	}

	public void setActivity(ActivityType activity) {
		this.activity = activity;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Map<PersonType, List<Person>> getFamily() {
		return family;
	}

	public void setFamily(Map<PersonType, List<Person>> family) {
		this.family = family;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public Boolean isAdmissible() {
		return admissible;
	}

	public void setAdmissible(Boolean admissible) {
		this.admissible = admissible;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public DateTime getValidateOn() {
		return validateOn;
	}

	public void setValidateOn(DateTime validateOn) {
		this.validateOn = validateOn;
	}

	public Boolean isFamilyAdmissible() {
		return familyAdmissible;
	}

	public void setFamilyAdmissible(Boolean familyAdmissible) {
		this.familyAdmissible = familyAdmissible;
	}

	public DateTime getFamilyValidateOn() {
		return familyValidateOn;
	}

	public void setFamilyValidateOn(DateTime familyValidateOn) {
		this.familyValidateOn = familyValidateOn;
	}

	@Override
    public boolean equals(Object o) {
        if (equalsWithoutFamily(o) && ! Objects.equals(family, ((Identity) o).family)) return false;

        return true;
    }
	
    public boolean equalsWithoutFamily(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Identity identity = (Identity) o;

        if ( !Objects.equals(foreignerNumber, identity.foreignerNumber)
        		|| !Objects.equals(lastName, identity.lastName)
        		|| !Objects.equals(usedLastName, identity.usedLastName)
        		|| !Objects.equals(firstName, identity.firstName)
        		|| !Objects.equals(sex, identity.sex)
        		|| !Objects.equals(birthDate, identity.birthDate)
        		|| !Objects.equals(birthCity, identity.birthCity)
        		|| !Objects.equals(birthCountry, identity.birthCountry)
        		|| !Objects.equals(nationality, identity.nationality)
        		|| !Objects.equals(passportNumber, identity.passportNumber)
        		|| !Objects.equals(residencyCountry, identity.residencyCountry)
        		|| !Objects.equals(maritalStatus, identity.maritalStatus)
        		|| !Objects.equals(childsNumber, identity.childsNumber)
        		|| !Objects.equals(brothersNumber, identity.brothersNumber)
        		|| !Objects.equals(activity, identity.activity)
        		|| !Objects.equals(documents, identity.documents)) return false;

        return true;
    }
	
    public boolean equalsOnlyFamily(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Identity identity = (Identity) o;

        if ( !Objects.equals(family, identity.family)) return false;

        return true;
    }

    @Override
    public int hashCode() {
    	final int prime = 31;
    	int result = 17;
    	result = prime * result + Objects.hashCode(foreignerNumber);
    	result = prime * result + Objects.hashCode(lastName);
    	result = prime * result + Objects.hashCode(usedLastName);
    	result = prime * result + Objects.hashCode(firstName);
    	result = prime * result + Objects.hashCode(sex);
    	result = prime * result + Objects.hashCode(birthDate);
    	result = prime * result + Objects.hashCode(birthCity);
    	result = prime * result + Objects.hashCode(birthCountry);
    	result = prime * result + Objects.hashCode(nationality);
    	result = prime * result + Objects.hashCode(passportNumber);
    	result = prime * result + Objects.hashCode(residencyCountry);
    	result = prime * result + Objects.hashCode(maritalStatus);
    	result = prime * result + Objects.hashCode(childsNumber);
    	result = prime * result + Objects.hashCode(brothersNumber);
    	result = prime * result + Objects.hashCode(activity);
    	result = prime * result + Objects.hashCode(documents);
    	result = prime * result + Objects.hashCode(family);
    	return result;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "foreignerNumber='" + foreignerNumber + "'" +
                ", lastName='" + lastName + "'" +
                ", usedLastName='" + usedLastName + "'" +
                ", firstName='" + firstName + "'" +
                ", sex='" + sex + "'" +
                ", birthDate='" + birthDate + "'" +
                ", birthCity='" + birthCity + "'" +
                ", birthCountry='" + birthCountry + "'" +
                ", nationality='" + nationality + "'" +
                ", passportNumber='" + passportNumber + "'" +
                ", residencyCountry='" + residencyCountry + "'" +
                ", maritalStatus='" + maritalStatus + "'" +
                ", childsNumber='" + childsNumber + "'" +
                ", brothersNumber='" + brothersNumber + "'" +
                ", activity='" + activity + "'" +
                ", documents='" + documents + "'" +
                ", family='" + family + '\'' +
                ", changed='" + changed + '\'' +
                ", admissible='" + admissible + '\'' +
                ", valid='" + valid + '\'' +
                ", validateOn='" + validateOn + '\'' +
                ", familyValidateOn='" + familyValidateOn + '\'' +
                ", familyAdmissible='" + familyAdmissible + '\'' +
                '}';
    }
    
    public boolean hasDocumentToValidate() {
    	return documents.stream().anyMatch(doc -> doc.getValidation() == null) || hasFamilyDocumentToValidate();
    }
    
    private boolean hasFamilyDocumentToValidate() {
    	return family.keySet().stream()
    		.anyMatch(personType -> {
    			return family.get(personType).stream().anyMatch(person -> {
    				return person.getIdentity().getDocuments().stream().anyMatch(doc -> doc.getValidation() == null);
    			});
    		});
    }
    
    public void validateNewDocuments(final DateTime date) {
    	documents.stream()
    		.filter(doc -> doc.getValidation() == null)
    		.forEach(doc -> {
    			doc.setValidation(date);
    			validateOn = date;
    		});
    	
    	if(validateOn == null) {
    		validateOn = date;
    	}
    	
    	family.keySet().stream()
        	.forEach(personType -> family.get(personType).stream()
        				.forEach(person -> person.getIdentity().getDocuments().stream()
						            		.filter(doc -> doc.getValidation() == null)
						            		.forEach(doc -> {
						            			doc.setValidation(date);
						            			familyValidateOn = date;
						            		})
						)
        	);
    	
    	if(familyValidateOn == null) {
    		familyValidateOn = date;
    	}
    }
}
