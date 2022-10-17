package boke.boke.controller;

import boke.boke.entity.dto.SearchResult;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import boke.boke.util.ImageUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 *  文件上传
 */
@RestController
@RequestMapping("/files")
public class FileController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 图片上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public SearchResult<String> upload(MultipartFile file) {
        synchronized (FileController.class) {
            //原图路径
            String filePath = System.getProperty("user.dir") + "/src/main/resources/static/file/";
            //压缩图片的路径
            String filePathcom = System.getProperty("user.dir") + "/src/main/resources/static/compress/file/";
            String fileName = file.getOriginalFilename();//文件名称
            String flag =System.currentTimeMillis() + "-" + fileName;//文件名称+随机数拼接
            try {
                File filecom = FileUtil.writeBytes(file.getBytes(), filePath + flag);//将获取到的文件写入文件夹中
                System.out.println(fileName + "--上传成功");
                //判断上传的是否是png图片
                boolean suf = false;//文件后缀
                if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
                    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    if ("jpg".equalsIgnoreCase(suffix)){
                        suf=true;
                        //对于是jpg但小于500kb就直接输出
                        long length = filecom.length();
                        if (length/1024 <=500){
                            FileUtil.writeBytes(file.getBytes(), filePathcom + flag);//将获取到的文件写入文件夹中
                            SearchResult<String> success = SearchResult.success(flag);
                            success.setMsg(flag);
                            return success;
                        }
                    }
                }
                //压缩png图片
//                    File outfile=new File(filePath + flag);
//                    PngCompressor.compress(filecom,outfile);
                    File imgFile = null;
                    try {
                        //获取图片路径
                        String outfileName = filecom.getAbsolutePath();
                        //将图片格式更改
                        String newName =filePathcom + flag;
                        FileOutputStream fos = new FileOutputStream(newName);
                        //将需要压缩的文件、压缩后的文件对象、压缩后的宽、高放入(会根据放入的宽高和原图的比例来设置压缩的比例)
                        ImageUtil.thumbnail_w_h(filecom, 700, 375, fos,suf);
                        fos.close();
                        imgFile = new File(newName);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.err.println(fileName + "--文件上传失败");
                    }
/*                    finally {//取消删除压缩，压缩图片做主页列表查询的图片，存储在另一个文件夹中，但其文件夹下的目录和其一样，在显示压缩图片时直接在路径属性前拼接文件路径就行了
                        //删除原有png图片
                        boolean delete = FileUtil.del(filecom);
                        if (delete){
                            System.out.println("删除成功");
                        }
                    }
                    */
                Thread.sleep(1L);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(fileName + "--文件上传失败");
            }
            SearchResult<String> success = SearchResult.success(flag);
            success.setMsg(flag);
            return success;
        }
    }

    /**
     * 上传友链头像
     *
     * @param file
     * @return
     */
    @PostMapping("/friendupload")
    public SearchResult<String> friendupload(MultipartFile file) {
        synchronized (FileController.class) {
            String filePath = System.getProperty("user.dir") + "/src/main/resources/static/friend/fileimage/";
            String fileName = file.getOriginalFilename();
            String flag =System.currentTimeMillis() + "-" + fileName;
            try {
                FileUtil.writeBytes(file.getBytes(),filePath +flag);
                System.out.println(fileName + "--上传成功");
                Thread.sleep(1L);
            } catch (Exception e) {
                System.err.println(fileName + "--文件上传失败");
            }
            SearchResult<String> success = SearchResult.success(flag);
            success.setMsg(flag);
            return success;
        }
    }

    /**
     * 获取文件
     *
     * @param flag
     * @param response
     */
    @GetMapping("/{flag}")
    public void avatarPath(@PathVariable String flag, HttpServletResponse response) {
        OutputStream os;
        String basePath = System.getProperty("user.dir") + "/src/main/resources/static/file/";
        List<String> fileNames = FileUtil.listFileNames(basePath);
        String avatar = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");
        try {
            if (StrUtil.isNotEmpty(avatar)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(avatar, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + avatar);
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }


    /**
     * 删除文件
     *
     * @param flag
     */
    @DeleteMapping("/{flag}")
    public void delFile(@PathVariable String flag) {
        String basePath = System.getProperty("user.dir") + "/src/main/resources/static/file/";
        List<String> fileNames = FileUtil.listFileNames(basePath);
        String filename = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");
        FileUtil.del(basePath + filename);
        System.out.println("删除文件" + filename + "成功");
    }

}
