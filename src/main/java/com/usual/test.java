package com.usual;

public class test {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8)
                .calories(100).sodium(35).carbohydrate(27).builder();
//        NutritionFacts facts1 = new NutritionFacts(new NutritionFacts.Builder(22,22)
//                .calories(100).sodium(35).carbohydrate(27));
    }
}
