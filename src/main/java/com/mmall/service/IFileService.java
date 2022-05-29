package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author bruce
 * 2022/5/23 18:54
 */

public interface IFileService {

    String upload(MultipartFile file, String path);

}
