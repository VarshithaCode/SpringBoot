package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class labmda {
    int id;
    int price;
    String name;
    labmda(int id, int price, String name)
    {
        this.id=id;
        this.price=price;
        this.name= name;
    }

}

    class labmdaExpression
    {
        public static void main(String args[])
        {
            List<labmda> prdList= new ArrayList<labmda>();
            LinkedHashMap<String,Integer> prdMap = new LinkedHashMap<String,Integer>();

            labmda l1 = new labmda(7,100, "procter");
            labmda l2 = new labmda(8,102, "unilier");
            labmda l3 = new labmda(9,102, "nielsen");
            labmda l4 = new labmda(10,102, "power");

            prdList.add(l1);
            prdList.add(l2);
            prdList.add(l3);
            prdList.add(l4);

            prdMap.put("",5);
            prdMap.put("",6);

            prdMap.values().forEach(p->{
                System.out.println("sorted product based on name.." +p);
            });


            for(String prd : prdMap.keySet())
            {
                System.out.println("sorted product based on name.." +prd);

            }

            Collections.sort(prdList,(p1,p2)-> p1.name.compareTo(p2.name));

            prdList.stream().forEach(p->{
                System.out.println("sorted product based on name.." + p.name + p.price);
            });

            prdList.stream().filter(labmdaExpression::test).forEach(p->
                System.out.println("filtered  product based on value.." + p.name + p.price));
        }

        private static boolean test(labmda p) {
            if (p.price == 102 && p.id > 6 && p.id <= 10)
                return true;
            return false;

        }
    }