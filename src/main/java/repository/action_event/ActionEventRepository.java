package repository.action_event;

import dto.model.action_event.ActionUponEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionEventRepository extends JpaRepository<ActionUponEvent, Integer> {
    Page<ActionUponEvent> findAll(Pageable pageable);
    Page<ActionUponEvent> findByRearmedOnOrMutedOnOrRecognizedOn(
            String rearmedOn,
            String mutedOn,
            String recognizedOn
    );
}
