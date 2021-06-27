package com.subway.entity.vo;

public class StS {
    private String expiration;
    private String access_Key_Id;
    private String access_Key_Secret;
    private String security_Token;
    private String requestId;

    public StS(String expiration, String access_Key_Id, String access_Key_Secret, String security_Token, String requestId) {
        this.expiration = expiration;
        this.access_Key_Id = access_Key_Id;
        this.access_Key_Secret = access_Key_Secret;
        this.security_Token = security_Token;
        this.requestId = requestId;
    }


    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getAccess_Key_Id() {
        return access_Key_Id;
    }

    public void setAccess_Key_Id(String access_Key_Id) {
        this.access_Key_Id = access_Key_Id;
    }

    public String getAccess_Key_Secret() {
        return access_Key_Secret;
    }

    public void setAccess_Key_Secret(String access_Key_Secret) {
        this.access_Key_Secret = access_Key_Secret;
    }

    public String getSecurity_Token() {
        return security_Token;
    }

    public void setSecurity_Token(String security_Token) {
        this.security_Token = security_Token;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        requestId = requestId;
    }

    @Override
    public String toString() {
        return "StS{" +
                "expiration='" + expiration + '\'' +
                ", access_Key_Id='" + access_Key_Id + '\'' +
                ", access_Key_Secret='" + access_Key_Secret + '\'' +
                ", security_Token='" + security_Token + '\'' +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
