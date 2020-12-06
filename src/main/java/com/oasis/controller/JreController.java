package com.oasis.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oasis.model.JreModel;
import com.oasis.model.JrePackage;
import com.oasis.model.PagenationResponse;
import com.oasis.service.JreService;
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
	private Iterable<JreModel> getJreList() {
		System.out.println("request hit from UI");
		Iterable<JreModel> response = null;
		try {
			response = jreService.getAllJre(appConfig.getJrePath());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping(value = "search/{searchkey}")
	private List<JreModel> searchJre(@PathVariable(value = "searchkey") String searchkey) {
		System.out.println("request come from ui with text->" + searchkey);
		List<JreModel> response = jreService.searchJre(searchkey.toUpperCase());

		return response;
	}

	@GetMapping(value = "download/{jrename}")
	public void download(@PathVariable(value = "jrename") String jrename, HttpServletResponse response)
			throws IOException, URISyntaxException {
		System.out.println("download request->" + jrename);
		JreModel jre = jreService.findJre(jrename);
		String filePath = jre.getLocation();
		File downloadFile = new File(filePath);
		byte[] isr = Files.readAllBytes(downloadFile.toPath());
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

	@GetMapping("/getalljrepackages")
	public PagenationResponse retrieveCustomer(@Param(value = "packageName") String packageName,
			@Param(value = "page") int page, @Param(value = "size") int size) {
		Page<JrePackage> jrePackagePages = null;
		Pageable requestedPage = PageRequest.of(page, size);
		jrePackagePages = jreService.getAllJREPackages(requestedPage);

		PagenationResponse res = new PagenationResponse(jrePackagePages.getContent(), jrePackagePages.getTotalPages(),
				jrePackagePages.getNumber(), jrePackagePages.getSize());

		return res;
	}

	@PostMapping(value = "/buildjre")
	private void buildJre(@RequestBody List<JrePackage> jrePackage, HttpServletResponse response) {

		try {
			jreService.createCustomJre(jrePackage, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
