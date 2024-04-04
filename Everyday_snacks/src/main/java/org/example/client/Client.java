package org.example.client;

import java.text.DecimalFormat;

public class Client {
    private DecimalFormat df = new DecimalFormat("0.00");
    public String name;
    public int ID;
    public double sumOfMoneyToBePaid;
    public String personalDiscount;
    private double afterPersonalDiscount;
    public double personalDiscountSum;
    public double getAfterPersonalDiscount()
    {
        return afterPersonalDiscount;
    }
    private void setAfterPersonalDiscount()
    {
        int i=0;
        String percentageDiscount="";
        while(personalDiscount.charAt(i)!='%')
        {
            percentageDiscount=percentageDiscount+personalDiscount.charAt(i);//getting the number only
            i++;
        }

        double personalDiscountSumUnformatted= sumOfMoneyToBePaid *Double.parseDouble(percentageDiscount)/100;
        String roundedNumStr = df.format(personalDiscountSumUnformatted);
        personalDiscountSum=Double.parseDouble(roundedNumStr.replace(",", "."));
        afterPersonalDiscount=sumOfMoneyToBePaid - sumOfMoneyToBePaid *Double.parseDouble(percentageDiscount)/100;
    }
    public String above10000;
    private double above1Percentage;//the percentage as a number
    private void setAbove1Percentage()
    {
        int i=0;
        String percentageDiscount="";
        while(above10000.charAt(i)!='%')
        {
            percentageDiscount=percentageDiscount+above10000.charAt(i);
            i++;
        }
        above1Percentage=Double.parseDouble(percentageDiscount);
    }
    public String above30000;
    private double above3Percentage;//the percentage as a number
    private void setAbove3Percentage()
    {
        int i=0;
        String percentageDiscount="";
        while(above30000.charAt(i)!='%')
        {
            percentageDiscount=percentageDiscount+above30000.charAt(i);
            i++;
        }
        above3Percentage=Double.parseDouble(percentageDiscount);
    }

    public void operationsMethod()
    {
        setAfterPersonalDiscount();
        setAbove1Percentage();
        setAbove3Percentage();

    }
    private double totalDiscountQ;
    public double getTotalDiscountQ()
    {
        return totalDiscountQ;
    }
    public double finalSumOfMoneyToBePay()
    {
        if(afterPersonalDiscount>10000.0&&afterPersonalDiscount<30000)
        {
            double totalDiscountQUnformatted=above1Percentage*afterPersonalDiscount/100.0;
            String roundedNumStr = df.format(totalDiscountQUnformatted);
            totalDiscountQ=Double.parseDouble(roundedNumStr.replace(",", "."));
            double result=afterPersonalDiscount-totalDiscountQ;
            String roundedNumStrRes = df.format(result);
            return Double.parseDouble(roundedNumStrRes.replace(",", "."));
        }
        else if(afterPersonalDiscount>30000.0)
        {
            double totalDiscountQUnformatted=above3Percentage*afterPersonalDiscount/100.0;
            String roundedNumStr = df.format(totalDiscountQUnformatted);
            totalDiscountQ=Double.parseDouble(roundedNumStr.replace(",", "."));
            double result=afterPersonalDiscount-totalDiscountQ;
            String roundedNumStrRes = df.format(result);
            return Double.parseDouble(roundedNumStrRes.replace(",", "."));
        }
        else
            return afterPersonalDiscount;
    }

    public Client(String name,int ID,double sumOfMoneyToBePaid,String personalDiscount,String above10000,String above30000)
    {
        this.name=name;
        this.ID=ID;
        this.sumOfMoneyToBePaid=sumOfMoneyToBePaid;
        this.personalDiscount=personalDiscount;
        this.above10000=above10000;
        this.above30000=above30000;
    }
}
