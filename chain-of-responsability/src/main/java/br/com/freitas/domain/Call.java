package br.com.freitas.domain;

import java.time.Instant;

public record Call(
                    String senderPhone,
                        String receiverPhone,
                            int durationInMinutes,
                                Instant moment,
                                    CallType callType) {

    public boolean isInternal() {
        return callType.equals(CallType.INTERNAL);
    }

    public boolean isLocal() {
        return callType.equals(CallType.LOCAL);
    }

    public boolean isDDD() {
        return callType.equals(CallType.DDD);
    }

    public boolean isDDI() {
        return callType.equals(CallType.DDI);
    }

}