package com.app.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConstant {
    @Value("${security.public-pattern}")
    private String publicPattern;

    @Value("${security.auth.username}")
    private String authUsername;

    @Value("${security.auth.url}")
    private String authUrl;

    @Value("${security.auth.client_id}")
    private String clientId;

    @Value("${security.auth.client_password}")
    private String clientPassword;

    @Value("${security.auth.connection_timeout}")
    private String connectionTimeout;

    @Value("${security.auth.read_timeout}")
    private String readTimeout;

    @Value("${security.auth.whitelist}")
    private String[] whitelist;

    public String getPublicPattern() {
        return publicPattern;
    }

    public void setPublicPattern(String publicPattern) {
        this.publicPattern = publicPattern;
    }

    public String getAuthUsername() {
        return authUsername;
    }

    public void setAuthUsername(String authUsername) {
        this.authUsername = authUsername;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(String connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public String getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(String readTimeout) {
        this.readTimeout = readTimeout;
    }

    public String[] getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String[] whitelist) {
        this.whitelist = whitelist;
    }

    public SecurityConstant() {
    }

    public SecurityConstant(String publicPattern, String authUsername, String authUrl, String clientId, String clientPassword, String connectionTimeout, String readTimeout, String[] whitelist) {
        this.publicPattern = publicPattern;
        this.authUsername = authUsername;
        this.authUrl = authUrl;
        this.clientId = clientId;
        this.clientPassword = clientPassword;
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.whitelist = whitelist;
    }
}
