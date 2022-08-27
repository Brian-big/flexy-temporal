package com.brianbig.flexy.workflow;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.common.RetryOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class OrderWorker {

    public static void  StartOrderWorker(){
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory workerFactory = WorkerFactory.newInstance(client);
        Worker worker = workerFactory.newWorker(Shared.TASK_QUEUE);
        worker.registerWorkflowImplementationTypes(OrderWorkflow.class);
        worker.registerActivitiesImplementations(new OrderActivity());
        workerFactory.start();
    }

    public static OrderWorkflowInterface getWorkFlow(){
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(Shared.TASK_QUEUE)
                .setRetryOptions(RetryOptions.getDefaultInstance())
                .build();
        return client.newWorkflowStub(OrderWorkflowInterface.class, options);
    }
}
