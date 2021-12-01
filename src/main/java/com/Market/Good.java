package com.Market;


public class Good {
    private String name;
    private int quantity;
    private double price;

    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }

    public static class Builder{
        String name="";
        double price=0;
        int quantity = 0;
        public Builder(String name){
            this.name=name;
        }

        public Builder SetQuantity(int quantity){
            this.quantity=quantity;
            return this;
        }
        public Builder SetPrice(double price){
            this.price=price;
            return this;
        }

        public Good builder(){
            return new Good(this);
        }
    }
    public Good(Builder builder){
        name = builder.name;
        price = builder.price;
        quantity = builder.quantity;
    }
}
