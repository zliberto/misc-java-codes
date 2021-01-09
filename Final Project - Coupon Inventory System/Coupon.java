import java.text.NumberFormat;

public class Coupon {
	
    NumberFormat perc = NumberFormat.getPercentInstance( );
    NumberFormat curr = NumberFormat.getCurrencyInstance( );


	String product;
	float price;
	String provider;
	int discountRate;
	int expiration;
	String status;
	float finalPrice;
	
	
	public Coupon (String product,
			float price,
	String provider,
	int discountRate,
	int expiration,
	String status,
	float finalPrice
	
	) {
		this.product = product;
		this.price = price;
		this.provider = provider;
		this.discountRate = discountRate;
		this.expiration = expiration;
		this.status = status;
		this.finalPrice = finalPrice;
		
	}
	
	public String getProduct() {
		return product;
		
	}
	
	public float getPrice() {
		return price;
	}
	
	public String getProvider() {
		return provider;

	}
	
	public int getDiscountRate() {
		return discountRate;
	}
	
	public int getExpiration() {
		return expiration;
	}
	
	public String getStatus() {
		return status;
	}
	
	public float getFinalPrice() {
		return finalPrice;
	}
	
	@Override
	public String toString() {
		return "\nProduct name: " + product+ "\n" + "Price: " + (curr.format(price))+ "\n" + "Provider: " + provider+ "\n" + "Discount Rate: " + perc.format(discountRate/100.00)+ "\n" + "Expiration: " + expiration + " day(s)\n"+ "Status: " +status+"\nFinal Price: " + curr.format(finalPrice) 
				;
	}
		
		
	}

	


