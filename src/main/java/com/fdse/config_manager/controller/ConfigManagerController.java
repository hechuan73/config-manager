package com.fdse.config_manager.controller;

import com.fdse.config_manager.bean.Metrics.Response.NodesMetricsResponse;
import com.fdse.config_manager.bean.Metrics.Response.PodsMetricsResponse;
import com.fdse.config_manager.response.SetUnsetServiceRequestSuspendResponse;
import com.fdse.config_manager.request.*;
import com.fdse.config_manager.response.*;
import com.fdse.config_manager.service.ConfigManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public class ConfigManagerController {

    @Autowired
    private ConfigManagerService configManagerService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/hello", method= RequestMethod.GET)
    public String hello(){
        return "hello config-manager";
    }

    //Get the available clusters
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getClusters", method= RequestMethod.GET)
    public GetClustersResponse getClusters(){
        return configManagerService.getClusters();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setServiceRequestSuspend", method= RequestMethod.POST)
    public SetUnsetServiceRequestSuspendResponse setServiceRequestSuspend(
            @RequestBody SetUnsetServiceRequestSuspendRequest request){

        System.out.println("[=====] /api/setServiceRequestSuspend");
        System.out.println("[=====] svcName:" + request.getSvc());

        return configManagerService.setServiceRequestSuspend(request);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setServiceRequestSuspendWithSourceSvc", method= RequestMethod.POST)
    public SetUnsetServiceRequestSuspendResponse setServiceRequestSuspendWithSourceSvc(
            @RequestBody SetUnsetServiceRequestSuspendRequest request){

        System.out.println("[=====] /api/setServiceRequestSuspendWithSourceSvc");
        System.out.println("[=====] svcName:" + request.getSvc());
        System.out.println("[=====] sourceSvcName:" + request.getSourceSvcName());

        return configManagerService.setServiceRequestSuspendWithSource(request);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/unsetServiceRequestSuspend", method= RequestMethod.POST)
    public SetUnsetServiceRequestSuspendResponse unsetServiceRequestSuspend(
            @RequestBody SetUnsetServiceRequestSuspendRequest request){

        System.out.println("[=====] /api/unsetServiceRequestSuspend");
        System.out.println("[=====] svcName:" + request.getSvc());

        return configManagerService.unsetServiceRequestSuspend(request);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setAsyncRequestSequence", method= RequestMethod.POST)
    public AsyncRequestSequenceResponse setAsyncRequestSequenceResponse(
            @RequestBody SetAsyncRequestSequenceRequest request){

        System.out.println("[=====] /api/setAsyncRequestSequence");
        System.out.println("[=====] svc Number:" + request.getSvcList().size());

        return configManagerService.setAsyncRequestsSequence(request);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setAsyncRequestSequenceWithSrc", method = RequestMethod.POST)
    public AsyncRequestSequenceResponse setAsyncRequestSequenceResponseWithSrc(
            @RequestBody AsyncRequestSequenceRequestWithSource request){

        System.out.println("[=====] /api/setAsyncRequestSequence");
        System.out.println("[=====] src Name:" + request.getSourceName());
        System.out.println("[=====] svc Name:" + request.getSvcList().size());

        return configManagerService.setAsyncRequestsSequenceWithSource(request);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/unsuspendAllRequests", method = RequestMethod.POST)
    public AsyncRequestSequenceResponse unsuspendAllRequests(
            @RequestBody AsyncRequestSequenceRequestWithSource request){

        System.out.println("[=====] /api/unsuspendAllRequests");
        System.out.println("[=====] src Name:" + request.getSourceName());
        System.out.println("[=====] svc Name:" + request.getSvcList().size());

        return configManagerService.unsuspendAllRequest(request);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setAsyncRequestSequenceWithSrcCombineWithFullSuspend", method = RequestMethod.POST)
    public AsyncRequestSequenceResponse setAsyncRequestSequenceWithSrcCombineWithFullSuspend(
            @RequestBody AsyncRequestSequenceRequestWithSource request){

        System.out.println("[=====] /api/setAsyncRequestSequenceWithSrcCombineWithFullSuspend");
        System.out.println("[=====] src Name:" + request.getSourceName());
        System.out.println("[=====] svc Name:" + request.getSvcList().size());

        return configManagerService.setAsyncRequestSequenceWithSrcCombineWithFullSuspend(request);
    }


    //Set the replicas of running service
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/setReplicas", method= RequestMethod.POST)
    public SetServiceReplicasResponse setServiceReplica(@RequestBody SetServiceReplicasRequest setServiceReplicasRequest){
        return configManagerService.setServiceReplica(setServiceReplicasRequest);
    }

    //Get the list of all current services: include name and replicas
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getServicesList/{clusterName}", method= RequestMethod.GET)
    public GetServicesListResponse getServicesList(@PathVariable String clusterName){
        return configManagerService.getServicesList(clusterName);
    }

    //Get the service config: currently cpu and memory only
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getServicesAndConfig/{clusterName}", method= RequestMethod.GET)
    public GetServicesAndConfigResponse getServicesAndConfig(@PathVariable String clusterName){
        return configManagerService.getServicesAndConfig(clusterName);
    }

    //Get the number of replicas of services
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getServicesReplicas", method= RequestMethod.POST)
    public GetServiceReplicasResponse getServicesReplicas(@RequestBody GetServiceReplicasRequest getServiceReplicasRequest){
        return configManagerService.getServicesReplicas(getServiceReplicasRequest);
    }

    //Service delta: Reserve only the services contained in the list
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/reserveServiceByList", method= RequestMethod.POST)
    public ReserveServiceByListResponse reserveServiceByList(@RequestBody ReserveServiceRequest reserveServiceRequest){
        return configManagerService.reserveServiceByList(reserveServiceRequest);
    }

    //Node delta: Set to run on single node
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/runOnSingleNode/{clusterName}", method= RequestMethod.GET)
    public SetRunOnSingleNodeResponse setRunOnSingleNode(@PathVariable String clusterName){
        return configManagerService.setRunOnSingleNode(clusterName);
    }

    //Get the list of all current nodes info
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getNodesList/{clusterName}", method= RequestMethod.GET)
    public GetNodesListResponse getNodesList(@PathVariable String clusterName){
        return configManagerService.getNodesList(clusterName);
    }

    //Delete the node in the list
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/deleteNodeByList", method= RequestMethod.POST)
    public DeltaNodeByListResponse deleteNodeByList(@RequestBody DeltaNodeRequest deltaNodeRequest){
        return configManagerService.deleteNodeByList(deltaNodeRequest);
    }

    //Reserve the node in the list
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/reserveNodeByList", method= RequestMethod.POST)
    public DeltaNodeByListResponse reserveNodeByList(@RequestBody DeltaNodeRequest deltaNodeRequest){
        return configManagerService.reserveNodeByList(deltaNodeRequest);
    }

    //Get the list of all current pods info
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getPodsList/{clusterName}", method= RequestMethod.GET)
    public GetPodsListResponse getPodsList(@PathVariable String clusterName){
        return configManagerService.getPodsListAPI(clusterName);
    }

    //Get all of the log of current pods
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getPodsLog/{clusterName}", method= RequestMethod.GET)
    public GetPodsLogResponse getPodsLog(@PathVariable String clusterName){
        return configManagerService.getPodsLog(clusterName);
    }

    //Get the log of the specific pod
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getSinglePodLog", method= RequestMethod.POST)
    public GetSinglePodLogResponse getSinglePodLog(@RequestBody GetSinglePodLogRequest getSinglePodLogRequest){
        return configManagerService.getSinglePodLog(getSinglePodLogRequest);
    }

    //Restart the zipkin pod
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/restartService/{clusterName}", method= RequestMethod.GET)
    public RestartServiceResponse restartService(@PathVariable String clusterName){
        return configManagerService.restartService(clusterName);
    }

    //Config the container resource
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/deltaCMResource", method= RequestMethod.POST)
    public DeltaCMResourceResponse deltaCMResource(@RequestBody DeltaCMResourceRequest deltaCMResourceRequest){
        return configManagerService.deltaCMResource(deltaCMResourceRequest);
    }

    //Get the endpoints of all services
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getServiceWithEndpoints/{clusterName}", method= RequestMethod.GET)
    public ServiceWithEndpointsResponse getServiceWithEndpoints(@PathVariable String clusterName){
        return configManagerService.getServiceWithEndpoints(clusterName);
    }

    //Get the endpoints of specific services
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/getSpecificServiceWithEndpoints", method= RequestMethod.POST)
    public ServiceWithEndpointsResponse getSpecificServiceWithEndpoints(@RequestBody ReserveServiceRequest reserveServiceRequest) {
        return configManagerService.getSpecificServiceWithEndpoints(reserveServiceRequest);
    }

    //Delta all: currently instance and config
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/api/deltaAll", method= RequestMethod.POST)
    public SimpleResponse deltaAll(@RequestBody DeltaAllRequest deltaAllRequest) {
        return configManagerService.deltaAll(deltaAllRequest);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/nodeMetrics/{clusterName}")
    public NodesMetricsResponse getNodesMetrics(@PathVariable String clusterName) throws Exception {
        return configManagerService.getNodesMetrics(clusterName);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/podMetrics/{clusterName}")
    public PodsMetricsResponse getPodsMetrics(@PathVariable String clusterName) throws Exception {
        return configManagerService.getPodsMetrics(clusterName);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/api/getPodIds")
    public PodIPToIdResponse getPodIdByIp(@RequestBody @NotNull PodIPToIdRequest request) throws Exception {
        return configManagerService.getPodIdByIp(request);
    }
}
