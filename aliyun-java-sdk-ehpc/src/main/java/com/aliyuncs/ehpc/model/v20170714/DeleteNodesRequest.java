/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.aliyuncs.ehpc.model.v20170714;

import com.aliyuncs.RpcAcsRequest;
import java.util.List;

/**
 * @author auto create
 * @version 
 */
public class DeleteNodesRequest extends RpcAcsRequest<DeleteNodesResponse> {
	
	public DeleteNodesRequest() {
		super("EHPC", "2017-07-14", "DeleteNodes", "ehs");
	}

	private Boolean releaseInstance;

	private List<Instance> instances;

	private String clusterId;

	public Boolean getReleaseInstance() {
		return this.releaseInstance;
	}

	public void setReleaseInstance(Boolean releaseInstance) {
		this.releaseInstance = releaseInstance;
		if(releaseInstance != null){
			putQueryParameter("ReleaseInstance", releaseInstance.toString());
		}
	}

	public List<Instance> getInstances() {
		return this.instances;
	}

	public void setInstances(List<Instance> instances) {
		this.instances = instances;	
		if (instances != null) {
			for (int depth1 = 0; depth1 < instances.size(); depth1++) {
				putQueryParameter("Instance." + (depth1 + 1) + ".Id" , instances.get(depth1).getId());
			}
		}	
	}

	public String getClusterId() {
		return this.clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
		if(clusterId != null){
			putQueryParameter("ClusterId", clusterId);
		}
	}

	public static class Instance {

		private String id;

		public String getId() {
			return this.id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}

	@Override
	public Class<DeleteNodesResponse> getResponseClass() {
		return DeleteNodesResponse.class;
	}

}
