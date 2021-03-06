package shaomai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shaomai.model.Response;
import shaomai.service.UploadService;

import java.io.IOException;

import static shaomai.exception.Code.OK_STATUS;

@RestController
public class UploadMdFileController {
    protected UploadService uploadService;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 上传文章 markdown 格式
     * @param file 文章
     * @param title  文章标题
     * @param author 文章作者
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadMdFile", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> uploadMdFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("author") String author
    ) throws IOException {
        uploadService.uploadFile(file, title, author);
        Response<Boolean> response = new Response<>(OK_STATUS, "文件上传成功", true);
        return response;
    }

}

