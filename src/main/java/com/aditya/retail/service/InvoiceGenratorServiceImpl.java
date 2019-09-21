package com.aditya.retail.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.aditya.retail.entity.ProductType;
import com.aditya.retail.entity.ShoppingCartItems;
import com.aditya.retail.entity.UserType;

public class InvoiceGenratorServiceImpl implements InvoiceGenratorService{

	@Autowired
	InvoiceGenratorService invoiceGenratorService;
	
	static HashMap<String,Integer> userDiscountMap= new HashMap<>();
	
	static{
		
		userDiscountMap.put(UserType.EMPLOYEE.toString(), 30);
		userDiscountMap.put(UserType.AFFILIATE.toString(), 10);
		userDiscountMap.put(UserType.OLD_CUSTOMER.toString(), 5);
	}
	
	@Override
	public Double calculateDiscountedAmount(Integer discount,Double total) {
		
		return (total * discount) / 100;
	}
	
	@Override
	public Double calculateCartTotal(List<ShoppingCartItems> shoppingCartList) {
		Double totalCost = 0.0;

		for (ShoppingCartItems shoppingItem : shoppingCartList) {
			totalCost += shoppingItem.getProductPrice();
		}
		return totalCost;
	}
	
	@Override
	public Integer getUserDiscount(String userType) {
		if(!StringUtils.isEmpty(userType))
		{if(userDiscountMap.get(userType)!=null) {
		return userDiscountMap.get(userType);
		}
		return 0;
		}
		return -1;
	}
	
	@Override
	public Double calculateFinalBill(Double totalDiscounted, Double groceriesAmount) {
		
		return totalDiscounted+groceriesAmount;
	}
	
	@Override
	public Double getGroceriesTotal(List<ShoppingCartItems> shoppingCartList) {
		Double groceriesTotal = 0.0;
		for (ShoppingCartItems shoppingCartItems : shoppingCartList) {
			if (shoppingCartItems.getProductType().toString().equals(ProductType.GROCERIES.toString())) {
				groceriesTotal += shoppingCartItems.getProductPrice();
			}
		}
		return groceriesTotal;
	}
	
	/**
	 * @param invoiceGenratorService the invoiceGenratorService to set
	 */
	public void setInvoiceGenratorService(InvoiceGenratorService invoiceGenratorService) {
		this.invoiceGenratorService = invoiceGenratorService;
	}
}
