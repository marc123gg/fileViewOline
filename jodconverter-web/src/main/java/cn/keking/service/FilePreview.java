package cn.keking.service;

import cn.keking.model.FileAttribute;
import org.springframework.ui.Model;

/**
 * Created by marc on 2020/9/17.
 * Content :
 */
public interface FilePreview {
    String filePreviewHandle(String url, Model model, FileAttribute fileAttribute);
}
