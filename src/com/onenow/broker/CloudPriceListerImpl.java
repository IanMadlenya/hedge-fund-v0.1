package com.onenow.broker;

import java.util.ArrayList;
import java.util.List;

import com.onenow.summit.AwsPricing;
import com.onenow.summit.Yak;
import com.onenow.summit.AwsPricing.InstanceType;
import com.onenow.summit.AwsPricing.RegionPricing;
import com.onenow.summit.AwsPricing.Size;
import com.onenow.summit.AwsPricing.ValueColumn;

public class CloudPriceListerImpl implements CloudPriceLister {

	@Override
	public AwsPricing onDemandPricing() {
		try {
			AwsPricing pricing = Yak.readPricing();
			return pricing;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<String> getRegions(String provider) {
		try {
			AwsPricing pricing = Yak.readPricing();
			List<RegionPricing> regPricing = pricing.getConfig().getRegions();
			List<String> regions = new ArrayList<String>();
			for (RegionPricing rp : regPricing) {
				regions.add(rp.getRegion());
			}
			return regions;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<String> getProducts(String provider) {
		try {
			AwsPricing pricing = Yak.readPricing();
			List<RegionPricing> regPricing = pricing.getConfig().getRegions();
			List<String> products = new ArrayList<String>();
			for (RegionPricing rp : regPricing) {
				// Take US east as its the best one
				if (rp.getRegion().equals("us-east")) {
					for (InstanceType iType : rp.getInstanceTypes()) {
						for (Size size : iType.getSizes()) {
							for (ValueColumn vc : size.getValueColumns()) {
								String prod = vc.getName();
								if (!products.contains(prod)) {
									products.add(prod);
								}
							}
						}
					}
				}
			}
			return products;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<String> getInstanceTypes(String provider) {
		try {
			AwsPricing pricing = Yak.readPricing();
			List<RegionPricing> regPricing = pricing.getConfig().getRegions();
			List<String> instanceTypes = new ArrayList<String>();
			for (RegionPricing rp : regPricing) {
				// Take US east as its the best one
				if (rp.getRegion().equals("us-east")) {
					for (InstanceType iType : rp.getInstanceTypes()) {
						for (Size size : iType.getSizes()) {
							instanceTypes.add(size.getSize());
						}
					}
				}
			}
			return instanceTypes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
