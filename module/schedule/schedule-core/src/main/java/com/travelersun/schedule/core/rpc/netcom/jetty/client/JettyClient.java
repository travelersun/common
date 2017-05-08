package com.travelersun.schedule.core.rpc.netcom.jetty.client;


import com.travelersun.schedule.core.rpc.codec.RpcRequest;
import com.travelersun.schedule.core.rpc.codec.RpcResponse;
import com.travelersun.schedule.core.rpc.serialize.HessianSerializer;
import com.travelersun.schedule.core.util.HttpClientUtil;

/**
 * jetty client
 * @author xuxueli 2015-11-24 22:25:15
 */
public class JettyClient {

	public RpcResponse send(RpcRequest request) throws Exception {
		byte[] requestBytes = HessianSerializer.serialize(request);
		byte[] responseBytes = HttpClientUtil.postRequest("http://" + request.getServerAddress() + "/", requestBytes);
		return (RpcResponse) HessianSerializer.deserialize(responseBytes, RpcResponse.class);
	}

}
