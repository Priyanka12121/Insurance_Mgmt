
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class LoginService {

    public static LoginService loginService = null;

    private LoginService() {
    }

    public static LoginService getInstance() {
        if (loginService == null) {
            return new LoginService();
        } else {
            return loginService;
        }
    }
   

    public boolean doLogin(User user) {
        boolean success = false;

        String sql = "Select * from users where emailAddress=? and password=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmailAddress());
            ps.setString(2, user.getPassword());

            //System.out.println("LoginService :: " + ps);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setEmailAddress(rs.getString("emailAddress"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setRoleId(rs.getString("roleId"));
                success = true;
            }

        } catch (SQLException ex) {
//            Logger log = Logger.getLogger(LoginService.class.getName());
//            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" "+ex.getMessage());
         
        }

        return success;
    }

    public boolean doSignUp(User user) {

        String sql = "INSERT INTO users (emailAddress,password,firstName,lastName,address) VALUES (? ,? ,? ,? ,?)";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmailAddress());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());

            ps.setString(5, user.getAddress());
          

            System.out.println("LoginService :: " + ps);

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))+" ::duplicate entry::"+ex.getMessage());
            //ex.printStackTrace();
        }

        return false;
    }

}
