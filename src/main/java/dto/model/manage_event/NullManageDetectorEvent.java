package dto.model.manage_event;

public class NullManageDetectorEvent extends ManageDetectorEvent{
    public Integer getIdActionManage() {
        return null;
    }

    public Integer getIdDetector() {
        return null;
    }

    public Integer getIdUser(){
        return null;
    }

    public String getDateAction() {
        return "";
    }

    public String getTypeActionManage() {
        return "";
    }
}
