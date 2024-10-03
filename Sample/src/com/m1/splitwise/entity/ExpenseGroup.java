package com.machinecoding.splitwise.entity;

import java.util.*;

public class ExpenseGroup {

    private String expenseGroupId;
    private Set<User> groupMembers;
    private Map<String, UserShare> userContribution;

    ExpenseGroup() {
        this.expenseGroupId = UUID.randomUUID().toString();
        this.groupMembers = new HashSet<>();
        this.userContribution = new HashMap<>();
    }

    public String getExpenseGroupId() {
        return expenseGroupId;
    }

    public void setExpenseGroupId(String expenseGroupId) {
        this.expenseGroupId = expenseGroupId;
    }

    public Set<User> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(Set<User> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Map<String, UserShare> getUserContribution() {
        return userContribution;
    }

    public void setUserContribution(Map<String, UserShare> userContribution) {
        this.userContribution = userContribution;
    }
}
