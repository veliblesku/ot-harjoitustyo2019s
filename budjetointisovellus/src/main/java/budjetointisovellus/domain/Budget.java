package budjetointisovellus.domain;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package budjetointisovellus.budjetointisovellus.domain;
//
///**
// *
// * @author blesku
// */
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.Singular;
//import org.springframework.data.jpa.domain.AbstractPersistable;
//
///**
// * Budget luokka ja sen konstruktorit.
// *
// *
// */
//@Entity
//@Builder
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Budget extends AbstractPersistable<Long> {
//
////    @OneToMany
////    private Income income;
////    @OneToMany //(cascade = {CascadeType.ALL})
////    private Expenses expenses;
////    @OneToOne
////    private User user;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "budget", cascade = {CascadeType.ALL})
//    private List<Expense> expenses = new ArrayList<>();;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "budget", cascade = {CascadeType.ALL})
//    private List<Income> incomes = new ArrayList<>();;
//
////    public double getTotalIncome() {
////        return this.income.getTotalIncome();
////    }
////
////    public double getTotalExpenses() {
////        return this.expenses.getTotalExpenses();
////    }
//}
