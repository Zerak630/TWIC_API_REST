package com.controller;

import com.entity.Ville;
import com.model.VilleModel;
import com.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VilleController {
	
	@Autowired
	VilleRepository villeRepository;
	
	@GetMapping("/ville")
	@ResponseBody
	public List<Ville> getVille(@RequestParam(required = false, value = "codePostal") String codePostal) {
		System.out.println("Get une ville");

		if(codePostal != null) {
			List<Ville> liste = villeRepository.findByCodePostal(codePostal);
			System.out.println(liste);
			return liste;
		} else {
			return villeRepository.findAll();
		}
	}

	@GetMapping("/villeByCodeCommune")
	@ResponseBody
	public Ville getVilleByINSEE(@RequestParam(required = false, value = "codeCommune") String codeINSEE) {
		System.out.println("Get une ville");

		if(codeINSEE != null) {
			Ville ville = villeRepository.findByCodeCommune(codeINSEE);
			System.out.println(ville);
			return ville;
		} else {
			return null;
		}
	}

	@PostMapping("/ville")
	@ResponseBody
	public ResponseEntity<String> addVille(@RequestBody VilleModel model) {
		villeRepository.save(new Ville(model));

		return ResponseEntity.status(HttpStatus.CREATED).body("Ville ajoutée !");
	}

	@PutMapping("/ville")
	@ResponseBody
	public ResponseEntity<String> updateVille(@RequestBody VilleModel model) {
		Ville ville = villeRepository.findByCodeCommune(model.getCodeCommune());

		ville.setNomCommune(model.getNomCommune());
		ville.setCodePostal(model.getCodePostal());
		ville.setLibelleAcheminement(model.getLibelleAcheminement());
		ville.setLigne(model.getLigne());
		ville.setLatitude(model.getLatitude());
		ville.setLongitude(model.getLongitude());

		villeRepository.save(ville);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Ville mise à jour !");
	}

	@DeleteMapping("/ville")
	@ResponseBody
	public ResponseEntity<String> deleteVille(@RequestParam(required = true, value = "codeINSEE") String codeINSEE) {
		villeRepository.deleteByCodeCommune(codeINSEE);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Ville supprimée !");
	}
}
