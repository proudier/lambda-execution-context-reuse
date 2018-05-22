package io.roudier.lambda_execution_context_reuse;

/**
 * A class representing some kind of NoSQL database where an index is stored
 */
interface Index {
    void putRecord(IndexRecord record) throws InterruptedException;
}
