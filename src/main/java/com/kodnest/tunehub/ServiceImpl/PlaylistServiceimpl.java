package com.kodnest.tunehub.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.Repository.PlaylistRepository;
import com.kodnest.tunehub.Service.PlaylistService;
import com.kodnest.tunehub.entity.Playlist;
@Service
public class PlaylistServiceimpl implements PlaylistService {

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addPlaylist(Playlist playlist) {
		Playlist existplaylist = playlistRepository.findByName(playlist.getName());
		if(existplaylist ==null) {
			playlistRepository.save(playlist);
		}
		else {
			System.out.println("Playlist already exists!");
		}
		
		
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		List<Playlist>allplaylists = playlistRepository.findAll();
		return allplaylists;
	}

	
	}

	
	


	
		
		
	
	

