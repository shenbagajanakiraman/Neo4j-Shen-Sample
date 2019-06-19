package com.stackroute.neo.repository;

import com.stackroute.neo.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository  extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();


   // public User addUser();
   @Query("CREATE (u:User) SET u.id={userId},u.name={userName},u.age={age} RETURN u")
    public User saveNode(Long userId, String userName, int age);


    @Query("MATCH (u:User) WHERE u.id={id} DETACH DELETE u RETURN 'node deleted' ")
//    public void delete(@Param("id") Long id);
    public void delete(Long id);


    @Query("MATCH (u:User) WHERE u.name={userName} RETURN u")
    public User findByName(@Param("userName") String userName);


   @Query("MATCH (User) DETACH DELETE User")
   public void deleteAll();


   @Query("MATCH (a:User),(b:Movie) WHERE a.id > 0 CREATE (a)-[r:relname]->(b)  RETURN r")
    void mymapfunction();


   @Query("MATCH (n:User) WHERE n.id={id} SET n.name={name}, n.age={age} RETURN n")
    User updateFunction(long id, String name, Integer age);
}
