package com.fdse.config_manager.service;

import com.fdse.config_manager.bean.Metrics.Response.NodesMetricsResponse;
import com.fdse.config_manager.bean.Metrics.Response.PodsMetricsResponse;
import com.fdse.config_manager.request.*;
import com.fdse.config_manager.response.*;

public interface ConfigManagerService {
    GetClustersResponse getClusters();
    SetServiceReplicasResponse setServiceReplica(SetServiceReplicasRequest setServiceReplicasRequest);
    GetServicesListResponse getServicesList(String clusterName);
    GetServicesAndConfigResponse getServicesAndConfig(String clusterName);
    GetServiceReplicasResponse getServicesReplicas(GetServiceReplicasRequest getServiceReplicasRequest);
    SetRunOnSingleNodeResponse setRunOnSingleNode(String clusterName);
    ReserveServiceByListResponse reserveServiceByList(ReserveServiceRequest reserveServiceRequest);
    GetNodesListResponse getNodesList(String clusterName);
    DeltaNodeByListResponse deleteNodeByList(DeltaNodeRequest deltaNodeRequest);
    DeltaNodeByListResponse reserveNodeByList(DeltaNodeRequest deltaNodeRequest);
    GetPodsListResponse getPodsListAPI(String clusterName);
    GetPodsLogResponse getPodsLog(String clusterName);
    GetSinglePodLogResponse getSinglePodLog(GetSinglePodLogRequest getSinglePodLogRequest);
    RestartServiceResponse restartService(String clusterName);
    DeltaCMResourceResponse deltaCMResource(DeltaCMResourceRequest deltaCMResourceRequest);
    SetUnsetServiceRequestSuspendResponse setServiceRequestSuspend(SetUnsetServiceRequestSuspendRequest setUnsetServiceRequestSuspendRequest);
    SetUnsetServiceRequestSuspendResponse unsetServiceRequestSuspend(SetUnsetServiceRequestSuspendRequest setUnsetServiceRequestSuspendRequest);
    SetUnsetServiceRequestSuspendResponse unsetServiceRequestSuspendWithSource(SetUnsetServiceRequestSuspendRequest request);
    AsyncRequestSequenceResponse setAsyncRequestsSequence(SetAsyncRequestSequenceRequest setAsyncRequestSequenceRequest);
    SetUnsetServiceRequestSuspendResponse setServiceRequestSuspendWithSource(SetUnsetServiceRequestSuspendRequest setUnsetServiceRequestSuspendRequest);
    ServiceWithEndpointsResponse getServiceWithEndpoints(String clusterName);
    ServiceWithEndpointsResponse getSpecificServiceWithEndpoints(ReserveServiceRequest reserveServiceRequest);
    AsyncRequestSequenceResponse setAsyncRequestsSequenceWithSource(AsyncRequestSequenceRequestWithSource setAsyncRequestSequenceRequest);
    AsyncRequestSequenceResponse setAsyncRequestSequenceWithSrcCombineWithFullSuspend(AsyncRequestSequenceRequestWithSource request);
    AsyncRequestSequenceResponse unsuspendAllRequest(AsyncRequestSequenceRequestWithSource request);
    SimpleResponse deltaAll(DeltaAllRequest deltaAllRequest);
    NodesMetricsResponse getNodesMetrics(String clusterName) throws Exception;
    PodsMetricsResponse getPodsMetrics(String clusterName) throws Exception;
    PodIPToIdResponse getPodIdByIp(PodIPToIdRequest request) throws Exception;
}
