package com.devsat.lili.learningspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// interface to access the Room table
@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
