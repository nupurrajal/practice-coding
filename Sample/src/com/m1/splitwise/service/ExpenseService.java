package com.machinecoding.splitwise.service;

import com.machinecoding.splitwise.entity.Expense;
import com.machinecoding.splitwise.entity.UserShare;
import com.machinecoding.splitwise.repository.ExpenseRepository;
import com.machinecoding.splitwise.repository.UserRepository;

import java.time.LocalDateTime;

public class ExpenseService {
    public Expense createExpense(String title, LocalDateTime expenseDate, double expenseAmount, String userId) {
        Expense expense = new Expense(title, expenseDate, expenseAmount, userId);
        ExpenseRepository.expenseMap.putIfAbsent(expense.getId(), expense);
        return expense;
    }

    public void addUserToExpense (String expenseId, String emailId) throws Exception {
        if (!ExpenseRepository.expenseMap.containsKey(expenseId)) {
            throw new Exception();
        }
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        expense.getExpenseGroup().getGroupMembers().add(UserRepository.userMap.get(emailId));
    }

    public void assignExpenseShare(String expenseId, String emailId, double share) {
        if (!ExpenseRepository.expenseMap.containsKey(expenseId)) {
            // throw error
        }
        Expense expense = ExpenseRepository.expenseMap.get(expenseId);
        expense.getExpenseGroup().getUserContribution().putIfAbsent(emailId, new UserShare(emailId, share));
    }
}
