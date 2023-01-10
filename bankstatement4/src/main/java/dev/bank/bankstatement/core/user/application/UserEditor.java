package dev.bank.bankstatement.core.user.application;

import dev.bank.bankstatement.core.user.domain.User;

/**
 * User 정보 편집기
 * (create, update, delete 등)
 */
public interface UserEditor {

    /**
     * 새로운 User 등록
     * @param newUser - 새로 등록된 User Entity
     * @return String id - 가입된 user id
     */
    String create(User newUser);

    /**
     * User 정보 변경
     * @param updateUser - 새롭게 업데이트할 user 정보를 담고 있는 엔티티 객체
     * @return  Usser user - 수정된 user 엔티티 객체
     */
    User update(User updateUser);

    /**
     * User의 정보 제거
     * @param id - 제거할 User 엔티티
     * @return String id - 제거된 User id
     */
    String delete(String id);
}
