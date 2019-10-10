package com.fdse.config_manager.async;

import com.fdse.config_manager.request.AsyncRequestSequenceRequestWithSource;
import com.fdse.config_manager.response.AsyncRequestSequenceResponse;
import com.fdse.config_manager.service.ConfigManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import java.util.concurrent.Future;

@Component  
public class AsyncTask {

    @Autowired
    @Lazy
    private ConfigManagerService configManagerService;

    @Async("myAsync")
    public Future<AsyncRequestSequenceResponse> doAsync(AsyncRequestSequenceRequestWithSource request) throws InterruptedException{
        AsyncRequestSequenceResponse response =
                configManagerService.setAsyncRequestsSequenceWithSource(request);
        return new AsyncResult<>(response);
    }



}  
