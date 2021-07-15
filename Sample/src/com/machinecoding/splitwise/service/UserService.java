package com.machinecoding.splitwise.service;

import com.machinecoding.splitwise.entity.*;
import com.machinecoding.splitwise.repository.ExpenseRepository;
import com.machinecoding.splitwise.repository.UserRepository;

public class UserService {

    public User createUser(String emailId, String name, String phoneNo) {
        if (UserRepository.userMap.containsKey(emailId)) {
            return UserRepository.userMap.get(emailId);
        }
        User newUser = new User(emailId, name, phoneNo);
        UserRepository.userMap.put(emailId, newUser);
        return newUser;
    }

    public void contributeToExpense(String expenseId, String emailId, Contribution contribution) {
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        ExpenseGroup expenseGroup = expense.getExpenseGroup();
        if (expense.getExpenseStatus() == ExpenseStatus.CREATED || expense.getExpenseStatus() == ExpenseStatus.SETTLED) {
            // throw custom error
        }
        UserShare userShare = expenseGroup.getUserContribution().get(emailId);

    }
}
