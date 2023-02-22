package com.exavalu.models;

import com.exavalu.services.UserService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author LenovoRaja
 */
public class Underwriter extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

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

    public String dogetAllFNOL() {
        String result = "FAILURE";

        ArrayList fnolList = UserService.dogetAllFNOL();
        if (fnolList.size() > 0) {
            sessionMap.put("FnolList", fnolList);
            sessionMap.put("UpdateMsg", null);

            sessionMap.put("ShowLinkIMV", "true");
            result = "SUCCESS";
        }
        if (fnolList.size() == 0) {
            sessionMap.put("UpdateMsg", "congrats! there is no any pending verification");

        }

        return result;
    }

    public String dogetParticularFnol() {
        String result = "DETAILSOFCLAIM";
        Fnol fnol = new Fnol();
        fnol = UserService.doGetParticularFnol(this.fnolId);

        if (fnol != null) {
            sessionMap.put("Fnol", fnol);
            System.out.println("fnolid from underwrier if fnol!= null = " + this.fnolId);
            result = "DETAILSOFCLAIM";
        }

        return result;
    }

    public String dofetchDMVApi() throws Exception {
        String result = "DMVDETAILS";
        String url = "https://mocki.io/v1/bbbf234b-9e42-4327-9ef5-5c89f79915ea";

        HttpRequest postRequest = HttpRequest.newBuilder().uri(new URI(url)).build();

        //creating client object to send request
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        //to get body of response
        System.out.println(postResponse.body());
        Gson gson = new Gson();
        DMV dmv = new DMV();
        dmv = gson.fromJson(postResponse.body(), DMV.class);
        sessionMap.put("DMV", dmv);
        return result;
    }

    public String dofetchInsuranceMasterApi() throws Exception {
        String result = "INSURANCEDETAILS";
        String url = "https://mocki.io/v1/f9b5e892-0a09-454b-8a5b-46291ec56801";

        HttpRequest postRequest = HttpRequest.newBuilder().uri(new URI(url)).build();

        //creating client object to send request
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        //to get body of response
        System.out.println(postResponse.body());
        Gson gson = new Gson();
        InsuranceMaster insuranceMaster = new InsuranceMaster();
        insuranceMaster = gson.fromJson(postResponse.body(), InsuranceMaster.class);
        sessionMap.put("IMV", insuranceMaster);
        return result;
    }

    public String doVerifiedByUnderwriter() {
        String result = "FAILURE";
        boolean verification = UserService.doVerification(this.fnolId);
        if (verification) {

            //String updateMsg = "FNOL ID =" + this.fnolId + "::processed successfully";
            //sessionMap.put("UpdateMsg", updateMsg);
//            sessionMap.put("ApiResultMsg",null);
//            sessionMap.put("HideAnchorTag", null);
//            sessionMap.put("RejectionMsg", null);
            Fnol fnol = new Fnol();
            fnol = UserService.doGetParticularFnol(this.fnolId);
            sessionMap.put("Fnol", fnol);

            result = "DETAILSOFCLAIM";
        }
        //this.dogetAllFNOL();
        return result;
    }

    public String doRejectByUnderwriter() {
        String result = "FAILURE";
        boolean verification = UserService.doUnderwriterReject(this.fnolId);
        if (verification) {

            //String updateMsg = "FNOL ID =" + this.fnolId + "::processed successfully";
            //sessionMap.put("UpdateMsg", updateMsg);
//            sessionMap.put("ApiResultMsg",null);
//            sessionMap.put("HideAnchorTag", null);
//            sessionMap.put("RejectionMsg", null);
            Fnol fnol = new Fnol();
            fnol = UserService.doGetParticularFnol(this.fnolId);
            sessionMap.put("Fnol", fnol);
            result = "DETAILSOFCLAIM";
        }
        //this.dogetAllFNOL();
        return result;
    }

    private String policyNumber;
    private String vehicleNumber;
    private String fnolId;
    private String driverLicense;

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getFnolId() {
        return fnolId;
    }

    public void setFnolId(String fnolId) {
        this.fnolId = fnolId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

}
