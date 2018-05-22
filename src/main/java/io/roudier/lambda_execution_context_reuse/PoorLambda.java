package io.roudier.lambda_execution_context_reuse;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PoorLambda implements RequestHandler<S3Event, String> {
    private static Logger logger = LogManager.getLogger(PoorLambda.class);
    @Override
    public String handleRequest(S3Event event, Context context) {
        event.getRecords().forEach((s3EventNotificationRecord) -> {
            try {
                logger.trace("Processing event s3EventNotificationRecord");
                String key = s3EventNotificationRecord.getS3().getObject().getKey();
                Index index = new PoorIndexImpl();
                Logic logic = new Logic(index);
                logic.getThingsDone(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return "done";
    }
}