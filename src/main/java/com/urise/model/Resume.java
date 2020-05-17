package com.urise.model;

/**
 * com.urise.webapp.model.Resume class
 */
public class Resume {
    private String uuid;

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid(){
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
