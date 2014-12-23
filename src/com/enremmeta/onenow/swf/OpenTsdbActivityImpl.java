package com.enremmeta.onenow.swf;

import com.enremmeta.onenow.summit.AwsPricing;
import com.enremmeta.onenow.summit.Yak;

public class OpenTsdbActivityImpl implements CloudPriceLister {

	@Override
	public AwsPricing onDemandPricing() {
		try {
			AwsPricing pricing = Yak.readPricing();
			return pricing;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}