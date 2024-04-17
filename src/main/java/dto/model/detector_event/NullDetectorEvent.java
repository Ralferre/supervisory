package dto.model.detector_event;

public class NullDetectorEvent extends DetectorEvent{
    public Integer getIdEvent() {
        return null;
    }

    public Integer getIdDetector() {
        return null;
    }

    public Double getMaxRegister() {
        return null;
    }

    public String getDateRegister() {
        return "";
    }
}
