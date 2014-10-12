package com.enremmeta.onenow.summit;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeSpotInstanceRequestsRequest;
import com.amazonaws.services.ec2.model.DescribeSpotInstanceRequestsResult;
import com.amazonaws.services.ec2.model.SpotInstanceRequest;
import com.amazonaws.services.ec2.model.SpotInstanceStatus;
import com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient;
import com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest;
import com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsResult;
import com.amazonaws.services.elasticmapreduce.model.Instance;
import com.amazonaws.services.elasticmapreduce.model.InstanceGroup;
import com.amazonaws.services.elasticmapreduce.model.InstanceGroupConfig;
import com.amazonaws.services.elasticmapreduce.model.InstanceGroupModifyConfig;
import com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsRequest;
import com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsResult;
import com.amazonaws.services.elasticmapreduce.model.ListInstancesRequest;
import com.amazonaws.services.elasticmapreduce.model.ListInstancesResult;
import com.amazonaws.services.elasticmapreduce.model.MarketType;
import com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest;
import com.enremmeta.onenow.summit.AwsPricing.Region;
import com.enremmeta.onenow.summit.AwsPricing.Size;

public class EmrFacade {

	private String access;
	private String secret;
	private String clusterId;

	public EmrFacade(final String access, final String secret, String clusterId) {
		super();
		this.access = access;
		this.secret = secret;
		this.clusterId = clusterId;
		AWSCredentials creds = new AWSCredentials() {

			public String getAWSSecretKey() {
				return secret;
			}

			public String getAWSAccessKeyId() {
				return access;
			}
		};
		emr = new AmazonElasticMapReduceClient(creds);
		cw = new AmazonCloudWatchClient(creds);
		ec2 = new AmazonEC2Client(creds);
	}

	public InstanceGroup getTaskGroup(String clusterId) {
		ListInstanceGroupsResult lsInstGrpRes = emr
				.listInstanceGroups(new ListInstanceGroupsRequest()
						.withClusterId(clusterId));
		List<InstanceGroup> instGroups = lsInstGrpRes.getInstanceGroups();
		InstanceGroup taskGroup = null;
		for (InstanceGroup instGroup : instGroups) {
			String name = instGroup.getName();
			String grpType = instGroup.getInstanceGroupType();
			if (grpType.equalsIgnoreCase("task")) {
				taskGroup = instGroup;
			}
			Logger.log(grpType + " (" + name + "):  "
					+ instGroup.getRunningInstanceCount() + "/"
					+ instGroup.getRequestedInstanceCount() + " of "
					+ instGroup.getInstanceType());
		}
		return taskGroup;
	}

	private String emrRegion = "us-east-1";

	public int getTaskCost() {
		InstanceGroup taskGroup = getTaskGroup(clusterId);
		if (taskGroup == null) {
			return 0;

		}
		String instType = taskGroup.getInstanceType();
		int instCount = taskGroup.getRunningInstanceCount();
		if (taskGroup.getMarket().equalsIgnoreCase(MarketType.ON_DEMAND.name())) {
			AwsPricing awsPricing = Yak.getInstance().getAwsPricing();
			Region region = awsPricing.getConfig().findRegion(emrRegion);
			Size size = region.findSize(instType);
			size.getValueColumns().get(0).getPrices().getUsd();
		} else {
			ListInstancesResult lsInstRes = emr
					.listInstances(new ListInstancesRequest()
							.withInstanceGroupId(taskGroup.getId()));
			List<Instance> insts = lsInstRes.getInstances();
			List<String> instIds = new ArrayList<String>();
			for (Instance inst : insts) {
				instIds.add(inst.getEc2InstanceId());
				inst.getId();
			}
			DescribeSpotInstanceRequestsResult descSpotInstReqRes = ec2
					.describeSpotInstanceRequests(new DescribeSpotInstanceRequestsRequest());
			List<SpotInstanceRequest> spotInstReqs = descSpotInstReqRes
					.getSpotInstanceRequests();
			for (SpotInstanceRequest spotInstReq : spotInstReqs) {
				if (instIds.contains(spotInstReq.getInstanceId())) {
					String spotPrice = spotInstReq.getSpotPrice();
					SpotInstanceStatus spotInstStatus = spotInstReq.getStatus();

				}
			}
			return -2;
		}
	}

	public void resize(String type, int count, String bid) {
		InstanceGroup taskGroup = getTaskGroup(clusterId);
		if (taskGroup != null) {
			Logger.log("Resizing " + taskGroup.getId() + " to  " + 0);
			InstanceGroupModifyConfig instGrpModCfg = new InstanceGroupModifyConfig(
					taskGroup.getId(), 0);
			emr.modifyInstanceGroups(new ModifyInstanceGroupsRequest()
					.withInstanceGroups(instGrpModCfg));
		}
		InstanceGroupConfig instGrpCfg = new InstanceGroupConfig("TASK", type,
				count).withName("OneNowTask").withMarket(MarketType.SPOT)
				.withBidPrice("0.4");

		AddInstanceGroupsResult addInstGrpRes = emr
				.addInstanceGroups(new AddInstanceGroupsRequest()
						.withJobFlowId(clusterId)
						.withInstanceGroups(instGrpCfg));
		Logger.log("Added: " + addInstGrpRes.getInstanceGroupIds());

		/*
		 * ResizeJobFlowStep rjfStep = new ResizeJobFlowStep()
		 * 
		 * .withResizeAction( new AddInstanceGroup().withInstanceGroup("task")
		 * .withInstanceCount(10) .withInstanceType("m1.small"))
		 * .withOnArrested(OnArrested.Continue)
		 * .withOnFailure(OnFailure.Continue); HadoopJarStepConfig hjsConfig =
		 * rjfStep.toHadoopJarStepConfig();
		 * 
		 * StepConfig sConfig = new StepConfig("Resize", hjsConfig);
		 * 
		 * AddJobFlowStepsResult ajfsRes = emr .addJobFlowSteps(new
		 * AddJobFlowStepsRequest("") .withSteps(sConfig)); String stepId =
		 * ajfsRes.getStepIds().get(0);
		 * Logger.log(ajfsRes.getStepIds().toString()); String state =
		 * "PENDING";
		 * 
		 * while (state.equals("PENDING")) { DescribeStepResult dsRes = emr
		 * .describeStep(new DescribeStepRequest().withClusterId(
		 * "j-2XGI9OQZRY6QG").withStepId(stepId)); state =
		 * dsRes.getStep().getStatus().getState(); Logger.log(state); }
		 */

	}

	private AmazonCloudWatchClient cw;
	private AmazonElasticMapReduceClient emr;
	private AmazonEC2Client ec2;

}
