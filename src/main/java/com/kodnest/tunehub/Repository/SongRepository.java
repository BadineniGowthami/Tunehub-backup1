package com.kodnest.tunehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

	Song findByName(String name);

}
