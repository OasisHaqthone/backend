package com.oasis;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import com.oasis.model.JreModel;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Service
public class JreService {

	public ArrayList<JreModel> getAllJre(String jrePath) throws JSONException {
		File directory = new File(jrePath);
		ArrayList<JreModel> jreList = new ArrayList<JreModel>();
	    File[] fList = directory.listFiles();
	    int i = 0;
	    if(fList != null)
	        for (File file : fList) {      
	            if (file.isFile()) {
	            	i++;
	            	JreModel model =  new JreModel(i,file.getName(), "java.awt.im,java.awt.im.spi,java.awt.image", file.getAbsolutePath().replace("\\", "//"));
	            	jreList.add(model);
	            }
	            
	        }
	    return jreList;
	    }
	
	public ArrayList<JreModel> searchJre(String jrePath,String SearchText) throws JSONException {
		File directory = new File(jrePath);
		ArrayList<JreModel> jreList = new ArrayList<JreModel>();
	    File[] fList = directory.listFiles();
	    int i = 0;
	    if(fList != null)
	        for (File file : fList) {      
	            if (file.isFile()) {
	            	i++;
					if (file.getName() != null && file.getName().matches(SearchText)) {
						JreModel model = new JreModel(i, file.getName(), "java.awt.im,java.awt.im.spi,java.awt.image",
								file.getAbsolutePath().replace("\\", "//"));
						jreList.add(model);
					}
	            }
	            
	        }
	    return jreList;
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
}
