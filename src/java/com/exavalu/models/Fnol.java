/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author LenovoRaja
 */
public class Fnol extends ActionSupport implements ApplicationAware, SessionAware, Serializable {
     public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ApplicationMap getMap() {
        return map;
    }

    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();
    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
        
    }
    
    public String doLogFNOL(){
        String result = "FAILURE";
        boolean success = UserService.doLogFNOL(this);
      
        if(success){
            String updateMsg = "FNOL logged successfull!";
            sessionMap.put("UpdateMsg", updateMsg);
            result = "SUCCESS";
        }
        
        return result;
    }
    
    
    private String emailAddress,policyNumber,dateOfIncident,timeOfIncident,reportingPartyFirstName,
            reportingPartyLastName,accidentStreetAddress,accidentCity,accidentState,
            accidentZipcode,vehicleOwnerFirstName,vehicleOwnerLastName,vehicleOwnerStreetAddress,
            vehicleOwnerCity,vehicleOwnerState,vehicleOwnerZipcode,vehicleOwnerPhone,policeReport,
            vehicleNumber,driverLicense,descriptionOfAccident;
    private String reasonOfRejection;
    private String isVerifiedByInsuranceOfficer;

    public String getIsVerifiedByInsuranceOfficer() {
        return isVerifiedByInsuranceOfficer;
    }

    public void setIsVerifiedByInsuranceOfficer(String isVerifiedByInsuranceOfficer) {
        this.isVerifiedByInsuranceOfficer = isVerifiedByInsuranceOfficer;
    }

    public String getReasonOfRejection() {
        return reasonOfRejection;
    }

    public void setReasonOfRejection(String reasonOfRejection) {
        this.reasonOfRejection = reasonOfRejection;
    }

    public String getTimeOfIncident() {
        return timeOfIncident;
    }

    public void setTimeOfIncident(String timeOfIncident) {
        this.timeOfIncident = timeOfIncident;
    }
    private String status;
    private String fnolId;

    public String getFnolId() {
        return fnolId;
    }

    public void setFnolId(String fnolId) {
        this.fnolId = fnolId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getDateOfIncident() {
        return dateOfIncident;
    }

    public void setDateOfIncident(String dateOfIncident) {
        this.dateOfIncident = dateOfIncident;
    }

    public String getReportingPartyFirstName() {
        return reportingPartyFirstName;
    }

    public void setReportingPartyFirstName(String reportingPartyFirstName) {
        this.reportingPartyFirstName = reportingPartyFirstName;
    }

    public String getReportingPartyLastName() {
        return reportingPartyLastName;
    }

    public void setReportingPartyLastName(String reportingPartyLastName) {
        this.reportingPartyLastName = reportingPartyLastName;
    }

    public String getAccidentStreetAddress() {
        return accidentStreetAddress;
    }

    public void setAccidentStreetAddress(String accidentStreetAddress) {
        this.accidentStreetAddress = accidentStreetAddress;
    }

    public String getAccidentCity() {
        return accidentCity;
    }

    public void setAccidentCity(String accidentCity) {
        this.accidentCity = accidentCity;
    }

    public String getAccidentState() {
        return accidentState;
    }

    public void setAccidentState(String accidentState) {
        this.accidentState = accidentState;
    }

    public String getAccidentZipcode() {
        return accidentZipcode;
    }

    public void setAccidentZipcode(String accidentZipcode) {
        this.accidentZipcode = accidentZipcode;
    }

    public String getVehicleOwnerFirstName() {
        return vehicleOwnerFirstName;
    }

    public void setVehicleOwnerFirstName(String vehicleOwnerFirstName) {
        this.vehicleOwnerFirstName = vehicleOwnerFirstName;
    }

    public String getVehicleOwnerLastName() {
        return vehicleOwnerLastName;
    }

    public void setVehicleOwnerLastName(String vehicleOwnerLastName) {
        this.vehicleOwnerLastName = vehicleOwnerLastName;
    }

    public String getVehicleOwnerStreetAddress() {
        return vehicleOwnerStreetAddress;
    }

    public void setVehicleOwnerStreetAddress(String vehicleOwnerStreetAddress) {
        this.vehicleOwnerStreetAddress = vehicleOwnerStreetAddress;
    }

    public String getVehicleOwnerCity() {
        return vehicleOwnerCity;
    }

    public void setVehicleOwnerCity(String vehicleOwnerCity) {
        this.vehicleOwnerCity = vehicleOwnerCity;
    }

    public String getVehicleOwnerState() {
        return vehicleOwnerState;
    }

    public void setVehicleOwnerState(String vehicleOwnerState) {
        this.vehicleOwnerState = vehicleOwnerState;
    }

    public String getVehicleOwnerZipcode() {
        return vehicleOwnerZipcode;
    }

    public void setVehicleOwnerZipcode(String vehicleOwnerZipcode) {
        this.vehicleOwnerZipcode = vehicleOwnerZipcode;
    }

    public String getVehicleOwnerPhone() {
        return vehicleOwnerPhone;
    }

    public void setVehicleOwnerPhone(String vehicleOwnerPhone) {
        this.vehicleOwnerPhone = vehicleOwnerPhone;
    }

    public String getPoliceReport() {
        return policeReport;
    }

    public void setPoliceReport(String policeReport) {
        this.policeReport = policeReport;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDescriptionOfAccident() {
        return descriptionOfAccident;
    }

    public void setDescriptionOfAccident(String descriptionOfAccident) {
        this.descriptionOfAccident = descriptionOfAccident;
    }
            
    
    
    
    
}
