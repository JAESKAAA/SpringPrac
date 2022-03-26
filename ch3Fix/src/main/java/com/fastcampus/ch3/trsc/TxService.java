package com.fastcampus.ch3.trsc;

import com.fastcampus.ch3.entity.TempRepository;
import com.fastcampus.ch3.entity.Tmp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TxService {

    private final TempRepository tempRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertA1WithTx() {


        tempRepository.save(new Tmp(1L,100));
        insertB1WithTx();
        tempRepository.save(new Tmp(2L,200));

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertB1WithTx() {
        tempRepository.save(new Tmp(3L, 300));
        tempRepository.save(new Tmp(3L, 400));

    }



}
