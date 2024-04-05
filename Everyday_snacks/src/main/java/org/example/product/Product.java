package org.example.product;

import java.text.DecimalFormat;

public class Product {
    private DecimalFormat df = new DecimalFormat("0.00");
    private DecimalFormat df5 = new DecimalFormat("0.00000");
    public String name;
    public int ID;
    public double unitCost;
    public String markUp;
    private double standartPrice;
    public double getStandartPrice()
    {
        return standartPrice;
    }
    private void setStandartPrice()
    {
        if (markUp.endsWith("%")) {
            double percentage = Double.parseDouble(markUp.substring(0, markUp.length() - 1));//getting the number without the symbol
            String roundedNumStr = df.format(unitCost+percentage/100*unitCost);
            standartPrice=Double.parseDouble(roundedNumStr.replace(",", "."));
        } else if(markUp.endsWith(" EUR/unit")){
            String roundedNumStr = df.format(unitCost+Double.parseDouble(markUp.substring(0, markUp.length() - 9)));
            standartPrice=Double.parseDouble(roundedNumStr.replace(",", "."));
        }
        else{
            throw new IllegalArgumentException("Wrongly written markUp criteria");
        }
    }
    public String promotion;
    private double afterPromotionPrice;
    public double getAfterPromotionPrice()
    {
        return afterPromotionPrice;
    }
    private void setAfterPromotionPrice()
    {
        if (promotion.equals("none")) {
            String roundedNumStr = df5.format(standartPrice);
            afterPromotionPrice=Double.parseDouble(roundedNumStr.replace(",", "."));
        } else if(promotion.endsWith("% off")){
            double n=standartPrice-Double.parseDouble(promotion.substring(0, promotion.length() - 5))*standartPrice/100.0;
            String roundedNumStr = df5.format(n);
            afterPromotionPrice=Double.parseDouble(roundedNumStr.replace(",", "."));
        }
        else{
            afterPromotionPrice=0.0;//assigning the afterPromotionPrice to 0 (as a flag) because to calculate it we need the quantity; we will calculate it later
        }
    }

    public void operationsMethod()
    {
        setStandartPrice();
        setAfterPromotionPrice();
    }

    public double getSumToBePaidForTheProduct(int quantity)
    {
        if(afterPromotionPrice!=0.0)//if there is already calculated afterPromotionPrice
        {
            return quantity*afterPromotionPrice;// calculating the final sum of money for ONE product
        }
        else//if the afterPromotionPrice is not calculated
        {
            int i=4;
            String number="";
            while(promotion.charAt(i)!=',') {
                number=number+promotion.charAt(i);
                i++;
            }
            int timesPriceOff = quantity / (Integer.parseInt(number)+1);

            double afterPromotionPriceUnFormatted=(standartPrice * quantity - timesPriceOff * standartPrice)/quantity;
            String roundedNumStr = df5.format(afterPromotionPriceUnFormatted);
            afterPromotionPrice=Double.parseDouble(roundedNumStr.replace(",", "."));
            return (standartPrice * quantity - timesPriceOff * standartPrice);
        }
    }
    public Product(String name,int ID,double unitCost,String markUp, String promotion)
    {
        this.name=name;
        this.ID=ID;
        this.unitCost=unitCost;
        this.markUp=markUp;
        this.promotion=promotion;
    }
}
