package com.oasis.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oasis.model.JreModel;
import com.oasis.model.JrePackage;
import com.oasis.repo.JrePackageRepo;
import com.oasis.repo.JreRepo;

@Service
public class JreService {

	@Autowired
	JreRepo repo;
	@Autowired
	JrePackageRepo packageRepo;

	public Iterable<JreModel> getAllJre(String jrePath) {

		return repo.findAll();
	}

	public List<JreModel> searchJre(String searchKey) throws JSONException {

		return repo.searchJreByName(searchKey);
	}
	
	public JreModel findJre(String searchKey) throws JSONException {

		return repo.findJreByName(searchKey);
	}

	public Resource getResource(String filePath) throws Exception {
		Resource resource;
		try {
			Path path = Paths.get(filePath);
			resource = new UrlResource(path.toUri());
			if (resource.exists()) {
				return resource;
			}
		} catch (MalformedURLException ex) {
			throw new Exception("File not found " + filePath, ex);
		}

		return resource;
	}
	
	public Page<JrePackage> getAllJREPackages(Pageable requestedPage) {

		return packageRepo.findAll(requestedPage);
	}
}
