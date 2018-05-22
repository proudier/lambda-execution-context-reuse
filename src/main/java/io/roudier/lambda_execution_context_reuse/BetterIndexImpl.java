package io.roudier.lambda_execution_context_reuse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BetterIndexImpl implements Index {

    private static Logger logger = LogManager.getLogger(BetterIndexImpl.class);

    public BetterIndexImpl() throws InterruptedException {
        logger.trace("Constructing index client");
        logger.trace("Connecting to index (set up pool of connections)");
        // let's say connection costs 100ms
        Thread.sleep(100);
    }

    @Override
    public void putRecord(IndexRecord record) throws InterruptedException {
        logger.trace("Upload data");
        // let's say upload takes 75ms
        Thread.sleep(75);
    }
}
