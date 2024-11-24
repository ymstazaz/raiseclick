package jp.yamashita.raiseclick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpotService {
    @Autowired
    private SpotRepository spotRepository;
    public Long findOrCreateSpot(String spotName){
        Spot spot =spotRepository.findBySpotName(spotName);
        if (spot == null){
            spot = new Spot();
            spot.setSpotName(spotName);
            spotRepository.insertSpot(spot);
        }
        return spot.getId();
    }
}
