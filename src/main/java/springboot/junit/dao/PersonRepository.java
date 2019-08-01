package springboot.junit.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.learn.bean.Person;


public interface PersonRepository extends JpaRepository<Person, String> {

    // @Query(value = "select * from person p where p.name= name and p.address= address", nativeQuery = true)
    @Query("from Person p where p.name = :name and p.address = :address")
    Person getPersonByQuerySql(@Param("name") String name, @Param("address") String address);


    Person findPersonByName(@Param("name") String name);

    List<Person> findAllByName(@Param("name") String name, Pageable pageable);
}
