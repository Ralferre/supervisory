package repository.manage_event;

import dto.model.manage_event.ManageDetectorEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManageEventRepository extends JpaRepository<ManageDetectorEvent, Integer> {
    Page<ManageDetectorEvent> findAll(Pageable pageable);
    Page<ManageDetectorEvent> findByDateActionOrTypeActionManage(String dateAction, String typeActionManage);
}
