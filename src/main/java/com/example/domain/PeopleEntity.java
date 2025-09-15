package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "People")
public class PeopleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID")
    private Integer personID;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "PreferredName")
    private String preferredName;
    @Column(name = "SearchName")
    private String searchName;
    @Column(name = "IsPermittedToLogon")
    private Boolean isPermittedToLogon;
    @Column(name = "LogonName")
    private String logonName;
    @Column(name = "IsExternalLogonProvider")
    private Boolean isExternalLogonProvider;
    @Column(name = "HashedPassword")
    private byte[] hashedPassword;
    @Column(name = "IsSystemUser")
    private Boolean isSystemUser;
    @Column(name = "IsEmployee")
    private Boolean isEmployee;
    @Column(name = "IsSalesperson")
    private Boolean isSalesperson;
    @Column(name = "UserPreferences")
    private String userPreferences;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "FaxNumber")
    private String faxNumber;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Column(name = "Photo")
    private byte[] photo;
    @Column(name = "CustomFields")
    private String customFields;
    @Column(name = "OtherLanguages")
    private String otherLanguages;
    @Column(name = "LastEditedBy")
    private Integer lastEditedBy;
    @Column(name = "ValidFrom")
    private LocalDateTime validFrom;
    @Column(name = "ValidTo")
    private LocalDateTime validTo;

    public PeopleEntity() {
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public Boolean getPermittedToLogon() {
        return isPermittedToLogon;
    }

    public void setPermittedToLogon(Boolean permittedToLogon) {
        isPermittedToLogon = permittedToLogon;
    }

    public String getLogonName() {
        return logonName;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    public Boolean getExternalLogonProvider() {
        return isExternalLogonProvider;
    }

    public void setExternalLogonProvider(Boolean externalLogonProvider) {
        isExternalLogonProvider = externalLogonProvider;
    }

    public byte[] getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(byte[] hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Boolean getSystemUser() {
        return isSystemUser;
    }

    public void setSystemUser(Boolean systemUser) {
        isSystemUser = systemUser;
    }

    public Boolean getEmployee() {
        return isEmployee;
    }

    public void setEmployee(Boolean employee) {
        isEmployee = employee;
    }

    public Boolean getSalesperson() {
        return isSalesperson;
    }

    public void setSalesperson(Boolean salesperson) {
        isSalesperson = salesperson;
    }

    public String getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(String userPreferences) {
        this.userPreferences = userPreferences;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getCustomFields() {
        return customFields;
    }

    public void setCustomFields(String customFields) {
        this.customFields = customFields;
    }

    public String getOtherLanguages() {
        return otherLanguages;
    }

    public void setOtherLanguages(String otherLanguages) {
        this.otherLanguages = otherLanguages;
    }

    public Integer getLastEditedBy() {
        return lastEditedBy;
    }

    public void setLastEditedBy(Integer lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }
}