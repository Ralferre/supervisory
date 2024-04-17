package repository.detector;

import dto.model.detector.Detector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectorRepository extends JpaRepository<Detector, Integer> {
    Page<Detector> findAll(Pageable pageable);
    Page<Detector>
    findByTagOrNameOrSerialNumberOrRangeOrInstalledAreaOrLocationAreaOrDateLastCalibrationOrDateNextCalibration(
            String tag,
            String name,
            String serialNumber,
            String range,
            String installedArea,
            String locationArea,
            String dateLastCalibration,
            String dateNextCalibration
    );
}
