package jp.yamashita.raiseclick;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long> {
    Spot findBySpotName(String spotName);
}
