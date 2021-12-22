/**
 * 
 */
package com.restful.webservice.restfulwebservice.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Balaji
 *
 */
@Repository
public interface UserJPARepository extends JpaRepository<User, Integer>{

}
