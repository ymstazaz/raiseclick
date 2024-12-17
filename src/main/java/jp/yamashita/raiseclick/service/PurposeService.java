package jp.yamashita.raiseclick.service;

import jp.yamashita.raiseclick.model.Purpose;
import jp.yamashita.raiseclick.repository.PurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurposeService {
    @Autowired
    private PurposeRepository purposeRepository;
    public Long findOrCreatePurpose(String purposeName) throws Exception {
        Purpose purpose = purposeRepository.findByPurposeName(purposeName);
        if(purpose == null){
            purposeRepository.insertPurpose(purposeName); // INSERTで直接登録
            purpose = purposeRepository.findByPurposeName(purposeName);
        }
        return purpose.getId();
    }

}
