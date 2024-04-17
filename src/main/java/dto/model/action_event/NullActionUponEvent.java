package dto.model.action_event;

import jakarta.persistence.criteria.CriteriaBuilder;

public class NullActionUponEvent extends ActionUponEvent{
    public Integer getIdActionEvent() {
        return null;
    }

    public Integer getIdActionManage() {
        return null;
    }

    public Integer getIdUser() {
        return null;
    }

    public String getRearmedOn() {
        return "";
    }

    public String getMutedOn() {
        return "";
    }

    public String getRecognizedOn() {
        return "";
    }
}
