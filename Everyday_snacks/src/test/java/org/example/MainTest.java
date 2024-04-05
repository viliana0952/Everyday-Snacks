package org.example;

import org.example.client.Client;
import org.example.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
@Test
public void main()
{
    //for case input: 1,1=10000
    int quantity=10000;
    Product DanishMuffin=new Product("Danish Muffin",1,0.52,"80%", "none");
    DanishMuffin.operationsMethod();
    double result=DanishMuffin.getSumToBePaidForTheProduct(quantity);
    assertEquals(9400.00,result);

    Client ABCDistribution=new Client("ABC Distribution",1,0,"5%","0%","2%");
    ABCDistribution.sumOfMoneyToBePaid=result;
    ABCDistribution.operationsMethod();
    double resultClient=ABCDistribution.finalSumOfMoneyToBePay();
    assertEquals(8930.0,resultClient);

    /////////////////////////////////////////////
    //for case input: 4,4=20000
    quantity=20000;
    Product CrispyChips=new Product("Crispy chips",4,0.60,"1.00 EUR/unit", "Buy 2, get 3rd free");
    CrispyChips.operationsMethod();
    double result2=CrispyChips.getSumToBePaidForTheProduct(quantity);
    assertEquals(21334.40,result2);

    Client JKLKiosks=new Client("JKL Kiosks",4,0,"2%","3%","5%");
    JKLKiosks.sumOfMoneyToBePaid=result2;
    JKLKiosks.operationsMethod();
    double resultClient2=JKLKiosks.finalSumOfMoneyToBePay();
    assertEquals(20280.48,resultClient2);
}
}