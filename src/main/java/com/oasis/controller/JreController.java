package com.oasis.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oasis.JreService;
import com.oasis.model.JreModel;
import com.oasis.utils.AppConfig;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JreController {

	private AppConfig appConfig;
	@Autowired
	private JreService jreService;

	/**
	 * @param appConfig
	 */
	@Autowired
	public JreController(AppConfig appConfig) {
		super();
		this.appConfig = appConfig;

	}

	@GetMapping(value = "getalljre")
	private ArrayList<JreModel> getJreList() {
		System.out.println("request hit from UI");
		ArrayList<JreModel> response = null;
		try {
			response = jreService.getAllJre(appConfig.getJrePath());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping(value = "search/{searchkey}")
	private ArrayList<JreModel> searchJre(@PathVariable(value = "searchkey") String searchkey) {
		System.out.println("request come from ui with text->" + searchkey);
		ArrayList<JreModel> response = jreService.searchJre(appConfig.getJrePath(), searchkey);
		return response;
	}

	@GetMapping(value = "download/{jrename}")
	public void download(@PathVariable(value = "jrename") String jrename,HttpServletResponse response) throws IOException, URISyntaxException {
		System.out.println("download request->"+jrename);
		ArrayList<JreModel> jreList = jreService.searchJre(appConfig.getJrePath(), jrename);
		String filePath =  jreList.get(0).getLocation();
		URI uri = new URI(filePath);
		String path = uri.getPath();
		uri.getPath();
		File downloadFile= new File(filePath);
		byte[] isr = Files.readAllBytes(downloadFile.toPath()
				);
	    ByteArrayOutputStream out = new ByteArrayOutputStream(isr.length);
	    out.write(isr, 0, isr.length);

	    response.setContentType("application/zip");
	    // Use 'inline' for preview and 'attachement' for download in browser.
	    response.addHeader("Content-Disposition", "inline; filename=" + jrename);

	    OutputStream os;
	    try {
	        os = response.getOutputStream();
	        out.writeTo(os);
	        os.flush();
	        os.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
		

}
