package org.javaboy.vhr.model;

/**
 * @author shigm
 * @date 2020/1/6 22:06
 */
public class Meta {

    private Boolean keepALive;

    private Boolean requireAuth;

    public Boolean getKeepaLive() {
        return keepALive;
    }

    public void setKeepaLive(Boolean keepaLive) {
        this.keepALive = keepaLive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }


}
