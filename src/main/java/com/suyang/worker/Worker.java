package com.suyang.worker;

public class Worker {
    private Runnable runnable;
    private WorkStatus status = WorkStatus.Idle;
    private Exception lastException = null;
    private Thread thread = null;

    public Worker(Runnable runnable) {
        this.runnable = runnable;
    }

    public WorkStatus getStatus() {
        return status;
    }

    public Exception getLastException() {
        return lastException;
    }

    public void start() {
        if (this.status.equals(WorkStatus.Stopped) ||
                this.status.equals(WorkStatus.Idle) ||
                this.status.equals(WorkStatus.Queue)) {
            this.status = WorkStatus.Running;
            this.thread = new Thread(this::run);
            this.thread.start();
        }
    }

    public void run() {
        try {
            runnable.run();
        } catch (Exception ex) {
            lastException = ex;
            status = WorkStatus.Error;
        }
        status = WorkStatus.Stopped;
    }

    public void stop() {
        this.thread.interrupt();
    }

    public void queue() {

    }
}
