package com.aditya.retail;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aditya.retail.entity.ProductType;
import com.aditya.retail.entity.ShoppingCartItems;
import com.aditya.retail.entity.UserInfo;
import com.aditya.retail.entity.UserType;
import com.aditya.retail.service.InvoiceGenratorServiceImpl;

/**
 * @author Aditya
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailAssignmentApplicationTests {
	
	@Mock 
	UserInfo userInfo;
	
	@Mock
	List<ShoppingCartItems> shoppingCartItems;
	
	
	@InjectMocks
	InvoiceGenratorServiceImpl  genratorServiceImpl;
	
	@Before
	public void prepareData() {
		shoppingCartItems = new ArrayList<ShoppingCartItems>();

		ShoppingCartItems cartItems = new ShoppingCartItems();
		cartItems.setProductName("iPhone");
		cartItems.setProductPrice(500.00);
		cartItems.setProductStock(22);
		cartItems.setProductType(ProductType.ELECTRONICS.toString());
		shoppingCartItems.add(cartItems);
		
		cartItems = new ShoppingCartItems();
		cartItems.setProductName("t-Shirt");
		cartItems.setProductPrice(200.00);
		cartItems.setProductStock(2);
		cartItems.setProductType(ProductType.FASHION.toString());
		shoppingCartItems.add(cartItems);
		
		cartItems = new ShoppingCartItems();
		cartItems.setProductName("Rice");
		cartItems.setProductPrice(12.34);
		cartItems.setProductStock(2);
		cartItems.setProductType(ProductType.GROCERIES.toString());
		shoppingCartItems.add(cartItems);
		
		cartItems = new ShoppingCartItems();
		cartItems.setProductName("Soap");
		cartItems.setProductPrice(10.30);
		cartItems.setProductStock(5);
		cartItems.setProductType(ProductType.GROCERIES.toString());
		shoppingCartItems.add(cartItems);
		
		cartItems = new ShoppingCartItems();
		cartItems.setProductName("Shampoo");
		cartItems.setProductPrice(4.4);
		cartItems.setProductStock(10);
		cartItems.setProductType(ProductType.GROCERIES.toString());
		shoppingCartItems.add(cartItems);
		
		cartItems = new ShoppingCartItems();
		cartItems.setProductName("Tv");
		cartItems.setProductPrice(1000.40);
		cartItems.setProductStock(1);
		cartItems.setProductType(ProductType.ELECTRONICS.toString());
		shoppingCartItems.add(cartItems);
		
		cartItems.setProductName("Fridge");
		cartItems.setProductPrice(560.90);
		cartItems.setProductStock(11);
		cartItems.setProductType(ProductType.KITCHEN_APPLIANCE.toString());
		shoppingCartItems.add(cartItems);
		
		cartItems.setProductName("Towel");
		cartItems.setProductPrice(27.54);
		cartItems.setProductStock(90);
		cartItems.setProductType(ProductType.OTHER.toString());
		shoppingCartItems.add(cartItems);
		
	}

	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testIfUserIsEmployeeShouldGet30PercentDiscount() {
		//Assign 
		UserInfo userInfo = new UserInfo("Aditya", "Govind", "Pune", UserType.EMPLOYEE);
		
		//Act
		prepareData(userInfo);
	}

	@Test
	public void testIfUserIsAffiliateShouldGet10PercentDiscount() {
		//Assign 
		UserInfo userInfo = new UserInfo("Aditya", "Govind", "Pune", UserType.AFFILIATE);
		
		//Act
		prepareData(userInfo);
	}
	
	@Test
	public void testIfUserIsOldCustomerShouldGet5PercentDiscount() {
		//Assign 
		UserInfo userInfo = new UserInfo("Aditya", "Govind", "Pune", UserType.OLD_CUSTOMER);
		
		//Act
		prepareData(userInfo);
	}
	
	@Test
	public void testIfUserIsGenericShouldGet5PercentDiscount() {
		//Assign 
		UserInfo userInfo = new UserInfo("Aditya", "Govind", "Pune", UserType.OTHER);
		
		//Act
		prepareData(userInfo);
	}

	/**
	 * @param userInfo
	 */
	private void prepareData(UserInfo userInfo) {
		
		System.out.println("----------------------------Invoice for "+userInfo.getUserType()+"-----------------------------------------------------");
		Double total= genratorServiceImpl.calculateCartTotal(shoppingCartItems);
		System.out.println("Cart Total "+total);
		
		Double groceriesItemTotal = genratorServiceImpl.getGroceriesTotal(shoppingCartItems);
		System.out.println("Groceries Total "+ groceriesItemTotal);
		
		Integer discountToApply = genratorServiceImpl.getUserDiscount(userInfo.getUserType().toString());
		if(discountToApply == 0 && total>=100)
			discountToApply=5;
		
		System.out.println("Total Discount applied "+ discountToApply +"%");
		
		Double discountableTotal =total-groceriesItemTotal;
		Double discountedAmount = genratorServiceImpl.calculateDiscountedAmount(discountToApply,
		  discountableTotal);
		System.out.println("Discounted amount on total bill " + discountedAmount);
		  
		  System.out.println("----------------------------Item List-----------------------------------------------------"
		  );
		  Double totalDiscounted = total - discountedAmount;
		Double finalAmount = genratorServiceImpl.calculateFinalBill(totalDiscounted,groceriesItemTotal);
		System.out.println("Final Amount is --  Total - Discount + Groceries::  " + finalAmount);
		
		for (ShoppingCartItems cartItems : shoppingCartItems) {
			System.out.println(cartItems.getProductName() + " | " + cartItems.getProductType() + " | "
					+ cartItems.getProductPrice());
		}
		  
		  System.out.println("Total Items "+ shoppingCartItems.size());
		  Double expectedAmount= total - (new Double((discountToApply * discountableTotal) / 100))+groceriesItemTotal;
		  System.out.println("expectedAmount "+expectedAmount);
		  System.out.println("--------------------------------------------------------------------------------------");
		  System.out.println("Expected Amount is Supposed to be the final amount for "+userInfo.getUserType()+"::   " + expectedAmount);
		  assertEquals(expectedAmount, finalAmount);
	}

	
}
