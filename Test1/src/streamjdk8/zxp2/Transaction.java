package streamjdk8.zxp2;

import java.util.Currency;

public class Transaction  {
	
	private final Trader trader;
	private final Currency currency;
	private final int year;
	private final int value;
	public Transaction(Trader trader,Currency currency, int year, int value){
		this.currency=currency;
		this.trader = trader;
		this.year = year;
		this.value = value;
	}
	public Trader getTrader(){
		return this.trader;
	}
	public int getYear(){
		return this.year;
	}
	public int getValue(){
		return this.value;
	}
	public String toString(){
		return "{" + this.trader + ", " +"year: "+this.year+", " +"value:" + this.value +"}";
	}
	public Currency getCurrency() {
		return currency;
	}
	
}
