package com.cdp.taf.api.dto;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

public class Client {

    private String tenant;

    private String name;

    private boolean global;

    private String callbacks;

    @XmlAttribute(name = "signing_keys")
    private String signingKeys;

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    public String getCallbacks() {
        return callbacks;
    }

    public void setCallbacks(String callbacks) {
        this.callbacks = callbacks;
    }

    public String getSigningKeys() {
        return signingKeys;
    }

    public void setSigningKeys(String signingKeys) {
        this.signingKeys = signingKeys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return global == client.global &&
                Objects.equals(tenant, client.tenant) &&
                Objects.equals(name, client.name) &&
                Objects.equals(callbacks, client.callbacks) &&
                Objects.equals(signingKeys, client.signingKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenant, name, global, callbacks, signingKeys);
    }

    @Override
    public String toString() {
        return "Client{" +
                "tenant='" + tenant + '\'' +
                ", name='" + name + '\'' +
                ", global=" + global +
                ", callbacks='" + callbacks + '\'' +
                ", signingKeys='" + signingKeys + '\'' +
                '}';
    }
}
