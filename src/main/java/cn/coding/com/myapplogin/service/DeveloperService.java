package cn.coding.com.myapplogin.service;

/**
 *@Author JosephCrypto
 *@Create 2022-16-2/11/22 10:16 PM
 */

import cn.coding.com.myapplogin.entity.Developer;
import cn.coding.com.myapplogin.exception.UserNotFoundException;
import cn.coding.com.myapplogin.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository repository;

//    public List<Developer> listAll() {
//        return (List<Developer>) repository.findAll();
//    }

      public Developer getById(Long id) throws UserNotFoundException {
          Optional<Developer> result = repository.findById(id);
          if (result.isPresent()) {
              return result.get();
          }
          throw new UserNotFoundException("Could not find any Developer with ID " + id);
      }

      public void deleteById(Long id) throws UserNotFoundException {
          Long count = repository.countById(id);
          if (count == null || count == 0) {
              throw new UserNotFoundException("Could not find any Developer with ID " + id);
          }
          repository.deleteById(id);
      }

}
