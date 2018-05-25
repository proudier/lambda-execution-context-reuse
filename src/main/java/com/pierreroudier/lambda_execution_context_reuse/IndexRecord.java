package com.pierreroudier.lambda_execution_context_reuse;

/**
 * Model for an index entry
 */
public class IndexRecord {
    private String key;
    private String attribute;

    public IndexRecord(String key, String attribute) {
        this.key = key;
        this.attribute = attribute;
    }
}
