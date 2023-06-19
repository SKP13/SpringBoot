package com.stackroute.oops;

/*
    Class for Analyzing the products present in ProductRepository
 */
public class ProductService {
	
	
    /*
        Returns the name of the product given the productCode
     */
	
	Product[] product = ProductRepository.getProducts();
	
	
    public String findProductNameByCode(int productCode) {
    	for(Product product:product)
    	{
    		if(product.getProductCode()==productCode)
    		{
    			return product.getName();
    		}
    	}
    	
        	return null;
    }

    /*
        Returns the Product with maximum price in a given category
     */
    public Product findMaxPriceProductInCategory(String category) {
    	Product pro = null;
    	double maxPrice = 0;
    	if(category.equalsIgnoreCase(null)|| category.isEmpty())
    		return null;
    	else
    	{
    		for(Product product:product)
    		{
    			if(product.getCategory().equals(category))
    			if(product.getPrice()>maxPrice)
    			{
    				maxPrice = product.getPrice();
    				pro = product;
    				
    			}
    		}
    		
    	}
		return pro;
    	
       
    }

    /*
        Returns a array of products for a given category
     */
    public Product[] getProductsByCategory(String category) {
    	Product[] pro = null;
    	int counter = 0;
    	boolean flag = false;
    	if(category.equalsIgnoreCase(null)|| category.isEmpty())
    		return null;
    	else 
    	{
    		for(Product product: product)
    		{
    			if(product.getCategory().equals(category))
    			{
    				counter++;
    				flag = true;
    			}
    			
    		}
    		if(flag==false)
    		{
    			return null;
    		}
    		
    		pro = new Product[counter];
    		counter--;
    		
    		
    		for(Product product: product)
    		{
    			if(product.getCategory().equals(category))
    			{
    				pro[counter] = product;
    				counter--;
    				
    				
    			}
    		}
    	}
    		
    	
    	
        return pro;
    }
    
}
