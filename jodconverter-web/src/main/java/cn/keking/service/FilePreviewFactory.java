package cn.keking.service;

import cn.keking.model.FileAttribute;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by kl on 2018/1/17.
 * Content :
 */
@Service
public class FilePreviewFactory {

    private final ApplicationContext context;

    public FilePreviewFactory(ApplicationContext context) {
        this.context = context;
    }

    public FilePreview get(FileAttribute fileAttribute) {
        Map<String, FilePreview> filePreviewMap = context.getBeansOfType(FilePreview.class); //返回包含各个类型的预览类映射
        return filePreviewMap.get(fileAttribute.getType().getInstanceName());          //根据传递过来的类型，创建一个对应的预览枚举
    }
}
