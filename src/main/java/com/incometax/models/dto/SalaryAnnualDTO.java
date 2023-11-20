package com.incometax.models.dto;

public class SalaryAnnualDTO {

    private float januarySalary;
    private float februarySalary;
    private float marchSalary;
    private float aprilSalary;
    private float maySalary;
    private float juneSalary;
    private float julySalary;
    private float augustSalary;
    private float septemberSalary;
    private float octoberSalary;
    private float novemberSalary;
    private float decemberSalary;

    public float getJanuarySalary() {
        return januarySalary;
    }

    public void setJanuarySalary(float januarySalary) {
        this.januarySalary = januarySalary;
    }

    public float getFebruarySalary() {
        return februarySalary;
    }

    public void setFebruarySalary(float februarySalary) {
        this.februarySalary = februarySalary;
    }

    public float getMarchSalary() {
        return marchSalary;
    }

    public void setMarchSalary(float marchSalary) {
        this.marchSalary = marchSalary;
    }

    public float getAprilSalary() {
        return aprilSalary;
    }

    public void setAprilSalary(float aprilSalary) {
        this.aprilSalary = aprilSalary;
    }

    public float getMaySalary() {
        return maySalary;
    }

    public void setMaySalary(float maySalary) {
        this.maySalary = maySalary;
    }

    public float getJuneSalary() {
        return juneSalary;
    }

    public void setJuneSalary(float juneSalary) {
        this.juneSalary = juneSalary;
    }

    public float getJulySalary() {
        return julySalary;
    }

    public void setJulySalary(float julySalary) {
        this.julySalary = julySalary;
    }

    public float getAugustSalary() {
        return augustSalary;
    }

    public void setAugustSalary(float augustSalary) {
        this.augustSalary = augustSalary;
    }

    public float getSeptemberSalary() {
        return septemberSalary;
    }

    public void setSeptemberSalary(float septemberSalary) {
        this.septemberSalary = septemberSalary;
    }

    public float getOctoberSalary() {
        return octoberSalary;
    }

    public void setOctoberSalary(float octoberSalary) {
        this.octoberSalary = octoberSalary;
    }

    public float getNovemberSalary() {
        return novemberSalary;
    }

    public void setNovemberSalary(float novemberSalary) {
        this.novemberSalary = novemberSalary;
    }

    public float getDecemberSalary() {
        return decemberSalary;
    }

    public void setDecemberSalary(float decemberSalary) {
        this.decemberSalary = decemberSalary;
    }

    public float getAnnualSalary(){
        return januarySalary + februarySalary + marchSalary + aprilSalary + maySalary + juneSalary + julySalary + augustSalary + septemberSalary + octoberSalary + novemberSalary + decemberSalary;
    }


}
