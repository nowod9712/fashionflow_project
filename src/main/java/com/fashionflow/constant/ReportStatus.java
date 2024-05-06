package com.fashionflow.constant;

public enum ReportStatus {
    WAITING("처리대기중"), COMPLETE("처리완료");

    private final String description;

    ReportStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
