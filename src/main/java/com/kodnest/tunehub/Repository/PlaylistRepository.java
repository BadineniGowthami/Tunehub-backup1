package com.kodnest.tunehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

	 public Playlist findByName(String string);

	
}
