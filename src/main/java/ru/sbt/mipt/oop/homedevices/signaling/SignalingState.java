package ru.sbt.mipt.oop.homedevices.signaling;

public abstract class SignalingState {
    Signaling signaling;

    SignalingState(Signaling signaling) {
        this.signaling = signaling;
    }

    public abstract void activate(String code);

    public abstract void deactivate(String code);

    public abstract void enableAlarm();
}
