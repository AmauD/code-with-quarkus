package org.acme.model;

import java.util.Date;

public class ISSResponse {
    private boolean isExposed;
    private Date lastExposedDate;

    public boolean isExposed() {
        return isExposed;
    }

    public void setExposed(boolean exposed) {
        isExposed = exposed;
    }

    public Date getLastExposedDate() {
        return lastExposedDate;
    }

    public void setLastExposedDate(Date lastExposedDate) {
        this.lastExposedDate = lastExposedDate;
    }
}