package cn.coding.com.myapplogin.repository;

import cn.coding.com.myapplogin.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *@Author JosephCrypto
 *@Create 2022-16-2/11/22 10:16 PM
 */
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Developer findByName(String name);

    public Long countById(Long id);
}
