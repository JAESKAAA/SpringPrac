package com.fastcampus.ch3.trsc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TxServiceTest {

    @Autowired
    TxService txService;

    @Test
    @DisplayName("트랜잭션 테스트 : 모든 데이터 롤백된다.")
    public void txTest() {

        txService.insertA1WithTx();

    }
}