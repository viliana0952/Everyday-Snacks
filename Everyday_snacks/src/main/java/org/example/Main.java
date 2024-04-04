package org.example;

import org.example.product.Product;
import org.example.client.Client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Product DanishMuffin=new Product("Danish Muffin",1,0.52,"80%", "none");
        DanishMuffin.operationsMethod();
        Product GrannysCupCake=new Product("Granny's Cup Cake",2,0.38,"120%", "30% off");
        GrannysCupCake.operationsMethod();
        Product FrenchysCroissant =new Product("Frenchy's Croissant",3,0.41,"0.90 EUR/unit", "none");
        FrenchysCroissant.operationsMethod();
        Product CrispyChips=new Product("Crispy chips",4,0.60,"1.00 EUR/unit", "Buy 2, get 3rd free");
        CrispyChips.operationsMethod();
        Map<Integer, Product> findProduct = new HashMap<>();//dictionary for faster search
        findProduct.put(1,DanishMuffin);
        findProduct.put(2,GrannysCupCake);
        findProduct.put(3,FrenchysCroissant);
        findProduct.put(4,CrispyChips);


        Client ABCDistribution=new Client("ABC Distribution",1,0,"5%","0%","2%");
        ABCDistribution.operationsMethod();
        Client DEFFoods =new Client("DEF Foods ",2,0,"4%","1%","2%");
        DEFFoods.operationsMethod();
        Client GHITrade=new Client("GHI Trade",3,0,"3%","1%","3%");
        GHITrade.operationsMethod();
        Client JKLKiosks=new Client("JKL Kiosks",4,0,"2%","3%","5%");
        JKLKiosks.operationsMethod();
        Client MNOVending=new Client("MNO Vending",5,0,"0%","5%","7%");
        MNOVending.operationsMethod();
        Map<Integer, Client> findClient = new HashMap<>();//dictionary for faster search
        findClient.put(1,ABCDistribution);
        findClient.put(2,DEFFoods);
        findClient.put(3,GHITrade);
        findClient.put(4,JKLKiosks);
        findClient.put(5,MNOVending);

        //This is the previous code before I made it read the data from a file
        //Scanner scanner = new Scanner(System.in);
        //String AllData = scanner.nextLine();

        Scanner scanner = new Scanner(System.in);
        String filePath=scanner.nextLine();
        String AllData="";
        try {
            File order = new File(filePath);//before it was "C:/Users/Acer/Desktop/order.txt"
            Scanner reader = new Scanner(order);
            while (reader.hasNextLine()) {
                AllData += reader.nextLine();
            }
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        String[] parts = AllData.split(",");
        Client theWantedClient=findClient.get(Integer.parseInt(parts[0])); //the first element is the ID of the client
        System.out.println("Client: " + theWantedClient.name);
        System.out.println("Product,   Quantity,   Standard Unit Price,  Promotional Unit Price,   Line Total");
        double sumForTheProducts=0.00; //initial counter for the total su of money
        for (int i=1;i< parts.length;i++)
        {
            String[] productQuantity=parts[i].split("="); //separating ID and quantity
            Product theWantedProduct=findProduct.get(Integer.parseInt(productQuantity[0]));
            double sumForTheProduct=theWantedProduct.getSumToBePaidForTheProduct(Integer.parseInt(productQuantity[1])); //calculating the cost for the whole amount of the same product
            sumForTheProducts=sumForTheProducts+sumForTheProduct; //adding to the whole order cost
            if(!theWantedProduct.promotion.equals("none"))//in case of a promotion
            {
                System.out.println(theWantedProduct.name+ ", "+productQuantity[1]+", EUR "+theWantedProduct.getStandartPrice()+", EUR "+
                        theWantedProduct.getAfterPromotionPrice()+ ", EUR "+sumForTheProduct);
            }
            else {
                System.out.println(theWantedProduct.name+ ", "+productQuantity[1]+", EUR "+theWantedProduct.getStandartPrice()+", "+
                        "___ , EUR "+sumForTheProduct);//omitting the unnecessary value
            }
        }
        System.out.println("Total Before Client Discounts: "+sumForTheProducts);
        theWantedClient.sumOfMoneyToBePaid=sumForTheProducts;//save the base price of the whole order
        theWantedClient.operationsMethod();//calculating the personal discount and the additional discount
        if(!theWantedClient.personalDiscount.equals("0%"))//in case there is personal discount
        {
            System.out.println("Basic Client Discount: EUR "+theWantedClient.personalDiscountSum);
        }
        if(theWantedClient.getAfterPersonalDiscount()!=theWantedClient.finalSumOfMoneyToBePay()) //in case there is additional discount
        {
            if(theWantedClient.getAfterPersonalDiscount()>30000) {
                System.out.println("Additional Volume Discount: at "+theWantedClient.above30000 +"  EUR "+ theWantedClient.getTotalDiscountQ());
            }
            else if(theWantedClient.getAfterPersonalDiscount()>10000)
            {
                System.out.println("Additional Volume Discount: at "+theWantedClient.above10000 +"  EUR "+ theWantedClient.getTotalDiscountQ());
            }
        }
        System.out.println("Order Total Amount: EUR "+theWantedClient.finalSumOfMoneyToBePay());


    }
}