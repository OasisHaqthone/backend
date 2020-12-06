package com.oasis.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.zip.ZipOutputStream;

public class JREUtil {
	

	public static Optional<String> buildJre(String jlinkPath, String outputFolder, String modules, String fileName) throws IOException, InterruptedException

	{
		StringBuilder cmd = new StringBuilder();
		cmd.append(jlinkPath);
		cmd.append(" --output ");
		cmd.append(outputFolder);
		cmd.append(File.separator + fileName);
		cmd.append(" --add-modules ");
		cmd.append(modules);

		Runtime run = Runtime.getRuntime();

		Process proc = run.exec(cmd.toString());
		proc.waitFor();  
		BufferedReader lineReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        Optional<String> res = lineReader.lines().findFirst();
        
		if (proc.exitValue() == 0 && !res.isPresent() ) {

			FileOutputStream fos = new FileOutputStream(outputFolder+File.separator+fileName + ".zip");
			ZipOutputStream zipOut = new ZipOutputStream(fos);
			File fileToZip = new File(outputFolder+File.separator + fileName);

			ZipUtil.zipFile(fileToZip, fileToZip.getName(), zipOut);
			zipOut.close();
			fos.close();
			
		}

		return res;
	}

}
