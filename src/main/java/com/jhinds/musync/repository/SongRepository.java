package com.jhinds.musync.repository;

import com.jhinds.musync.entities.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<Song, String>{

}
