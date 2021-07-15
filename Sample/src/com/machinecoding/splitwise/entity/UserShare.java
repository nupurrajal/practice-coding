package com.machinecoding.splitwise.entity;

import java.util.ArrayList;
import java.util.List;

public class UserShare {

    private String userId;
    private double share;
    List<Contribution> contributions;

    public UserShare(String userId, double share) {
        this.userId = userId;
        this.share = share;
        contributions = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
    }
}
