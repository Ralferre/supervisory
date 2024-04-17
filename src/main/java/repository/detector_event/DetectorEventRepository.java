package repository.detector_event;

import dto.model.detector_event.DetectorEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectorEventRepository extends JpaRepository<DetectorEvent, Integer> {
    Page<DetectorEvent> findAll(Pageable pageable);
    Page<DetectorEvent> findByMaxRegisterOrDateRegister(Double maxRegister, String dateRegister);
}
