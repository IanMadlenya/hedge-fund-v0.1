package com.onenow.portfolio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;

import com.onenow.constant.InvTerm;
import com.onenow.constant.InvType;
import com.onenow.constant.TradeType;
import com.onenow.instrument.Investment;
import com.onenow.instrument.InvestmentFuture;
import com.onenow.instrument.InvestmentIndex;
import com.onenow.instrument.InvestmentOption;
import com.onenow.instrument.InvestmentReserved;
import com.onenow.instrument.InvestmentStock;
import com.onenow.instrument.Underlying;
import com.onenow.util.Watchr;

public class Portfolio {

	public List<Investment> investments = new ArrayList<Investment>();
	private Hashtable<Investment, Integer> quantity = new Hashtable<Investment, Integer>();

	// CONSTRUCT
	public Portfolio() {
		
	}

	public Portfolio(List<Investment> invs) { // investments with no quantity
		this.investments = invs; 
	}

	public Portfolio(List<Investment> invs, Hashtable<Investment, Integer> quantity) {
		this.investments = invs; 
		setQuantity(quantity);
	}

	// INIT
	public void enterTransaction(Transaction trans) {
		for (Trade trade : trans.getTrades()) {
			enterInvestment(trade);
		}
	}
	
	private void enterInvestment(Trade trade) {
		Investment invToEnter = trade.getInvestment();
		Integer quantity = trade.getQuantity();

		if(getQuantity().get(invToEnter) == null) { // not there
			investments.add(invToEnter);
			getQuantity().put(invToEnter, quantity);
		} else { // increment
				Integer init = getQuantity().get(invToEnter);
				if (trade.getTradeType().equals(TradeType.BUY)) {
					getQuantity().put(invToEnter,  init + trade.getQuantity());								
				} else {
					getQuantity().put(invToEnter, init - trade.getQuantity());								
				}				
		}
	}
	
	public Integer getAbsQuantity() {
		Integer sum = 0;
			for(Investment inv:investments) {
				sum += Math.abs(getQuantity().get(inv));
			}
		return sum;
	}
	
	// SEARCH
	public List<Investment> getInvestments(InvType type) {
		List<Investment> foundInvs = new ArrayList<Investment>();
		for (Investment investment : investments) {
			if (investment.getInvType().equals(type)) {
				foundInvs.add(investment);
			}
		}
		return foundInvs;
	}

	public List<Investment> getInvestments(Underlying under) {
		List<Investment> foundInvs = new ArrayList<Investment>();
		for (Investment investment : investments) {
			if (investment.getUnder().equals(under)) {
				foundInvs.add(investment);
			}
		}
		return foundInvs;
	}

	public List<Investment> getInvestments(Underlying under, InvType type) {
		List<Investment> foundInvs = new ArrayList<Investment>();
		for (Investment investment : getInvestments(type)) {
			if (under.getTicker().equals(investment.getUnder().getTicker())) {
				foundInvs.add(investment);
			}
		}	
		return foundInvs;
	}

	public List<Investment> getInvestments(Underlying under, InvType type, InvTerm term) {
		List<Investment> foundInvs = new ArrayList<Investment>();
		for (Investment investment : getInvestments(under, type)) {
			if (investment instanceof InvestmentReserved) { }
				InvestmentReserved invRes= (InvestmentReserved) investment;
				if(invRes.getTerm().equals(term)) {
					foundInvs.add(investment);					
			}
		}	
		return foundInvs;
	}

	public List<Investment> getInvestments(Underlying under, InvType type, String exp) {
		List<Investment> foundInvs = new ArrayList<Investment>();
		for (Investment investment : getInvestments(under, type)) {
			if (type.equals(InvType.CALL) || type.equals(InvType.PUT)) {
				InvestmentOption opt = (InvestmentOption) investment;
				if(opt.getExpirationDate().equals(exp)) {
					foundInvs.add(investment);
				}
			}
		}	
		return foundInvs;		
	}
	
	public List<Investment> getInvestments(Underlying under, InvType type, String exp, Double strike) {
		List<Investment> foundInvs = new ArrayList<Investment>();
		for (Investment investment : getInvestments(under, type, exp)) {
			if (type.equals(InvType.CALL) || type.equals(InvType.PUT)) {
				InvestmentOption opt = (InvestmentOption) investment;
				if(opt.getStrikePrice().equals(strike)) {
					foundInvs.add(investment);
				}
			}
		}	
		return foundInvs;			
	}
	
	// CLOUD GET BEST
	public Investment getBestSpot(Underlying under) throws IndexOutOfBoundsException {
		List<Investment> invs = getInvestments(under, InvType.SPOT);
		return invs.get(0);  
	}
	
	public Investment getBestOnDemand(Underlying under) throws IndexOutOfBoundsException {
		List<Investment> invs = getInvestments(under, InvType.ONDEMAND);
		return invs.get(0);
	}
	
	public Investment getBestReserved(Underlying under, InvTerm term) throws IndexOutOfBoundsException {	
		List<Investment> invs = getInvestments(under, InvType.RESERVED, term); 
		return invs.get(0);
	}
	
	// WALL ST GET BEST
	public Investment getBestStock(Underlying under) throws IndexOutOfBoundsException {
		List<Investment> invs = getInvestments(under, InvType.STOCK);
		return invs.get(0);
	}
	
	public Investment getBestOption(Underlying under, InvType type, String exp, Double strike) 
		throws IndexOutOfBoundsException {
		List<Investment> invs = getInvestments(under, type, exp, strike); 
		return invs.get(0);
	}

	// PRINT
	public String toString() {
		String s = "";
		Integer i = 0;
		for(Investment inv:investments) {
			s = s + getQuantity().get(inv) + " " + investments.get(i) + "\n";
			i++;
		}
		return s;
	}
	public String toIndicesString() {
		String s = "";
		Integer i = 0;
		System.out.println("\n" + "INITIALIZED INDICES");
		for(Investment inv:investments) {
			if(inv instanceof InvestmentIndex) {
				s = s + getQuantity().get(inv) + " " + investments.get(i) + "\n";
			}
			i++;
		}
		return s;
	}
	public String toOptionsString() {
		String s = "";
		Integer i = 0;
		System.out.println("\n" + "INITIALIZED OPTIONS");
		for(Investment inv:investments) {
			if(inv instanceof InvestmentOption) {
				s = s + getQuantity().get(inv) + " " + investments.get(i) + "\n";
			}
			i++;
		}
		return s;
	}
	public String toStocksString() {
		String s = "";
		Integer i = 0;
		Watchr.log(Level.INFO,  "INITIALIZED STOCKS", "\n", "");
		for(Investment inv:investments) {
			if(inv instanceof InvestmentStock) {
				s = s + investments.get(i) + " ";
				s = s + "(" + getQuantity().get(inv) + ")";
				s = s + "\n";
			}
			i++;
		}
		return s;
	}
	public String toFuturesString() {
		String s = "";
		Integer i = 0;
		System.out.println("\n" + "INITIALIZED FUTURES");
		for(Investment inv:investments) {
			if(inv instanceof InvestmentFuture) {
				s = s + "[[[" + getQuantity().get(inv) + "]]]" + " ";				
				s = s + investments.get(i);
			}
			i++;
		}
		return s;
	}

	
	// TEST

	// GET SET
	public Hashtable<Investment, Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(Hashtable<Investment, Integer> quantity) {
		this.quantity = quantity;
	}

}