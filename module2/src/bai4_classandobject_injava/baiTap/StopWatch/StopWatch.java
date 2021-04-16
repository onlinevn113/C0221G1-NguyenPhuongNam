package bai4_ClassandObject_InJava.baiTap.StopWatch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    public void start(){
       this.startTime= System.currentTimeMillis();
    }
    public void stop(){
       this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return endTime-startTime;
    }


}
