package com.oasis.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oasis.model.JreModel;
import com.oasis.model.JrePackage;
import com.oasis.repo.JrePackageRepo;
import com.oasis.repo.JreRepo;
import com.oasis.utils.AppConfig;
import com.oasis.utils.AppConstants;
import com.oasis.utils.JREUtil;

@Service
public class JreService {

	@Autowired
	JreRepo repo;
	@Autowired
	JrePackageRepo packageRepo;
	@Autowired
	AppConfig appConfig;
	
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

	public void createCustomJre(List<JrePackage> jrePackage, HttpServletResponse response) throws IOException, InterruptedException {
		String selectedPackage = jrePackage.stream().map(packages -> packages.getPackageName())
				.collect(Collectors.joining(","));
		String jlinkPath = "C://Users//ARJUN//Downloads//openjdk-11.0.1_windows-x64_bin//jdk-11.0.1//bin//jlink.exe";
		long dateTime = System.currentTimeMillis();
		String newFileName =AppConstants.BASE_FILE_NAME+dateTime;
		Optional<String> res=	JREUtil.buildJre(jlinkPath, appConfig.getJrePath(), selectedPackage,newFileName);
		if(!res.isPresent()) {
			repo.save(new JreModel(1, newFileName, selectedPackage,appConfig.getJrePath()+File.separator+newFileName+".zip"));
			
			JreModel jre = findJre(newFileName);
			String filePath =  jre.getLocation();
			File downloadFile= new File(filePath);
			byte[] isr = Files.readAllBytes(downloadFile.toPath()
					);
		    ByteArrayOutputStream out = new ByteArrayOutputStream(isr.length);
		    out.write(isr, 0, isr.length);

		    response.setContentType("application/zip");
		    // Use 'inline' for preview and 'attachement' for download in browser.
		    response.addHeader("Content-Disposition","attachment; filename=\"" +newFileName + "\";");
		    response.flushBuffer();
		    OutputStream os;
		    try {
		        os = response.getOutputStream();
		        out.writeTo(os);
		        os.flush();
		        os.close();
		       
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}else {
			response.addHeader("Content-Disposition",res.get());
		}
			
		
	}
}
