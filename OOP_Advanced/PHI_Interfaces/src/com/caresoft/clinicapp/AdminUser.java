package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements PHICompliantUser, PHIAdminCompliant {
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    @Override
    public boolean assignPin(int pin) {
        //Pin must be 6 digits or more.
        if (pin > 99999) {
            setPin(pin);
            return true;
        }
        return false;
    }

    @Override
    public boolean isAuthorized(Integer confirmedAuthID) {
        // Checks the ids and returns true or false as expected
        if (getId().equals(confirmedAuthID)) {  //compares the actual value
            authIncident();
            return true;
        }
        return false;
    }

    // Getter and Setter
    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    @Override
    public void printSecurityIncidents() {
        PHIAdminCompliant.super.printSecurityIncidents();
    }

    @Override
    public boolean adminQATest(ArrayList<String> expectedIncidents) {
        return PHIAdminCompliant.super.adminQATest(expectedIncidents);
    }


}
