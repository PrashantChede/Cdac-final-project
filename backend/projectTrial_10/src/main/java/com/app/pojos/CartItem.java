//package com.app.pojos;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name="cart_items")
//public class CartItem extends BaseEntity {
//	private int quantity;
//	
//	//CartItem *---->1 Cart
//	@ManyToOne
//	@JoinColumn(name="cart_id")
//	private Cart cart;
//	//CartItem 1--->1 Product
//	@OneToOne
//	@JoinColumn(name="product_id")
//	private Product cartProduct;
//	public CartItem(){
//		// TODO Auto-generated constructor stub
//	}
//	
//	public CartItem(int quantity) {
//		super();
//		this.quantity = quantity;	
//	}
//	
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	
//	public Cart getCart() {
//		return cart;
//	}
//	
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//	public Product getCartProduct() {
//		return cartProduct;
//	}
//	public void setCartProduct(Product cartProduct) {
//		this.cartProduct = cartProduct;
//	}
//	@Override
//	public String toString() {
//		return "CartItem ID "+getId()+" [quantity=" + quantity + "]";
//	}
//	
//	
//}






// alternative way 


package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name="cart_items")
public class CartItem extends BaseEntity {
	
	
	//CartItem *---->1 Cart
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	//CartItem 1--->1 Product
	@OneToOne
	@JoinColumn(name="product_id")
	private Product cartProduct;
	public CartItem(){
		// TODO Auto-generated constructor stub
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Product getCartProduct() {
		return cartProduct;
	}
	
	public void setCartProduct(Product cartProduct) {
		this.cartProduct = cartProduct;
	}


	
	
	
}

