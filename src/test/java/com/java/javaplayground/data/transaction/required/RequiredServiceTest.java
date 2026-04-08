package com.java.javaplayground.data.transaction.required;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RequiredServiceTest {

    @Autowired
    private RequiredService requiredService;

    @AfterEach
    void afterEach() {
        getAll();
    }

    @Test
    @DisplayName("시작점에서 예외 발생")
    void testSaveException() {
        requiredService.save(true, false, false);
    }

    @Test
    @DisplayName("모두 성공")
    void testSaveSuccess() {
        requiredService.save(false, false, false);
    }

    @Test
    @DisplayName("호출된 하위 메서드에서 예외 발생")
    void testSaveChildException() {
        requiredService.save(false, true, true);
    }

    @Test
    @DisplayName("분리된 하위 메서드에서 예외 발생")
    void testSaveSeperatedServiceTest() {
        requiredService.save(false, false, true);
    }


    @Test
    @DisplayName("트랜잭션 시작점에서 checked 예외")
    //순서 :: 성공 -> 성공 -> checked
    void checkedExceptionTest() throws Exception {
        requiredService.saveCheckedException(true, false, false);
    }

    @Test
    @DisplayName("분리된 서비스에서 unChecked 에외 발생")
    //순서 :: 성공 -> unchecked -> 성공
    void 분리된_서비스에서_언체크_에외_발생() throws Exception {
        requiredService.saveCheckedException(false, false, true);
    }

    @Test
    @DisplayName("분리된 서비스에서 checked 에외 발생")
    //순서 :: 성공 -> checked -> 성공
    void 분리된_서비스에서_체크_에외_발생() throws Exception {
        requiredService.saveCheckedException(false, true, false);
    }

    @Test
    @DisplayName("전부 예외")
    //순서 :: check -> 끝
    void 언체크_예외_체크_예외_혼종() throws Exception {
        requiredService.saveCheckedException(true, true, true);
    }

    @Test
    @DisplayName("전부 예외")
    //순서 :: uncheck -> check
    void 마지막에만_체크_예외() throws Exception {
        requiredService.saveCheckedException(true, false, true);
    }

    @Test
    void deleteAll() {
        requiredService.deleteAll();
    }

    @Test
    void getAll() {
        System.out.println(requiredService.getAll());
    }
}