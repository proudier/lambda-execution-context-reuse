package com.pierreroudier.lambda_execution_context_reuse;

import java.util.UUID;

public class Logic {
    private Index index;

    public Logic(Index index) {
        this.index = index;
    }

    public void getThingsDone(String key) throws InterruptedException {
        String attribute = UUID.randomUUID().toString();
        IndexRecord record = new IndexRecord(key, attribute);
        index.putRecord(record);
    }
}
