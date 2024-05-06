package com.kodnest.tunehub.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.kodnest.tunehub.Service.SongService;
import com.kodnest.tunehub.entity.Song;


@Controller
public class SongController {
       @Autowired
        SongService songService;
	   
    	   @PostMapping("/addsongs")
    	   public String addSong(@ModelAttribute Song song) {
    		   String name= song.getName();
    		    boolean songExists=songService.songExists(name);
    		    	
    		   if(songExists == false ) {
    		   songService.saveSong(song);
    		   System.out.println("song added successfully");
    		   }
    		   else {
    			   System.out.println("Duplicate song");
    		   }
    		   return "Adminhome";
    	 
}
    	   @GetMapping("/playsongs")
    	   public String playSongs(Model model) { 
    		   
    		   
    		   boolean premium =true;
    		   if(premium) {
    			  
    		    List<Song> songslist=songService.fetchAllSongs();
    		    model.addAttribute("songs",songslist);
    		    
    		    System.out.println("songlist");
    		    return "viewsongs";
    		   }else {
    		  
    		  return "pay";
    	   } 
    	   }
    		   @GetMapping("/viewsongs")
        	   public String viewSongs(Model model) { 
        		   
        		   
        		 
        			  
        		    List<Song> songslist=songService.fetchAllSongs();
        		    model.addAttribute("songs",songslist);
        		    
        		    System.out.println("songlist");
        		    return "viewsongs";
        		   
}
}

