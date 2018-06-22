package com.wisely.highlight_springmvc4.web.ch4_5;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	/**
	 * 文件上传的例子
	 * @param file
	 * @return
     */
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file) {//1
		
			try {
				FileUtils.writeByteArrayToFile(new File("d:/upload/"+file.getOriginalFilename()),
						file.getBytes()); //2
				return "ok";
			} catch (IOException e) {
				e.printStackTrace();
				return "wrong";
			}
			
		
	}

}
