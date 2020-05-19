package com.urise.webapp.model;

/**
 * com.urise.webapp.model.Resume class
 */
public class Resume {
    public String uuid;

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume() {

    }

    public String getUuid(){
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
