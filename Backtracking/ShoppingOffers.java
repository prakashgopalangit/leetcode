package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(9,9);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(1,1,1));
        List<Integer> needs = Arrays.asList(2,2);

        System.out.println(" minprice ---> "+ new ShoppingOffersSolution().shoppingOffers(price, special, needs));
    }

}

class ShoppingOffersSolution {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return findOutMinPrice(price, special, needs, 0);
    }

    public int findOutMinPrice(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index){
        System.out.println(" ----------------------------- ");
        System.out.println(" needs --> "+ needs);
        int minprice = directBuy(price, needs);
        System.out.println("minprice after ----> "+ minprice);

       for(int i=index;i<special.size();i++){
           List<Integer> offer = special.get(i);
           System.out.println(" offer ---> "+ offer);
           List<Integer> tempNeeds = new ArrayList<>();
           if(isValidOffer(offer, needs)){
               System.out.println(" offer is valid ---> "+ offer);
               int calculatedPrice = 0;
               for(int j=0;j<needs.size();j++){
                   calculatedPrice = offer.get(offer.size()-1);
                   tempNeeds.add(needs.get(j) - offer.get(j));
               }
               System.out.println("calculatedPrice --->  " + calculatedPrice);
               minprice = Math.min(minprice, calculatedPrice + findOutMinPrice(price, special, tempNeeds, i));
           }
       }
       return minprice;
    }

    public boolean isValidOffer(List<Integer> offer, List<Integer> needs){
        System.out.println(" going inside ");
        for(int i=0;i<needs.size();i++)
            if(offer.get(i) > needs.get(i))
                return false;
        return true;
    }

    public int directBuy(List<Integer> price, List<Integer> needs){
        int total = 0;
        for(int i=0;i<needs.size();i++)
            total += price.get(i) * needs.get(i);
        return total;
    }


}
