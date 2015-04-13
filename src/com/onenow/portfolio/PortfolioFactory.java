package com.onenow.portfolio;

import java.util.ArrayList;
import java.util.List;

import com.onenow.constant.InvApproach;
import com.onenow.constant.SamplingRate;
import com.onenow.constant.TradeType;
import com.onenow.data.Channel;
import com.onenow.data.InitMarket;
import com.onenow.data.MarketPrice;
import com.onenow.execution.BrokerActivityImpl;
import com.onenow.execution.BrokerInteractive;
import com.onenow.execution.Contract;
import com.onenow.execution.ContractFactory;
import com.onenow.instrument.Investment;
import com.onenow.instrument.InvestmentIndex;
import com.onenow.instrument.Underlying;
import com.onenow.research.Candle;
import com.onenow.research.Chart;
import com.onenow.util.ParseDate;

public class PortfolioFactory {

	private static BrokerInteractive IB;
	private static BrokerActivityImpl broker;
	
	private static Portfolio marketPortfolio = new Portfolio();
	private static MarketPrice marketPrice = new MarketPrice();
	private static Underlying index;
	
	static List<String> samplingRate = new ArrayList<String>();
	
	public PortfolioFactory() {
		
	}
	
	public PortfolioFactory(Underlying index) throws InterruptedException {
		setIndex(index);
		InitMarket init = new InitMarket(index, getMarketPortfolio()); 		
		setSamplingRate(getSampling("all"));
		System.out.println("SAMPLING: " + getSamplingRate().toString() + "\n");
	}	
	
	public static void launch() throws InterruptedException {

		while(true) {							// In Real-Time Constantly		
			getUptodateInvestmentCharts();
			analyzeUptodateInvestmentCharts();
			
			//***	 Look for signals, particularly at resitance & support
			//***	 Confirm via price, volume, and momentum
			//***	 Become familiar with the rythm of the underlying
			EntranceExitDecisioning decisioning = new EntranceExitDecisioning(getIndex());

			if(decisioning.EnterNowAtBottom()) {
				goLong(getIndex());
			}

			if(decisioning.EnterNowAtTop()) {
				goShort(getIndex());
			}
			
			System.out.println(",,,,,");
			Thread.sleep(50000);
		}
	}
	
	// LONG AND SHORT
	public static void goLong(Underlying under) {
//		String expDate = "20150319";
//		Exocet spxExocet = new Exocet(100, under, expDate, getBroker());
//		StrategyCallBuy swingCall = (StrategyCallBuy) spxExocet.getCall(InvApproach.SWING, TradeRatio.NONE, 0.50);
//		System.out.println(swingCall.toString());
	}

	public static void goShort(Underlying index) {
//		Exocet spxExocet = new Exocet(100, new Underlying(getIndexName()), getExpDate(), getBroker());
//		StrategyCallBuy swingCall = (StrategyCallBuy) spxExocet.getCall(InvApproach.SWING, TradeRatio.NONE, 0.50);
//		System.out.println(swingCall.toString());
	}

	
	// CHARTS
	// TODO: underlying price, resistance/support?
	private static void getUptodateInvestmentCharts() {
		String fromDate = "2015-02-21"; 	// TODO: configurable date
		String toDate = "2015-02-28";
		for(String sampling:getSamplingRate()) {
			for(Investment inv:getMarketPortfolio().getInvestments()) {
				getInvestmentChart(inv, fromDate, toDate, sampling);
			}
		}
	}
	
	private static void getInvestmentChart(Investment inv, String fromDate, String toDate, String sampling) {

		Chart chart = new Chart();
		chart = getMarketPrice().queryChart(inv, TradeType.TRADED.toString(), fromDate, toDate, sampling);
		
		if(!chart.getSizes().isEmpty()) {
			inv.getCharts().put(sampling, chart); // sampling is key	
			System.out.println("+ chart " + inv.toString() +  " " + sampling + "\n" + chart.toString());			
		} else {
			System.out.println("- chart " + inv.toString() + " " + sampling);
		}		
	}

