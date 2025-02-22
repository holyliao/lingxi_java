package com.lingxi.lingxi_java.auth.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    @Query(value = "select p.* from permission p join role_permission_relation rp on rp.permission_id = p.id " +
            "join user_role_relation ur on ur.role_id = rp.role_id where ur.user_id = ?", nativeQuery = true)
    List<Permission> findAllByUserId(Long userId);

}
