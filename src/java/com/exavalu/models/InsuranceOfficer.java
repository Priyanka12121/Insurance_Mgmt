
package com.exavalu.models;

import com.exavalu.services.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
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
public class InsuranceOfficer extends ActionSupport implements ApplicationAware, SessionAware, Serializable {
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
    public String dogetAllFNOLVerifiedByUnderwriter(){
         String result = "FAILURE";
         //sessionMap.put("UpdateMsg",null);
         //sessionMap.put("RejectMsg",null);

        ArrayList fnolList = UserService.dogetAllFNOL();
        if (fnolList.size() >= 0) {
            sessionMap.put("FnolList", fnolList);
            result = "SUCCESS";
        }

        return result;
    }
    
    public String doFinalApprove(){
        String result = "FAILURE";
        boolean success = UserService.doFinalApprove(this.fnolId);
        if(success){
            result = "SUCCESS";
            String updateMsg = "FNOLID = "+this.fnolId+" approved successfully!";
            sessionMap.put("RejectMsg",null);
            sessionMap.put("UpdateMsg",updateMsg);
            this.dogetAllFNOLVerifiedByUnderwriter();
        }
        return result;
    }
    public String doFinalReject(){
        String result = "FAILURE";
        boolean success = UserService.doFinalReject(this.fnolId);
        if(success){
            result = "SUCCESS";
            String updateMsg = "FNOLID = "+this.fnolId+" Rejected!";
            sessionMap.put("UpdateMsg",null);
            sessionMap.put("RejectMsg",updateMsg);
            this.dogetAllFNOLVerifiedByUnderwriter();
        }
        return result;
    }
    
    private String fnolId;

    public String getFnolId() {
        return fnolId;
    }

    public void setFnolId(String fnolId) {
        this.fnolId = fnolId;
    }
    
}
