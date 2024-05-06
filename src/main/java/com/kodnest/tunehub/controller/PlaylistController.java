package com.kodnest.tunehub.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.Service.PlaylistService;
import com.kodnest.tunehub.Service.SongService;
import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;
@Controller
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;

	@Autowired
	SongService songService;
	
	@GetMapping("/createplaylists")
	public  String createPlaylist(Model model) {
		
		List<Song>songList= songService.fetchAllSongs();
		model.addAttribute("songs" , songList);
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		playlistService.addPlaylist(playlist);
		
		List<Song> songs=playlist.getSongs();
		for(Song song : songs) {
			song.getPlaylists().add(playlist);
			songService.updateSong(song);
		}
		return "Adminhome";
		
		
	}

	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<Playlist> allplaylist = playlistService.fetchAllPlaylists();

		model.addAttribute("playlist", allplaylist);
		return "viewplaylist";
	} 
}

