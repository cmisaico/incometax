package com.incometax.models.dto;

public class IncometaxDTO {

    private String typeTax;

    private float amount;

    private float firstDiscount;

    private float secondDiscount;

    private float thirdDiscount;

    private float fourthDiscount;

    private float fifthDiscount;

    public IncometaxDTO() {
    }

    private IncometaxDTO(Builder builder) {
        this.typeTax = builder.typeTax;
        this.amount = builder.amount;
        this.firstDiscount = builder.firstDiscount;
        this.secondDiscount = builder.secondDiscount;
        this.thirdDiscount = builder.thirdDiscount;
        this.fourthDiscount = builder.fourthDiscount;
        this.fifthDiscount = builder.fifthDiscount;
    }

    public String getTypeTax() {
        return typeTax;
    }

    public void setTypeTax(String typeTax) {
        this.typeTax = typeTax;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getFirstDiscount() {
        return firstDiscount;
    }

    public void setFirstDiscount(float firstDiscount) {
        this.firstDiscount = firstDiscount;
    }

    public float getSecondDiscount() {
        return secondDiscount;
    }

    public void setSecondDiscount(float secondDiscount) {
        this.secondDiscount = secondDiscount;
    }

    public float getThirdDiscount() {
        return thirdDiscount;
    }

    public void setThirdDiscount(float thirdDiscount) {
        this.thirdDiscount = thirdDiscount;
    }

    public float getFourthDiscount() {
        return fourthDiscount;
    }

    public void setFourthDiscount(float fourthDiscount) {
        this.fourthDiscount = fourthDiscount;
    }

    public float getFifthDiscount() {
        return fifthDiscount;
    }

    public void setFifthDiscount(float fifthDiscount) {
        this.fifthDiscount = fifthDiscount;
    }

    public static class Builder {
        private String typeTax;
        private float amount;
        private float firstDiscount;
        private float secondDiscount;
        private float thirdDiscount;
        private float fourthDiscount;
        private float fifthDiscount;

        public Builder typeTax(String typeTax) {
            this.typeTax = typeTax;
            return this;
        }

        public Builder amount(float amount) {
            this.amount = amount;
            return this;
        }

        public Builder firstDiscount(float firstDiscount) {
            this.firstDiscount = firstDiscount;
            return this;
        }

        public Builder secondDiscount(float secondDiscount) {
            this.secondDiscount = secondDiscount;
            return this;
        }

        public Builder thirdDiscount(float thirdDiscount) {
            this.thirdDiscount = thirdDiscount;
            return this;
        }

        public Builder fourthDiscount(float fourthDiscount) {
            this.fourthDiscount = fourthDiscount;
            return this;
        }

        public Builder fifthDiscount(float fifthDiscount) {
            this.fifthDiscount = fifthDiscount;
            return this;
        }

        public IncometaxDTO build() {
            return new IncometaxDTO(this);
        }
    }

}
