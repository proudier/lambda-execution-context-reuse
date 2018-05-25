package com.pierreroudier.lambda_execution_context_reuse;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BetterLambda implements RequestHandler<S3Event, String> {

    private static Logger logger = LogManager.getLogger(BetterLambda.class);
    private Index index;
    private Logic logic;

    @Override
    public String handleRequest(S3Event event, Context context) {
        event.getRecords().forEach((s3EventNotificationRecord) -> {
            try {
                logger.trace("Processing event s3EventNotificationRecord");
                String key = s3EventNotificationRecord.getS3().getObject().getKey();
                getLogic().getThingsDone(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return "done";
    }

    // Singleton
    private Index getIndex() throws InterruptedException {
        if (index == null)
            index = new BetterIndexImpl();
        return index;
    }

    // Singleton
    private Logic getLogic() throws InterruptedException {
        if (logic == null)
            logic = new Logic(getIndex());
        return logic;
    }
}