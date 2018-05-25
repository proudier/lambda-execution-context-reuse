package com.pierreroudier.lambda_execution_context_reuse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * An implementation of the Index interface
 */
public class PoorIndexImpl implements Index {
    private static Logger logger = LogManager.getLogger(PoorIndexImpl.class);

    public PoorIndexImpl() {
        logger.trace("Constructing index client");
    }

    @Override
    public void putRecord(IndexRecord record) throws InterruptedException {
        logger.trace("Connecting to index");
        // let's say connection costs 100ms
        Thread.sleep(100);
        logger.trace("Upload data");
        // let's say upload takes 75ms
        Thread.sleep(75);

    }
}
