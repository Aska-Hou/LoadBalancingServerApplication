package Domain;

public class LoadingResult {

    public double CPULoading;

    public double MemoryLoading;

    public double IOLoading;

    public LoadingResult(){

    }

    public LoadingResult(double CPULoading, double memoryLoading, double IOLoading) {
        this.CPULoading = CPULoading;
        MemoryLoading = memoryLoading;
        this.IOLoading = IOLoading;
    }

    @Override
    public String toString() {
        return "LoadingResult{" +
                "CPULoading=" + CPULoading +
                ", MemoryLoading=" + MemoryLoading +
                ", IOLoading=" + IOLoading +
                '}';
    }

    public double getCPULoading() {
        return CPULoading;
    }

    public void setCPULoading(double CPULoading) {
        this.CPULoading = CPULoading;
    }

    public double getMemoryLoading() {
        return MemoryLoading;
    }

    public void setMemoryLoading(double memoryLoading) {
        MemoryLoading = memoryLoading;
    }

    public double getIOLoading() {
        return IOLoading;
    }

    public void setIOLoading(double IOLoading) {
        this.IOLoading = IOLoading;
    }
}