	// ANALYSIS
	private static void analyzeUptodateInvestmentCharts() {
		for(Investment inv:getMarketPortfolio().getInvestments()) {
			for(String trading:getTradingOptions()) {
				String analysis = "";
				analysis = analysis + "=====" + inv.toString() + "=====" + "\n";
				for(String sampling:getSampling(trading)) { 
					analysis = analysis + getInvestmentAnalysis(inv, sampling);
				}			
				System.out.println(analysis + "\n");
			}			
		}	
	}

	private static String getInvestmentAnalysis(Investment inv, String sampling) {
		String s = "\n";
		s = s + ">> " + sampling + "\t"; 
		Chart chart = inv.getCharts().get(sampling);
		if(chart!=null) { // not all sampling cases may be available
			s = s + getChartAnalysis(chart);			
		} else {
			s = s + "null";
		}
		s = s + "\n";
		return s;
	}	
	
	private static String getChartAnalysis(Chart chart) {
		String s = "";
		chart.setAnalysis();
		for(int i=0; i<chart.getPrices().size(); i++) {
			s = s + chart.getPriceAnalysis(i);
			s = s + chart.getVolumeAnalysis(i);
			s = s + chart.getMomentumAnalysis(i);
		}		
		return s;
	}
		
	// RATE
	private static List<String> getSampling(String rate) {
		List<String> list = new ArrayList<String>();
		if(rate.equals(SamplingRate.SCALP.toString()) || rate.equals("all")) {
			list.addAll(getScalpSampling());
		}
		if(rate.equals(SamplingRate.SWING.toString()) || rate.equals("all")) {
			list.addAll(getSwingSampling());
		}
		if(rate.equals(SamplingRate.TREND.toString()) || rate.equals("all")) {
			list.addAll(getTrendSampling());
		}
		return list;
	}
	
	private static List<String> getTradingOptions() {
		List<String> list = new ArrayList<String>();
		list.add(SamplingRate.SCALP.toString());
		list.add(SamplingRate.SWING.toString());
		list.add(SamplingRate.TREND.toString());
		return list;
	}
	private static List<String> getScalpSampling() {
		List<String> list = new ArrayList<String>();
		list.add(SamplingRate.SCALPSHORT.toString());
		list.add(SamplingRate.SCALPMEDIUM.toString());
		list.add(SamplingRate.SCALPLONG.toString());					
		return list;
	}
	private static List<String> getSwingSampling() {
		List<String> list = new ArrayList<String>();
		list.add(SamplingRate.SWINGSHORT.toString());
		list.add(SamplingRate.SWINGMEDIUM.toString());
		list.add(SamplingRate.SWINGLONG.toString());								
		return list;
	}
	private static List<String> getTrendSampling() {
		List<String> list = new ArrayList<String>();
		list.add(SamplingRate.TRENDSHORT.toString());
		list.add(SamplingRate.TRENDMEDIUM.toString());
		list.add(SamplingRate.TRENDLONG.toString());							
		return list;
	}

	
	// TEST
	
	// PRINT
	
	// SET / GET
	private static BrokerActivityImpl getBroker() {
		return broker;
	}

	private void setBroker(BrokerActivityImpl broker) {
		this.broker = broker;
	}

	private static BrokerInteractive getIB() {
		return IB;
	}

	private static void setIB(BrokerInteractive iB) {
		IB = iB;
	}

	private static Portfolio getMarketPortfolio() {
		return marketPortfolio;
	}

	private void setMarketPortfolio(Portfolio marketPortfolio) {
		this.marketPortfolio = marketPortfolio;
	}

	private static MarketPrice getMarketPrice() {
		return marketPrice;
	}

	private static void setMarketPrice(MarketPrice marketPrice) {
		PortfolioFactory.marketPrice = marketPrice;
	}

	private static List<String> getSamplingRate() {
		return samplingRate;
	}

	private void setSamplingRate(List<String> samplingRate) {
		this.samplingRate = samplingRate;
	}

	private static Underlying getIndex() {
		return index;
	}

	private static void setIndex(Underlying index) {
		PortfolioFactory.index = index;
	}

}