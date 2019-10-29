package be.syntra.java.advanced.model;

public enum Action {
    LIST, ADD, REMOVE, EDIT, HELP, EXIT;

    private int payload;

    Action() {
        this.payload = -1;
    }

    public int getPayload() {
        return this.payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }
}
