package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread thread;
    public LoggingStateThread (Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = thread.getState();
        System.out.println(state);
        State newState;

        while (!thread.isInterrupted()) {
            newState = thread.getState();
            if (newState != state) {
                System.out.println(newState);
                state = newState;
            }
            if (newState.equals(State.TERMINATED)) { break; }
        }
    }

}
