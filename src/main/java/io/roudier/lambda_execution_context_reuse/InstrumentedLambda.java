package io.roudier.lambda_execution_context_reuse;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InstrumentedLambda implements RequestHandler<S3Event, String> {
    private static Logger logger;

    static {
        logger = LogManager.getLogger(InstrumentedLambda.class);
        logger.trace("Static initialization block");
    }

    {
        logger.trace("Initialization block");
    }

    public InstrumentedLambda() {
        logger.trace("Constructor");
    }

    @Override
    public String handleRequest(S3Event input, Context context) {
        logger.trace("Handling request with " + this);
        return "done";
    }
}
