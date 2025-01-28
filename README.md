Calculates and prints order details for clients of company Everyday Snacks

Everyday Snacks has 4 products:

        Product 1 – Danish Muffin

        Product 2 – Granny’s Cup Cake

        Product 3 – Frenchy’s Croissant

        Product 4 – Crispy chips

and it has 5 clients:

        Client 1 – ABC Distribution

        Client 2 – DEF Foods

        Client 3 – GHI Trade

        Client 4 – JKL Kiosks

        Client 5 – MNO Vending

----------------------------------------------------------------------------------------------------
<b>Pricing Rules</b> - Everyday Snacks calculates its prices based on different factors as described below:

The Standard Unit Price (2 decimals) for each product is calculated by adding a target markup to
the unit cost – either a fixed amount or a percentage (see table A below).

The Promotional Unit Price reflects any current promotions for the specific product. The
Promotional Unit Price (5 decimals) represents the average effective price per item ordered
after product promotions and before client discounts. It may differ based on the number of
items ordered in a particular order (for instance, in case of “Buy 2, get 3rd item free”).

In addition to promotions, based on negotiations, clients may qualify for – a Basic Client
Discount for each client order, and an Additional Volume Discount that applies again on the
entire order total, after all other discounts have been applied (on top of the Basic Client
Discount) (see table B below).

Unless specified otherwise, it rounds “half-up” preserving 2 decimal places.

---------------------------------------------------------------------------------------------------
![image](https://github.com/user-attachments/assets/03a86ede-6a1c-4f48-abec-ae60580775e4)
![image](https://github.com/user-attachments/assets/f9fc041e-392a-4e49-b311-1a55e3053723)

---------------------------------------------------------------------------------------------------
<b>Example Input and Output</b>

For input: 5,1=10000,4=20000

Interpreted as:

Client MNO Vending is making an order for 10000 units of Danish Muffin and 20000 units of Crispy Chips

the application should compute and print out the detailed order summary in a readable format like:

![image](https://github.com/user-attachments/assets/53ededfe-0abd-44ab-9c02-be9363632cf4)

