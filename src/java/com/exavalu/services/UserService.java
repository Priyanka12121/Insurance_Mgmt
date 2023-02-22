/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Fnol;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Lenovo
 */
public class UserService {

    public static boolean doLogFNOL(Fnol fnol) {

        String sql = "INSERT INTO fnol (emailAddress,policyNumber,dateOfIncident,reportingPartyFirstName,\n"
                + "reportingPartyLastName,accidentStreetAddress,accidentCity,accidentState,\n"
                + "accidentZipcode,vehicleOwnerFirstName,vehicleOwnerLastName,vehicleOwnerStreetAddress,\n"
                + "vehicleOwnerCity,vehicleOwnerState,vehicleOwnerZipcode,vehicleOwnerPhone,policeReport,\n"
                + "vehicleNumber,driverLicense,descriptionOfAccident,timeOfIncident) VALUES (? ,? ,?,? ,? ,?,? ,? ,? ,? ,?,? ,? ,? ,? ,?,? ,? ,? ,? ,?)";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, fnol.getEmailAddress());
            ps.setString(2, fnol.getPolicyNumber());
            ps.setString(3, fnol.getDateOfIncident());
            ps.setString(4, fnol.getReportingPartyFirstName());
            ps.setString(5, fnol.getReportingPartyLastName());
            ps.setString(6, fnol.getAccidentStreetAddress());
            ps.setString(7, fnol.getAccidentCity());
            ps.setString(8, fnol.getAccidentState());
            ps.setString(9, fnol.getAccidentZipcode());
            ps.setString(10, fnol.getVehicleOwnerFirstName());
            ps.setString(11, fnol.getVehicleOwnerLastName());
            ps.setString(12, fnol.getVehicleOwnerStreetAddress());
            ps.setString(13, fnol.getVehicleOwnerCity());
            ps.setString(14, fnol.getVehicleOwnerState());
            ps.setString(15, fnol.getVehicleOwnerZipcode());
            ps.setString(16, fnol.getVehicleOwnerPhone());
            ps.setString(17, fnol.getPoliceReport());
            ps.setString(18, fnol.getVehicleNumber());
            ps.setString(19, fnol.getDriverLicense());
            ps.setString(20, fnol.getDescriptionOfAccident());
            ps.setString(21, fnol.getTimeOfIncident());

            System.out.println("UserService :: " + ps);

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " ::duplicate entry::" + ex.getMessage());
            //ex.printStackTrace();
        }

        return false;
    }

    public static ArrayList dogetAllFNOL() {

        ArrayList fnolList = new ArrayList();
        String sql = "SELECT * FROM fnol f,status s where f.isVerifiedByUnderwriter=s.isVerifiedByUnderwriter and f.isVerifiedByInsuranceOfficer=s.isVerifiedByInsuranceOfficer";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fnol fnol = new Fnol();
                fnol.setFnolId(rs.getString("fnolId"));
                fnol.setEmailAddress(rs.getString("emailAddress"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setDateOfIncident(rs.getString("dateOfIncident"));
                fnol.setReportingPartyFirstName(rs.getString("reportingPartyFirstName"));
                fnol.setReportingPartyLastName(rs.getString("reportingPartyLastName"));
                fnol.setAccidentState(rs.getString("accidentState"));
                fnol.setVehicleOwnerFirstName(rs.getString("vehicleOwnerFirstName"));
                fnol.setVehicleOwnerLastName(rs.getString("vehicleOwnerLastName"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setPoliceReport(rs.getString("policeReport"));
                fnol.setDriverLicense(rs.getString("driverLicense"));
                fnol.setDescriptionOfAccident(rs.getString("descriptionOfAccident"));
                fnol.setStatus(rs.getString("status"));
                fnolList.add(fnol);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }

        return fnolList;
    }

    public static ArrayList dogetAllFNOLForCustomer(String emailAddress) {

        ArrayList fnolListForCustomer = new ArrayList();
        String sql = "select * from fnol f, status s where f.isVerifiedByUnderwriter=s.isVerifiedByUnderwriter and f.isVerifiedByInsuranceOfficer=s.isVerifiedByInsuranceOfficer and emailAddress=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailAddress);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fnol fnol = new Fnol();
                fnol.setFnolId(rs.getString("fnolId"));
                fnol.setEmailAddress(rs.getString("emailAddress"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setDateOfIncident(rs.getString("dateOfIncident"));
                fnol.setReportingPartyFirstName(rs.getString("reportingPartyFirstName"));
                fnol.setReportingPartyLastName(rs.getString("reportingPartyLastName"));
                fnol.setAccidentState(rs.getString("accidentState"));
                fnol.setVehicleOwnerFirstName(rs.getString("vehicleOwnerFirstName"));
                fnol.setVehicleOwnerLastName(rs.getString("vehicleOwnerLastName"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setPoliceReport(rs.getString("policeReport"));
                fnol.setDriverLicense(rs.getString("driverLicense"));
                fnol.setDescriptionOfAccident(rs.getString("descriptionOfAccident"));
                fnol.setStatus(rs.getString("status"));
                fnol.setReasonOfRejection(rs.getString("reasonOfRejection"));
                fnol.setIsVerifiedByInsuranceOfficer(rs.getString("isVerifiedByInsuranceOfficer"));
                fnolListForCustomer.add(fnol);
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }

        return fnolListForCustomer;
    }

    public static boolean doVerification(String fnolId) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE fnol SET isVerifiedByUnderwriter = 1 WHERE fnolId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, fnolId);

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public static String doGetFnolId(String dateOfIncident, String timeOfIncident) {
        String currentFnolId = null;
        String sql = "Select * from fnol where dateOfIncident=? and timeOfIncident=? ";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dateOfIncident);
            ps.setString(2, timeOfIncident);

            System.out.println("ps:=" + ps);
            ResultSet rs = ps.executeQuery();
            System.out.println("resultset=" + rs.getString("fnolId"));
            currentFnolId = rs.getString("fnolId");

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }
        return currentFnolId;
    }

    public static boolean doFinalApprove(String fnolId) {

        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE fnol SET isVerifiedByInsuranceOfficer = 1,reasonOfRejection='Your Application is Approved' WHERE fnolId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, fnolId);

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static boolean doUnderwriterReject(String fnolId) {

        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
           
            
            String sql = "UPDATE fnol SET isVerifiedByUnderwriter = 2,reasonOfRejection='either Insurance Master or DMV verification failed' WHERE fnolId = ?";
            
           
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, fnolId);

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static boolean doFinalReject(String fnolId) {

        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE fnol SET isVerifiedByInsuranceOfficer = 2,reasonOfRejection='contact officer for valid insurance claim' WHERE fnolId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, fnolId);

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static Fnol doGetParticularFnol(String fnolId) {
        
        Fnol fnol = new Fnol();
         try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "Select * from fnol f,status s WHERE f.isVerifiedByUnderwriter=s.isVerifiedByUnderwriter and f.isVerifiedByInsuranceOfficer=s.isVerifiedByInsuranceOfficer and fnolId=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fnolId);
            System.out.println("particular fnol:="+ps);

            ps.setString(1, fnolId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                fnol.setFnolId(rs.getString("fnolId"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setDriverLicense(rs.getString("driverLicense"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setPoliceReport(rs.getString("policeReport"));
                fnol.setStatus(rs.getString("status"));
                fnol.setReasonOfRejection(rs.getString("reasonOfRejection"));
            }
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fnol;

}
}
